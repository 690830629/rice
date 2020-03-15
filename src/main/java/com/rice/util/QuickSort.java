package com.rice.util;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class QuickSort {
    public  static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int index = getIndex(a, low, high);
            quickSort(a, low, index - 1);
            quickSort(a, index + 1, high);
        }

    }

    private  static int getIndex(int arr[], int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;

    }

    public static void main(String[] args) {
        List<String> list= Lists.newArrayList();
        Collections.sort(list);
        int a[]={3,7,9,5,6,10,100};
        quickSort(a,0,a.length-1);
        for(int i:a){
            System.out.println(i);
        }
    }
}
