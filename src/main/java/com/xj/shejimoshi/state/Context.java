package com.xj.shejimoshi.state;

/**
 * Created by xiong on 2018/3/10.
 */
public class Context {

    /**
     * 状态模式的切换类
     */

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void method(){
        if (state.getValue().equals("state1")){
            state.method1();
        }else if (state.getValue().equals("state2")){
            state.method2();
        }
    }
}
