package com.xj.xs.thread;


import java.util.concurrent.*;

/**
 * Created by ${xiong} on 2017/11/7.
 */
public class ThreadFutureTask {

    /**
     * 线程安全的hashMap
     */
    private static ConcurrentHashMap<String, FutureTask> hashMap = new ConcurrentHashMap<String, FutureTask>();
    /*private static ExecutorService executorService = new ThreadPoolExecutor(5, 15,
            200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));*/
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void processFile(String fileName){
        FutureTask data = hashMap.get(fileName);
        if (data == null){
            data = newFutureTask(fileName);
            FutureTask old = hashMap.putIfAbsent(fileName,data);
            if(old == null){
                old = data;
            }
            executorService.submit(data);

            try {
                String d = (String) data.get();
                System.out.println(d);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            executorService.shutdown();
        }
    }

    public static FutureTask<String> newFutureTask(final String fileName){
        return new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return readFile(fileName);
            }
            private String readFile(String fileName){
                System.out.println("执行到这里了。");
                return fileName;
            }
         });
    }

    public static void main(String[] args) {
        processFile("xiongjun");
    }
}
