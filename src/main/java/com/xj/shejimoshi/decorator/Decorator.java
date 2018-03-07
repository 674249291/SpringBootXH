package com.xj.shejimoshi.decorator;

/**
 * Created by xiong on 2018/3/7.
 */
public class Decorator implements SourceAble {

    private Source source;

    public Decorator (Source source){
        this.source = source;
    }

    @Override
    public void method1() {
        System.out.println("before");
        source.method1();
        System.out.println("after");
    }

}
