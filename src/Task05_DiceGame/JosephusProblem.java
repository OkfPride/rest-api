/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_DiceGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author summe
 */
public class JosephusProblem {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        Collections.addAll(list, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        List<Integer> josephusPermutation = JosephusProblem.josephusPermutation(list, 3);
        System.out.println(josephusPermutation);
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        ArrayList<T> Tresult = new ArrayList<>();
        int count = 1;
        int i = 1;
        while (Tresult.size() != items.size() ) {

            if (count == k + 1) {
                count = 1;
            }
            if (i > items.size()) {
                i = 1;
            }
            if (items.get(i-1) == null) {
                i++;
                continue;
            }
            if (count % k == 0 && items.get(i-1) != null) {
                Tresult.add(items.get(i - 1));
                items.set(i - 1, null);
            }

            count++;
            i++;
            
            System.out.println("item size = " + items.size());
            System.out.println("count = " + count);
            System.out.println(" i  = " + i);
        }

        return Tresult;
    }
}
