package com.xj.shejimoshi.state;

/**
 * Created by xiong on 2018/3/10.
 */
public class State {

    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1(){
        System.out.println("this is method1");
    }

    public void method2(){
        System.out.println("this is method2");
    }

}
