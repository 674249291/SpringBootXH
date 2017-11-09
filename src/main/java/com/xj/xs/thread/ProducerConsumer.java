package com.xj.xs.thread;

import java.util.concurrent.*;

/**
 * Created by ${xiong} on 2017/11/8.
 */
public class ProducerConsumer {

    //private volatile String name;
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Stroge stroge = producerConsumer.new Stroge();
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        System.out.println("CPU中最多可用的线程数据：" + corePoolSize);
        System.out.println("System.nanoTime():" + System.nanoTime());
        ExecutorService service = new ThreadPoolExecutor(corePoolSize, corePoolSize, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2000));

        Producer p1 = producerConsumer.new Producer("张三",stroge);
        Producer p2 = producerConsumer.new Producer("李四",stroge);
        Consumer consumer1 = producerConsumer.new Consumer("王五",stroge);
        Consumer consumer2 = producerConsumer.new Consumer("xiong",stroge);
        Consumer consumer3 = producerConsumer.new Consumer("tupeng",stroge);
        service.submit(p1);
        service.submit(consumer1);
        service.submit(consumer2);
        service.submit(consumer3);
        service.shutdown();

    }

    class Consumer implements Runnable{

        private String name;
        private Stroge stroge = null;

        public Consumer(String name, Stroge stroge) {
            this.name = name;
            this.stroge = stroge;
        }

        @Override
        public void run() {
            while (true){
                System.out.println(name + "准备消费产品");
                try {
                    Product product = stroge.pop();
                    System.out.println(name + "已消费产品" + product.toString());
                    System.out.println("===============================");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Producer implements Runnable {

        private String name;

        private Stroge stroge;

        public Producer(String name, Stroge stroge){
            this.name = name;
            this.stroge = stroge;
        }

        @Override
        public void run() {
            while (true){
                Product product = new Product((int) (Math.random()*1000));
                System.out.println(name + "准备生产" + product.toString());
                try {
                    stroge.push(product);
                    System.out.println(name + "已生产产品" + product.toString());
                    System.out.println("===============================");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 仓库，用来存放产品
     */
    public class  Stroge{

        //对列
        BlockingDeque<Product> queues  = new LinkedBlockingDeque<Product>(50);

        /**
         * 生产，把生产的东西放入到对列中
         * @param product
         * @throws InterruptedException
         */
        public void push(Product product) throws InterruptedException {
            queues.put(product);
        }

        /**
         * 消费者，消费仓库中的数据
         * @return
         * @throws InterruptedException
         */
        public Product pop() throws InterruptedException {
            return queues.take();
        }
    }

    /**
     * 产品
     */
    public class Product{

        private int id;

        public Product(Integer id){
            this.id = id;
        }
        @Override
        public String toString(){
            return "产品：" + id;
        }
    }

}
