package creational.singleton;

import java.util.stream.IntStream;

public class SingletonObject {
    private SingletonObject() {
    }

    private enum Singleton {
        INSTANCE;

        private final SingletonObject singleton;

        Singleton() {
            singleton = new SingletonObject();
        }

        public SingletonObject getSingleton() {
            return singleton;
        }
    }

    public static SingletonObject getSingleton() {
        return Singleton.INSTANCE.getSingleton();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i -> new Thread(String.valueOf(i)) {
            @Override
            public void run() {
                System.out.println(SingletonObject.getSingleton());
            }
        }.start());

    }
}
