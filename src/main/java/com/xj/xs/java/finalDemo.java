package com.xj.xs.java;

/**
 * Created by xiong on 2018/3/20.
 */
public class finalDemo {

    public static void main(String[] args) {
        final String a = "xiong";
        //指定的变量是不能变的
        //a = "jun";

        final StringBuffer buffer = new StringBuffer("xiong");
        //引用变量所指向的对象中的内容还是可以改变的,就如对象一样，也是可以改变其中的数值的
        buffer.append("jun");
        System.out.println(buffer.toString());
    }
}
