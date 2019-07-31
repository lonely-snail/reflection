package com.dianju.jvm;

public class Demo {

    public static void main(String[] args) {
        Object   obeject = new Object();
        System.out.println(obeject.getClass().getClassLoader());
        Demo  demo = new Demo();
        System.out.println(demo.getClass().getClassLoader());
    }
}
