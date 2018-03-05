package com.xj.xs.map;

/**
 * Created by xiong on 2018/3/5.
 */
public class Kebiancanshu {
    public static void main(String[] args) {
        System.out.println(sum(1,2,3,4));
        System.out.println(sum(1,2,3,4,5));
        assertCompare(-10);
    }

    /**
     * 可变参数的使用的，体现在java的四大特性：多态
     * @param numbers
     * @return
     */
    public static int sum(int... numbers){
        int sum = 0;
        for (int n : numbers){
            sum += n;
        }
        return sum;
    }

    public static void assertCompare(int number){
        assert(number>0);
        return;
    }
}
