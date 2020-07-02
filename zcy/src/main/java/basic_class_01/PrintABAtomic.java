package basic_class_01;


/**
 * @author liuzhaoxin
 */
public class PrintABAtomic {
    public static int i = 1;

    private static byte[] block = new byte[0];

    public static boolean flag = false;

    private static final int MAX_PRINT_NUM = 100;

    /**
     * 使用synchronized、wait、notifyAll来实现两个线程的交替打印
     */
    public static void printAB() {
        new Thread(() -> {
            while (i < MAX_PRINT_NUM) {
                synchronized (block) {
                    if (flag) {
                        try {
                            block.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + (i++));
                        flag = true;
                        block.notifyAll();
                    }

                }
            }
        }).start();

        new Thread(() -> {
            while (i < MAX_PRINT_NUM) {
                synchronized (block) {
                    if (!flag) {

                        try {
                            block.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + (i++));
                        flag = false;
                        block.notifyAll();
                    }

                }
            }
        }).start();
    }


    public static void main(String[] args) {
        // 用于通信的库存类
        Stock1 computer = new Stock1();
        // 定义两个生产者和两个消费者
        Thread p1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    computer.produce("Mac");
                }
            }
        });

        Thread c1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    computer.consume();
                }
            }
        });
        p1.start();
        c1.start();
    }
}


class Stock1 {
    private static Object LOCK = new Object();
    private String computer;
    private boolean hasComputer = false;

    public synchronized void produce(String computer) {
        while (hasComputer) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.computer = computer;
        System.out.println("生产了：" + this.computer);
        this.hasComputer = true;
        this.notify();

    }


    public synchronized void consume() {
        while (!hasComputer) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费了：" + this.computer);
        this.hasComputer = false;
        this.notify();


    }
}

/**
 * 生产者消费者模式
 */
class Stock {
    private String name;
    // 标记库存是否有内容
    private boolean hasComputer = false;

    public synchronized void putOne(String name) {
        // 若库存中已有内容，则生产线程阻塞等待
        while (hasComputer) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        System.out.println("生产者...生产了 " + name);
        // 更新标记
        this.hasComputer = true;
        // 这里用notify的话，假设p0执行完毕，此时c0,c1都在wait, 同时唤醒另一个provider:p1，
        // p1判断标记后休眠，造成所有线程都wait的局面，即死锁；
        // 因此使用notifyAll解决死锁问题
        this.notifyAll();
    }

    public synchronized void takeOne() {
        // 若库存中没有内容，则消费线程阻塞等待生产完毕后继续
        while (!hasComputer) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者...消费了 " + name);
        this.hasComputer = false;
        this.notifyAll();
    }
}