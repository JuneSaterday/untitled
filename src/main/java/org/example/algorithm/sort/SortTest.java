package com.lff.algorithm.sort;

import java.util.Arrays;

public class SortTest {


    public static void main(String[] args) {

//        int[] a = {3, 5, 4, 1, 2, 6};
//        int[] a = {1, 2, 3, 4, 5, 6};
        int[] a = {6, 5, 4, 3, 2, 1};

//        bubbleSort(a);
//        insertionSort(a);
        selectionSort(a);

        System.out.println(Arrays.toString(a));
    }


    /**
     * 冒泡排序
     * 1.冒泡排序是原地排序算法，只涉及相邻元素的交换，空间复杂度为O(1),
     * 2.冒泡排序是稳定的排序，只有交换两个元素时，才改变元素的顺序，相邻两个元素大小相等时不交换位置
     * 3.时间复杂度：
     *              （1）最好情况下，数据已经是有序，只需一次冒泡操作，最好情况时间复杂度 O(n);
     *              （2）最坏情况下，数据是倒序排列，需要 n次冒泡，最坏时间复杂度 O(n2);
     *              （3）平均情况下的时间复杂度就是 O(n2)。
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.println("第" + (i+1) +"次冒泡");
            boolean swap = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                return;
            }
        }
    }


    /**
     * 插入排序
     * 1.插入排序是原地排序算法，空间复杂度为O(1),
     * 2.插入排序是稳定的排序
     * 3.时间复杂度：
     *              （1）最好情况时间复杂度 O(n);
     *              （2）最坏时间复杂度 O(n2);
     *              （3）平均情况下的时间复杂度 O(n2)。
     * @param array
     */
    public static void insertionSort(int [] array) {

        int n = array.length;

        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = array[i];
            int j = i - 1;

            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = value;
        }
    }


    /**
     * 选择排序
     * 1.选择排序是原地排序算法，空间复杂度为O(1),
     * 2.选择排序是不稳定的排序
     * 3.时间复杂度：
     *              （1）最好情况时间复杂度 O(n2);
     *              （2）最坏时间复杂度 O(n2);
     *              （3）平均情况下的时间复杂度 O(n2)。
     * @param a
     */
    public static void selectionSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            /** 这种写法涉及到的赋值操作多了 */
//            for (int j = i + 1; j < n; j++) {
//                if (a[i] > a[j]) {
//                    int temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;

        }
    }



}
