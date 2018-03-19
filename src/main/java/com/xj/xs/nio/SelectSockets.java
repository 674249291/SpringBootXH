package com.xj.xs.nio;


import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/11/3.
 */
public class SelectSockets {

    public static int PORT_NUMBER = 1234;
    //对所有的通道使用相同的缓冲区。单线程为所有的通道进行服务，所以并发访问没有风险
    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    public static void main(String [] args) throws Exception {
        new SelectSockets().go(args);
    }

    public void  go(String[] agrs) throws Exception {

        int port = PORT_NUMBER;
        if(agrs.length > 1){
            port = Integer.parseInt(agrs[0]);
        }
        System.out.println("监听的端口号：" + port);
        // 打开一个未绑定的serversocketchannel
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // 得到一个ServerSocket去和它绑定
        ServerSocket serverSocket = socketChannel.socket();
        // 创建一个Selector供下面使用
        Selector selector = Selector.open();
        //设置server channel的监听端口
        serverSocket.bind(new InetSocketAddress(port));
        //设置成非阻塞模式
        socketChannel.configureBlocking(false);
        //将ServerSocketChannel注册到Selector
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            int n = selector.select();
            if (n == 0){
                continue;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                //判断是否是一个链接的到来
                if(selectionKey.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel channel = server.accept();
                    this.registerChannel(selector,channel,SelectionKey.OP_READ);
                    this.sayHello(channel);
                }
                //判断这个channel上面时候有数据要读
                if (selectionKey.isReadable()){
                    this.readDataFromSocket(selectionKey);
                }
                iterator.remove();
            }
        }
    }

    /**
     * Register the given channel with the given selector for the given
     * operations of interest
     */
    protected void registerChannel(Selector selector, SelectableChannel channel, int ops) throws Exception {
        if (channel == null) {
            return; // 可能会发生
        }
        // 设置通道为非阻塞
        channel.configureBlocking(false);
        // 将通道注册到选择器上
        channel.register(selector, ops);
    }

    private void sayHello(SocketChannel channel) throws Exception{
        buffer.clear();
        buffer.put("Hi there!\r\n".getBytes());
        buffer.flip();
        channel.write(buffer);
    }
    /**
     * Sample data handler method for a channel with data ready to read.
     * 对于一个准备读入数据的通道的简单的数据处理方法
     * @param key
     *
    一个选择器决定了和通道关联的SelectionKey object是准备读状态。如果通道返回EOF，通道将被关闭。
    并且会自动使相关的key失效，选择器然后会在下一次的select call时取消掉通道的注册
     */
    protected void readDataFromSocket(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        buffer.clear(); // 清空Buffer
        //当可以读到数据时一直循环，通道为非阻塞
        while ((count = socketChannel.read(buffer)) > 0) {
            buffer.flip(); // 将缓冲区置为可读
            //发送数据，不要期望能一次将数据发送完
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            //这里的循环是无意义的，具体按实际情况而定
            buffer.clear(); // Empty buffer
        }
        if (count < 0){
            // Close channel on EOF, invalidates the key
            //读取结束后关闭通道，使key失效
            socketChannel.close();
        }
    }


}
