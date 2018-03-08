package com.xj.shejimoshi.strategy;

/**
 * Created by xiong on 2018/3/8.
 */
public class Plus extends AbstractCalculator implements ICalculator {

    @Override
    public int calulcate(String exp) {

        int arrayInt[] = split(exp,"\\+");
        return arrayInt[0]+arrayInt[1];

    }
}
