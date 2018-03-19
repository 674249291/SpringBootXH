package com.xj.xs.classLoad;

/**
 * Created by xiong on 2018/3/5.
 */
public class ClassLoader {
    static{
        System.out.println("this is static");
    }
}

class Main{

    Class[] classes = {ClassLoader.class};

    public static void main(String[] args) throws ClassNotFoundException {
        //要获取类的包名的全部名称
        Class.forName("com.xj.xs.classLoad.ClassLoader");
        System.out.println("this is main");
    }
}
