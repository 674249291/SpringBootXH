package com.xj.shejimoshi.strategy;

/**
 * 策略模式的决定权在用户，系统本身提供不同算法的实现，新增或者删除算法，对各种算法做封装。因此，策略模式多用在算法决策系统中，外部用户只需要决定用哪个算法即可
 * Created by xiong on 2018/3/8.
 */
public class TestStrategy {
    public static void main(String[] args) {
        ICalculator plus = new Plus();
        System.out.println(plus.calulcate("2+8"));

        ICalculator minus = new Minus();
        System.out.println(minus.calulcate("8-2"));
    }
}
