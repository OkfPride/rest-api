/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author summe
 */
public class PlayingDigits {

    public static void main(String[] args) {
        long digPow = digPow(46288, 3);
        System.out.println(digPow);
    }

    public static long digPow(int n, int p) {
        String number = n + "";
        int summ = 0;
        String[] split = number.split("");
        int myltiplier = p;
        for (int i = 0; i < split.length; i++) {
            summ += Math.pow(Integer.parseInt(split[i]), myltiplier++);
        }
        if (summ % Integer.parseInt(number) == 0) {
            return summ / Integer.parseInt(number);
        }
        return -1;
    }
}
