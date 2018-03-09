package com.xj.shejimoshi.chainofResponsibility;

/**
 * 链接上的请求可以是一条链，可以是一个树，还可以是一个环，模式本身不约束这个，需要我们自己去实现，同时，在一个时刻，命令只允许由一个对象传给另一个对象，而不允许传给多个对象。
 * Created by xiong on 2018/3/9.
 */
public class Test {
    public static void main(String[] args) {

        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");
        h1.setHandle(h2);
        h2.setHandle(h3);

        h1.operator();
    }
}
