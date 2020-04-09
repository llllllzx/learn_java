package com.liuzhaoxin.classloader.initialize;


import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        //System.out.println(Obj1.salary);//Obj类不会被初始化
        System.out.println(Obj1.x);//Obj类会被初始化
    }
}

class Obj1 {
    public static final long salary = 100000L;//final 修饰的常量会在编译期间放到常量池中
    public static final int x = new Random().nextInt(100);//在编译期间无法计算得出

    static {
        System.out.println("Obj被初始化了。。。");
    }
}