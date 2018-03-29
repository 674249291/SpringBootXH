package com.xj.xs.java;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 接口可以继承接口。抽象类可以实现(implements)接口，抽象类可以继承具体类。抽象类中可以有静态的main方法。
 *
 * 16、Java中实现多态的机制是什么？
 靠的是父类或接口定义的引用变量可以指向子类或具体实现类的实例对象，而程序调用的方法在运行期才动态绑定，
 就是引用变量所指向的具体实例对象的方法，也就是内存里正在运行的那个对象的方法，而不是引用变量的类型中定义的方法。
 * Created by xiong on 2018/3/20.
 */
public abstract class abstractDemo extends User {

    abstract void fun1();

    public static void main(String[] args) {
        System.out.println("你好");

        Integer a = 10;
        System.out.println(a.hashCode());

        User user = new User();
        user.setName("xiong");

        System.out.println(user.hashCode());


    }
}
