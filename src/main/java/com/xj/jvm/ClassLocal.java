package com.xj.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by xiong on 2018/3/19.
 */
public class ClassLocal {

    public static void main(String[] args) {
        SoftReference<String> sr = new SoftReference<String>(new String("Hello"));
        System.gc();
        System.out.println(sr.get());

        WeakReference<String> wr = new WeakReference<String>(new String("word"));
        System.gc();
        System.out.println(wr.get());
    }
}
