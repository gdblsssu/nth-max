package com.example.nth_max.utils;

public class NMaxNumbers {

    private final int size;
    private final int[] array;
    private int idx = 0;
    private boolean isSorted = false;

    public NMaxNumbers(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public void addNumber(int number) {
        if (idx < size) {
            array[idx] = number;
            idx++;
        } else {
            if (isSorted) {
                SearchInsertHelper.insertIntoSortedArray(array, number);
            } else {
                MergeSort.mergeSort(array);
                isSorted = true;
            }
        }
    }

    public void sort(){
        MergeSort.mergeSort(array);
    }

    public int getN(){
        return array[0];
    }

    public int getSize(){
        return idx;
    }

    public boolean isSorted(){
        return isSorted;
    }
}
