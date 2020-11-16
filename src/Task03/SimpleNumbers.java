/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author summe
 */
public class SimpleNumbers {

    public static void main(String[] args) {
        int[] arr = new int[119];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }
//        System.out.println(Arrays.toString(arr));
        int[] method = method(arr);
        System.out.println(Arrays.toString(method));

    }

    static int[] method(int[] arr) {
        int count = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == 0) {
                    continue;
                } else if (arr[j] != 0 && arr[i] % arr[j] == 0) {
//                    System.out.println("arr " + arr[i] + " = 0");
                    arr[i] = 0;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arrayList.add(arr[i]);
            }

        }
        int[] toArray = arrayList.stream().mapToInt((value) -> {
            return value; //To change body of generated lambdas, choose Tools | Templates.
        }).toArray();
        return toArray;
    }

}
