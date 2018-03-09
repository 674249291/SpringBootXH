package com.xj.shejimoshi.chainofResponsibility;

/**
 * Created by xiong on 2018/3/9.
 */
public abstract class AbstractHandler {

    private Handle handle;

    public Handle getHandle(){
        return handle;
    }

    public void setHandle(Handle handle){
        this.handle = handle;
    }
}
