/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_DiceGame;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class Tribonatty {

    public static void main(String[] args) {
        double[] tribonacci = new Tribonatty().tribonacci(new double []{1,1,1},12);
        for (double d : tribonacci) {
            System.out.println(d);
        }
    }

    public double[] tribonacci(double[] s, int n) {
        int res = 0;
        double[]arr = Arrays.copyOf(s, n);
        for (int i = 3; i < arr.length; i++) {
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }
        return arr;
    }
}
