package basic_class_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuzhaoxin
 */
public class SynchronizedExample {

    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() +":"+ i);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());
    }

}

