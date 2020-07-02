package creational.singleton;


import java.sql.Statement;

public class LazySingleton {
    //必须使用volatile修饰
    private volatile static LazySingleton singleton = null;

    private LazySingleton() {
        //empty
    }

    //double check
    public LazySingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return LazySingleton.singleton;
    }
}


class Singleton1 {
    private volatile static Singleton1 singleton1 = null;

    //私有构造器
    private Singleton1() {

    }

    public Singleton1 getInstance() {
        if (singleton1 == null) {
            synchronized (Singleton1.class) {
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}

class Singletion2 {

    private Singletion2() {
        /**
         * 各种资源的初始化
         */
    }

    private static class Singletion2Holder {
        private static Singletion2 singletion2 = new Singletion2();
    }


    public static Singletion2 getInstance() {
        return Singletion2Holder.singletion2;
    }

}
