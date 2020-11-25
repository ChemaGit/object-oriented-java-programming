package com.week_6;

public class SelectionSort {

    public static int[] selectionSort(int[] vals) {
        int indexMin;
        for(int i = 0; i < vals.length - 1; i++) {
            indexMin = i;
            for(int j = i + 1; j < vals.length; j++) {
                if(vals[j] < vals[indexMin]) {
                    int aux = vals[j];
                    vals[j] = vals[indexMin];
                    vals[indexMin] = aux;
                }
            }
        }
        return vals;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11,1,8,12,2,5,4,3,10,9};
        int [] vals = SelectionSort.selectionSort(arr);
        for(int val : vals) {
            System.out.println("num: " + val);
        }
    }
}
