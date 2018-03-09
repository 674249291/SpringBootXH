package com.xj.shejimoshi.Command;

/**
 * Created by xiong on 2018/3/9.
 */
public class MyCommand implements Commod {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
