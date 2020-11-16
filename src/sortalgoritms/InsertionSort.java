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
public class InsertionSort {

    public static void main(String[] args) throws Exception {
        int[] arr1 = {7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(arr1));
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    void insertionSort(int[] arr) throws Exception {
        int index = 1;
        while (index < arr.length) {
            if (arr[index - 1] > arr[index]) {
                int indextoInsert = searchIndextoInsert(arr, arr[index]);
                insert(arr, indextoInsert, index);
            }
            index++;
        }
    }

    int searchIndextoInsert(int[] arr, int value) throws Exception {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
//                System.out.println(arr[i]+" > "+ value);
                return i;
            }
        }
        throw new Exception();
    }
    void insert(int []arr, int indextoInsert,int indexfromToInsert){
        int temp=arr[indextoInsert];
        arr[indextoInsert]=arr[indexfromToInsert];
        for (int i = indexfromToInsert; i > indextoInsert; i--) {
            arr[i]=arr[i-1];
        }
        arr[indextoInsert+1] = temp;
        
        
    }
}
