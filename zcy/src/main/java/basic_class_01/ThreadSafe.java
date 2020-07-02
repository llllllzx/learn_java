package basic_class_01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuzhaoxin
 */
public class ThreadSafe {
    public static void main(String[] args) {
        Ticket t = new Ticket();//创建一个线程任务对象。
        //创建4个线程同时卖票
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class Ticket implements Runnable {
    // 当前拥有的票数
    private int num = 100;
    ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        while (true) {
            lock.lock();
            if (num > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                // 输出卖票信息
                System.out.println(Thread.currentThread().getName() + ".....sale...." + num--);
            }
            lock.unlock();
        }

    }
}