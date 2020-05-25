package com.huyue.sort;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description: 快速排序的两种优化方式
 * 快排要快, 在每次划分序列的时候, 如果都可以进行均匀的划分, 效果最好
 *
 * 1. 当待排序序列的数据个数小于一定的数之后, 使用直接插入排序
 * 2. 优化最坏情况(数组已经有序): 进行均匀的划分:  三数取中方法
 * User: HHH.Y
 * Date: 2020-05-24
 */
public class DemoSort {
    // 直接插入排序
    public static void insertSort(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int tmp = array[i];
            int j = i - 1;
            for ( ;j >= start; j--) {
                if(array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                   break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    // 找到基准位置par
    public static int partition(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        // low == high
        array[high] = tmp;
        return high;
    }
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    // 三数取中
    public static void three_nums_mid(int[] array, int left, int right) {
        // array[mid] <= array[left] <= array[right]
        int mid = (left + right) / 2;
        if(array[mid] > array[left]) {
            swap(array, mid, left);
        }
        if(array[mid] > array[right]) {
            swap(array, mid, right);
        }
        if(array[left] > array[right]) {
            swap(array, right, left);
        }
    }
    // 通过递归进行快速排序
    public static void quick(int[] array, int left, int right) {
        // 递归的结束条件
        if(left >= right) {
            return;
        }

        // 优化方式1: 当待排序序列中的数据个数小于一定的值之后, 就使用直接插入排序
        if(right - left <= 100) {
            // 使用直接插入排序
            insertSort(array, left, right);
            return;
        }

        // 优化方式2: 三数取中方法
        three_nums_mid(array, left, right);


        int par = partition(array, left, right);
        // 递归par左边的数组
        quick(array, left, par - 1);
        // 递归par右边的数组
        quick(array, par + 1, right);
    }
    // 快速排序
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
//            array[i] = i;
            array[i] = random.nextInt(10_0000);
        }
        long start = System.currentTimeMillis(); // 计算运行时间
        quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
