package com.liuzhaoxin.classloader.initialize;

public class Singleton {
    private static Singleton instance = new Singleton();
    private static int x = 0;
    private static int y;

    private Singleton() {
        ++x;
        ++y;
    }

    /**
     * 链接的时候：
     * 1. instance = null
     * 2. x = 0
     * 3. y = 0
     *
     * 初始化的时候：
     * instance = new Singleton();
     *  x++ => x=1
     *  y++ => y=1
     *
     * x = 0
     * y = 1
     *
     * @return
     */
    public static Singleton getInstance() {
        return Singleton.instance;
    }

    public static void main(String[] args) {
        final Singleton instance = getInstance();
        System.out.println(instance.x);
        System.out.println(instance.y);
    }
}
