package com.liuzhaoxin.classloader.initialize;

public class Singleton01 {
    private static int x = 0;
    private static int y;
    private static Singleton01 instance = new Singleton01();


    private Singleton01() {
        ++x;
        ++y;
    }

    /**
     * 链接的时候：
     * 1. x = 0
     * 2. x = 0
     * 3. instance = null
     *
     * 初始化的时候:
     * 1.x = 0
     * 2.y = 0
     * instance = new Singleton01();
     *  x++ => x =1
     *  y++ => y =1
     * @return
     */
    public static Singleton01 getInstance() {
        return Singleton01.instance;
    }

    public static void main(String[] args) {
        final Singleton01 instance = getInstance();
        System.out.println(instance.x);
        System.out.println(instance.y);
    }
}
