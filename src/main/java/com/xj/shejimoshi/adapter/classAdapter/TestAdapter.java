package com.xj.shejimoshi.adapter.classAdapter;

/**
 * 核心思想就是：有一个Source类，拥有一个方法，待适配，目标接口时Targetable，通过Adapter类，将Source的功能扩展到Targetable里
 * Created by xiong on 2018/3/7.
 */
public class TestAdapter {

    public static void main(String[] args) {
        Targetable targetable = new Adepter();
        targetable.method1();
        targetable.method2();
    }

}
