package com.xj.shejimoshi.chainofResponsibility;

/**
 * Created by xiong on 2018/3/9.
 */
public class MyHandler extends AbstractHandler implements Handle {

    private  String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + "deal!");
        if (getHandle() != null){
            getHandle().operator();
        }
    }
}
