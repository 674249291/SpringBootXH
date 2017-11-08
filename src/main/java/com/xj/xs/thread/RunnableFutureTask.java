package com.xj.xs.thread;

import java.util.concurrent.*;

/**
 * Created by ${xiong} on 2017/11/8.
 */
public class RunnableFutureTask {

    public static void main(String[] args) {
        runnableDemo();
        futureDemo();
    }

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    static void runnableDemo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnableDemo:" + fibc(20));
            }
        }).start();
    }

    static void  futureDemo(){
        try {
            Future<?> result = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    fibc(20);
                }
            });
            System.out.println("future result from runnable : " + result.get());

            Future<Integer> result2 = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return fibc(20);
                }
            });
            System.out.println("future reult form runnable: " + result2.get());

            FutureTask<?> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return fibc(20);
                }
            });

            executorService.submit(futureTask);
            System.out.println("future result from FutureTask:" + futureTask.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 效率底下的斐波那契数列, 耗时的操作
     * @param num
     * @return
     */
    static Integer fibc(int num){
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibc(num - 1) + fibc(num - 2);
    }
}
