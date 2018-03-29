package com.xj.xs.java;

/**
 * 插入排序：先取第二个，与第一个数据比较，如果小于第一数据，前面的数据往前移动，直到移动到要交换的这个数据，与交换的数据交换
 * Created by xiong on 2018/3/28.
 */
public class InsertSort {
    public void insertSort(int[] array, int first, int last) {
        int temp, i, j;
        for (i = first + 1; i <= last - 1; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= first && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;            // 打印每次排序结果
            for (int m = 0; m <= array.length - 1; m++) {
                System.out.print(array[m] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        insertSort.insertSort(array, 0, array.length);
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
