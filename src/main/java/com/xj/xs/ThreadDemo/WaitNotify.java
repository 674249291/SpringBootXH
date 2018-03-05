package com.xj.xs.ThreadDemo;

/**
 * Created by xiong on 2018/2/9.
 */
public class WaitNotify {

    final OutPut outPut = new OutPut();

    public static void main(String[] args) {
        new WaitNotify().init();
    }

    public void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                outPut.say(100);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                outPut.say2(100);
            }



        }).start();
    }

    class OutPut{

        private boolean bShow = true;

        public synchronized void say(int count){
            while (!bShow){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i<count; i++){
                System.out.println("第一种说法：" + i);
            }
            bShow = false;
            this.notify();
        }

        public synchronized void say2(int count){
            while (bShow){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i<count; i++){
                System.out.println("第二种说法：" + i);
            }
            bShow = true;
            this.notify();
        }

    }
}
