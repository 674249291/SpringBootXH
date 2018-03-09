package com.xj.shejimoshi.Command;

/**
 * Created by xiong on 2018/3/9.
 */
public class Invoke {

    private Commod commod;

    public Invoke(Commod commod) {
        this.commod = commod;
    }

    public void action(){
        commod.exe();
    }
}
