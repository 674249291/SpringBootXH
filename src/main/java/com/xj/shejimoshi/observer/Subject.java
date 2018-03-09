package com.xj.shejimoshi.observer;

/**
 * Created by xiong on 2018/3/9.
 */
public interface Subject {

    /**
     * 增加观察者
     * @param observer
     */
    public void add (Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    public void del(Observer observer);

    /**
     * 通知所有的观察者
     */
    public void notifyObservers();

    /**
     * 自身操作
     */
    public void operation();
}
