/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author summe
 */
public class Tills {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        Integer summ[] = new Integer[n];
        TreeSet<Integer> tills = new TreeSet<Integer>();
        Collections.addAll(tills, summ);
        
        for (int i = 0; i < customers.length; i++) {
        Integer pollFirst = tills.pollFirst();
        tills.add(pollFirst+tills.pollFirst());
        }
        return tills.pollLast();
    }

    private static void nextCustomer(int n) {
        Integer summ[] = new Integer[n];
        TreeSet<Integer> tills = new TreeSet<Integer>();
        Collections.addAll(tills, summ);
        Integer pollFirst = tills.pollFirst();
        tills.add(pollFirst+tills.pollFirst());
    }

    public static void main(String[] args) {
        int solveSuperMarketQueue = solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2);
        System.out.println(solveSuperMarketQueue);
    }
}
