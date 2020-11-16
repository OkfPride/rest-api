/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task06_GoldGame;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class maximumSubArray {

    public static void main(String[] args) {
        maximumSubArray.sequence(new int[]{-1, -2, 2, -1, 4, 1, -2, -3, 1});
    }

    public static int sequence(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int absolutestartPosition = 0;
        int abloluteendPosition = 0;
        int max = 0;
        int absoluteMax = 0;

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        if (max <= 0) {
            return 0;
        }

        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                current = arr[i];
                int localMax = current;
                int localStart = i;
                int localend = i;
                if (absoluteMax < localMax) {
                    absoluteMax = localMax;
                    absolutestartPosition= localStart;
                    abloluteendPosition = localend;
                }
                localMax = current;

                localStart = i;
                for (int j = i + 1; current > 0 && j < arr.length; j++) {

                    current += arr[j];
                    if (localMax < current) {
                        localMax = current;
                        localend=j;
                    }
                }
                if (absoluteMax < localMax) {
                    absoluteMax = localMax;
                    absolutestartPosition= localStart;
                    abloluteendPosition = localend;
                }
            }
        }
        System.out.println("start = " + absolutestartPosition);
        System.out.println("end= " + abloluteendPosition);
        System.out.println("max= " + absoluteMax);
        return absoluteMax;
    }
}
