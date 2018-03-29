package com.xj.xs.java;

import java.util.HashMap;

/**
 * Created by xiong on 2018/3/23.
 */
public class IntegerDemo {

    public static void main(String[] args) {
        Integer a = 3;
        Integer b = 3;
        int c = 3;
        Integer d = 300;
        Integer e = 300;
        int f = 300;
        System.out.println(a == b);//true
        System.out.println(a == c);//true
        System.out.println(d == e);//false
        System.out.println(e == f);//true

    }
}
