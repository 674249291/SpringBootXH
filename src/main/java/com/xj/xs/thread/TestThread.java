package com.xj.xs.thread;


import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/11/6.
 */
public class TestThread {


    protected static class ThreadRunnable implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("你好！！！！");
            }
        }
    }

    protected static class MyTask implements Runnable{

        private int taskNum;

        public MyTask(int taskNum){
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            System.out.println("正在执行的task:" + taskNum);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task" +taskNum + "执行完毕");

        }
    }

    public static void main(String [] args){
        /*Thread thread = new Thread(new ThreadRunnable());
        thread.start();*/

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0;i < 15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+",队列中等待执行的任务数目："+executor.getQueue().size()+
                ",已执行的完的任务数目："+executor.getCompletedTaskCount()
            );

        }
        executor.shutdown();

        /*ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new MyTask(1));
        executorService.submit(new MyTask(2));
        executorService.shutdown();*/


        //ExecutorService executorService = Executors.newCachedThreadPool();

    }
}
