package com.liuzhaoxin.classloader.initialize;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        /**
         * 输出：
         * Obj被初始化了
         * 100000
         */
        //System.out.println(Child.salary);//通过子类访问父类的static变量，不会导致子类被初始化
        /**
         * 输出：
         * Obj被初始化了
         * Child被初始化了
         * 25
         */
        //System.out.println(Child.age);
    }
}

class Obj {
    public static long salary = 100000L;

    static {
        System.out.println("Obj被初始化了");
    }
}

class Child extends Obj {
    public static int age = 25;

    static {
        System.out.println("Child被初始化了");
    }
}