/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task07;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class prodFibonatti {

    public static void main(String[] args) {
        long[] productFib = productFib(4456077604922913920L);
        System.out.println(Arrays.toString(productFib));
    }

    public static long[] productFib(long prod) {
        System.out.println(prod);
        long result = 1;
        int isTrue = 0;
        long current = 1;
        long currentPREV = 0;
        long currentNEXT = 1;
        while (true) {
            currentNEXT = current + currentPREV;
            result = current * currentNEXT;
            if (prod / current == currentNEXT) {
                isTrue = 1;
                return new long[]{current, currentNEXT, isTrue};
            }
            if (result > prod) {
                return new long[]{current, currentNEXT, isTrue};
            }
            currentPREV = current;
            current = currentNEXT;
        }
    }
}
