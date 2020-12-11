/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task08;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class EqualSides {

    public static void main(String[] args) {
        int findEvenIndex = findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35});
        System.out.println(findEvenIndex);
//        System.out.println(sumOfArr(1   , 7, new int[]{20, 10, 30, 10, 10, 15, 35}));

    }

    public static int findEvenIndex(int[] arr) {
        int sumOfLeft = 0;
        int sumOfRight = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfLeft += arr[i];
            sumOfRight = sumOfArr(i + 3, arr.length, arr);
            if (sumOfLeft == sumOfRight) {
                return i + 1;
            }
            
        }
        return -1;
    }

    private static int sumOfArr(int start, int end, int[] array) {
        int summ = 0;
        for (int i = start - 1; i < end; i++) {
            summ += array[i];
        }
        return summ;
    }

}
