package com.xj.xs.ThreadDemo;

import io.netty.util.concurrent.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiong on 2018/2/11.
 */
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "hello";
            }
        };
       // Future<String> future = threadPool.submit(call);
    }
}

