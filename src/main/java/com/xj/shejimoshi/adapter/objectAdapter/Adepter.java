package com.xj.shejimoshi.adapter.objectAdapter;

/**
 * Created by xiong on 2018/3/7.
 */
public class Adepter implements Targetable {

    private Source source;

    public Adepter(Source source){
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is method2");
    }

}
