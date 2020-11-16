/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgoritms;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author summe
 */
public class QuiqSort {

    public static void main(String[] args) {
        int[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr1));
        new QuiqSort().quiqSort(arr1);
        System.out.println(Arrays.toString(arr1));
        
        
//        int LEFT, RIGHT;
//        LEFT = 3;
//        RIGHT = 4;
//        Random random = new Random();
//        int[] arr2 = new int[10_000];
//        
//        for (int i = 0; i < 10_000; i++) {
//            int pivotINDEX = random.nextInt((RIGHT-LEFT) + 1) + (LEFT);
//            arr2[i] = pivotINDEX;
//        }
//        OptionalInt min = IntStream.of(arr2).min();
//        OptionalInt max = IntStream.of(arr2).max();
//
//        System.out.println(min.getAsInt());
//        System.out.println(max.getAsInt());

    }

    public void quiqSort(int[] arr) {
        quiqSort(arr, 0, arr.length - 1);
    }

    private void quiqSort(int[] arr, int LEFT, int RIGHT) {
        Random random = new Random();
        if (LEFT < RIGHT) {
            System.out.println("left = " + LEFT + " right = " + RIGHT);
            int pivotINDEX = random.nextInt((RIGHT-LEFT) + 1) + (LEFT);
            System.out.println(pivotINDEX);

            int NEWPIVOT = partision(arr, LEFT, RIGHT, pivotINDEX);

            quiqSort(arr, LEFT, NEWPIVOT - 1);
            quiqSort(arr, NEWPIVOT + 1, RIGHT);
        }
    }

    private int partision(int[] arr, int LEFT, int RIGHT, int PIVOT) {
        int indexSTORE = LEFT;
        int pivotVALUE = arr[PIVOT];
        BubbleSort.swap(arr, PIVOT, RIGHT);

        for (int i = LEFT; i < RIGHT; i++) {
            if (new Integer(arr[i]).compareTo(pivotVALUE) < 0) {
                BubbleSort.swap(arr, i, indexSTORE);
                indexSTORE++;
            }
        }
//         System.out.println(Arrays.toString(arr));
BubbleSort.swap(arr, indexSTORE, RIGHT);
        return indexSTORE;
    }

}
