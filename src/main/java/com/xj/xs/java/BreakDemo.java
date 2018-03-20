package com.xj.xs.java;

/**
 * 使用标志跳出多层循环
 * Created by xiong on 2018/3/20.
 */
public class BreakDemo {

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6,7},{9}};
        boolean found =  false;

        for (int i = 0; i < a.length && !found; i++){
            for (int j = 0; j < a[i].length; j++){
                System.out.println("i=" + i + ",j=" + j);
                if (a[i][j] == 5){
                    found = true;
                    break;
                }
            }
        }
    }
}
