package com.xj.shejimoshi.observer;

/**
 * Created by xiong on 2018/3/9.
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println(" update self");
        notifyObservers();
    }
}
