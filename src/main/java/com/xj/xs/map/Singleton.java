package com.xj.xs.map;

/**
 * Created by xiong on 2018/3/5.
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton(){

    }
    //单例模式的使用情况
    //饿汉模式的双重锁定
    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
