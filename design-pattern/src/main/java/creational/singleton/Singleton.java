package creational.singleton;

import org.w3c.dom.ls.LSOutput;

public class Singleton {

    private Singleton() {

    }

    private static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton() {
        return SingletonHolder.singleton;
    }

}
