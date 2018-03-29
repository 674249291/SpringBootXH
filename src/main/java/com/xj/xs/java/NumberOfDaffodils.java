package com.xj.xs.java;

/**
 * Created by xiong on 2018/3/28.
 */
public class NumberOfDaffodils {
    public static void main(String[] args) {
        int hundred, ten, bits;
        System.out.println("水仙花数为：");
        for (int i = 100; i <= 999; i++)
        {
            hundred = i / 100;
            ten = i % 100 / 10;
            bits = i % 10;
            if (i == hundred * hundred * hundred + ten * ten * ten + bits * bits * bits)
            {
                System.out.print(i + "    ");
            }
        }
    }
}
