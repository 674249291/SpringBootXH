package com.xj.shejimoshi.state;

/**
 * 状态的切换
 * Created by xiong on 2018/3/10.
 */
public class TestStae {

    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);

        state.setValue("state1");
        context.method();

        state.setValue("state2");
        context.method();
    }
}
