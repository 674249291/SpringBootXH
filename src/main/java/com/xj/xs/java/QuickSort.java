package com.xj.xs.java;

/**
 * Created by xiong on 2018/3/28.
 */
public class QuickSort {
    public int partition(int[] sortArray, int low, int height) {
        int key = sortArray[low];
        while (low < height) {
            while (low < height && sortArray[height] >= key)
                height--;
            sortArray[low] = sortArray[height];
            while (low < height && sortArray[low] <= key)
                low++;
            sortArray[height] = sortArray[low];
        }
        sortArray[low] = key;        // 打印每次排序结果
        for (int i = 0; i <= sortArray.length - 1; i++) {
            System.out.print(sortArray[i] + "\t");
        }
        System.out.println();
        return low;
    }
    public void sort(int[] sortArray, int low, int height) {
        if (low < height) {
            int result = partition(sortArray, low, height);
            sort(sortArray, low, result - 1);
            sort(sortArray, result + 1, height);
        }
    }
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        quickSort.sort(array, 0, 8);
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
