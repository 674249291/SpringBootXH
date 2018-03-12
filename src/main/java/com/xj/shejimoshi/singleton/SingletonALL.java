package com.xj.shejimoshi.singleton;

/**
 * Created by xiong on 2018/3/12.
 */
public class SingletonALL {

    private SingletonALL(){

    }

    /**
     * 私有的静态内部类
     * 解释：由于一个静态单例对象没有作为singleton变量直接实例化，因此加载的时候不会实例化singileton，
     * 第一次调用的getInstance的时候加载内部类HolderClass，在内部定义了一个static类型的变量instance，首先此时会初始化这个成员变量，由于java虚拟机来保证其线程的安全性
     * 确保该成员只初始化一次，由于getInstance没有任何线程锁定，因此性能不会造成任何影响
     */
    private static class HolderClass{
        private final static SingletonALL instance = new SingletonALL();
    }

    public static SingletonALL getInstance(){
        return HolderClass.instance;
    }

    public static void main(String[] args) {
        SingletonALL s1,s2;
        s1 = SingletonALL.getInstance();
        s2 = SingletonALL.getInstance();

        if(s1 == s2){
            System.out.println("s1 = s2 ,这是一个单例模式");
            System.out.println(s1.toString());
            System.out.println(s2.toString());
        }
    }
}
