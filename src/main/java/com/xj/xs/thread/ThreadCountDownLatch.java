package com.xj.xs.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiong on 2018/2/2.
 */
public class ThreadCountDownLatch {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                latch.countDown();
                System.out.println("线程1执行中");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("countDownLatch:" + latch.getCount());
                latch.countDown();
                System.out.println("线程2执行中");
            }
        }).start();

        try {
            //只有等到countDownLatch中的个数为0的时候，才能被唤醒，继续执行。或者设置过期时间
            latch.await();
            System.out.println("线程1、2执行完成");
        }catch (Exception e){

        }

    }

}
