package com.xj.shejimoshi.facade;

/**
 * Created by xiong on 2018/3/7.
 */
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer(){
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup(){
        System.out.println("start the computer");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("finsh start the computer");
    }

    public void shutdown(){
        System.out.println("shutdown the computer");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("finsh shutdown the computer");
    }
}
