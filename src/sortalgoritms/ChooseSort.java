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
public class ChooseSort {
    public static void main(String[] args) {
        int[] arr1 = {7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(arr1));
        new ChooseSort().chooseSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
    void chooseSort(int []arr){
        int currentSortPossition=0;
        while (currentSortPossition<arr.length) {            
            int minPossition= findMin(arr, currentSortPossition);
            insert(arr, currentSortPossition,minPossition);
            currentSortPossition++;
        }
        
        
    }
    int findMin(int []arr,int unsorted){
        int min=unsorted;
        int minPossition = unsorted;
        for (int i = unsorted+1; i < arr.length; i++) {
            min=arr[i-1];
            if (min>arr[i]) {
                min= arr[i];
            }
            unsorted++;
            minPossition++;
        }
        return minPossition;
    }
    void insert(int []arr,int possitionTO, int possitionFROM){
        int temp = arr[possitionFROM];
        for (int i = possitionFROM; i > possitionTO; i--) {
            arr[i]=arr[i-1];
        }
        arr[possitionTO]=temp;
    }
}
