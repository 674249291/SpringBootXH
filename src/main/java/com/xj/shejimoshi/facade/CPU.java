package com.xj.shejimoshi.facade;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by xiong on 2018/3/7.
 *
 * cpu 组件
 */
public class CPU {

    public void startup(){
        System.out.println("cpu startup ");
    }

    public void shutdown(){
        System.out.println("cpu shutdown");
    }
}
