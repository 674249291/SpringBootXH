package com.xj.shejimoshi.observer;

/**
 * Created by xiong on 2018/3/9.
 */
public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 has received");
    }
}
