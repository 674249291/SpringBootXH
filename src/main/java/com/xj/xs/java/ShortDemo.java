package com.xj.xs.java;

/**
 * Created by xiong on 2018/3/20.
 */
public class ShortDemo {

    public static void main(String[] args) {
        short s1 = 1;
        s1 += 1;
        System.out.println("s1: " + s1);

        //这样的加的话就要强行转换了，s1会自动提升数据类型为int，int向下赋值则要强转，不然出现报错，向上转型就不需要强转，这就java的多态的体现
        s1 = (short) (s1 + 1);
        System.out.println("s1: " + s1);

        short s2 = 2;

        switch (s2){
            case 1:
                System.out.println("德玛");
                break;
            case 2:
                System.out.println("剑圣");
                break;
            default:
                System.out.println("英雄联盟");
        }

    }
}
