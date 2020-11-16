/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task07;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author summe
 */
public class ListOfWeights {

    public static void main(String[] args) {
        String orderWeight = orderWeight("2000, 11, 11, 10003, 22, 123, 1234000, 44444444, 9999");
        System.out.println(orderWeight);
    }

    public static String orderWeight(String strng) {
        Comparator<String> comp = (String o1, String o2) -> {
            int res1 = 0;
            int res2 = 0;
            for (int i = 0; i < o1.length(); i++) {
                char charAt = o1.charAt(i);
                res1 += charAt - 48;
            }
            for (int i = 0; i < o2.length(); i++) {
                char charAt = o2.charAt(i);
                res2 += charAt - 48;
            }
            return res1 - res2;
        };
        Comparator<String> thenComparing = comp.thenComparing((o1, o2) -> {
            return o1.compareTo(o2); //To change body of generated lambdas, choose Tools | Templates.
        });
        String[] split = strng.split(" ");
        Arrays.sort(split, thenComparing);
        String.join(" ", split);
        return String.join(" ", split);
    }
}
