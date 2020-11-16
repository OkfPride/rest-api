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
public class test06 {
//    public static int digital_root(int n) {
//    while (n >10) {
//            String s = Integer.toString(n);
//            String[] arr = s.split("");
//            int[] arrint = new int[arr.length];
//            n = 0;
//            for (int i = 0; i < arrint.length; i++) {
//                arrint[i] = Integer.parseInt(arr[i]);
//                n +=arrint[i];
//            }
//        }
//        return n;
//  }
    //n=12

    public static void main(String[] args) {
//        int digital_root = digital_root(12);
        int persistence = persistence(999);
        System.out.println(persistence);
    }

    public static int digital_root(int n) {
        if (n < 10) {
            return n;
        }
        String s = Integer.toString(n);
        String[] arr = s.split("");
        int[] arrint = new int[arr.length];
        n = 0;
        for (int i = 0; i < arrint.length; i++) {
            arrint[i] = Integer.parseInt(arr[i]);
            n += arrint[i];
        }

        return digital_root(n);
    }

    public static int persistence(long n) {
        int count = 0;
        while (n > 9) {
            count++;
            String s = Long.toString(n);
            String[] arr = s.split("");
            int[] arrint = new int[arr.length];
            n = 1;
            for (int i = 0; i < arrint.length; i++) {
                arrint[i] = Integer.parseInt(arr[i]);
                n *= arrint[i];
            }
            if (n > 9) {
                continue;
            }
        }
        return count;
    }
}
