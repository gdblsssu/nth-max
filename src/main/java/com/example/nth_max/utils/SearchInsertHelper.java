package com.example.nth_max.utils;

public class SearchInsertHelper {
    public static int binarySearchInsertIndex(int[] array, int num) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == num) {
                return mid;
            }

            if (array[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void insertIntoSortedArray(int[] array, int num) {
        int index = binarySearchInsertIndex(array, num);

        for (int i = 0; i < index - 1; i++) {
            array[i] = array[i + 1];
        }

        array[index - 1] = num;

    }
}
