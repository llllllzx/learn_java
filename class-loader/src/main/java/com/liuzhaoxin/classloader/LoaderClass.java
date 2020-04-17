package com.liuzhaoxin.classloader;

/**
 * @author liuzhaoxin
 */
public class LoaderClass {
    public static void main(String[] args) {
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        MyObject myObject3 = new MyObject();
        MyObject myObject4 = new MyObject();

        System.out.println(myObject1.getClass() == myObject2.getClass());
        System.out.println(myObject1.getClass() == myObject3.getClass());
        System.out.println(myObject1.getClass() == myObject4.getClass());

        System.out.println(myObject1.getClass());
        System.out.println(myObject1.getClass().getClassLoader());
    }
}
class MyObject{

}
