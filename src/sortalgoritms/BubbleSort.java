/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgoritms;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 5};
        System.out.println(Arrays.toString(arr1));
        new BubbleSort().bublesort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void swap(int arr[],int left, int right) {
        if (left!=right) {
        int middle = arr[left];
        arr[left]= arr[right];
        arr[right]= middle;
        }
    }
    void bublesort(int []arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i]<arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }
}
