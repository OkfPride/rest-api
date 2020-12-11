/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author summe
 */
public class Tills {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers.length==0) {
            return 0;
        }
        if (customers.length<n) {
            int max=customers[0];
            for (int i = 1; i < customers.length; i++) {
                if (max<customers[i]) {
                    max=customers[i];
                }
            }
            return  max;
        }
        LinkedList<Integer> arrayList = new LinkedList<Integer>();
        for (int i = 0; i < customers.length; i++) {
            while (arrayList.size() < n) {
                arrayList.add(customers[i++]);
            }
            while (arrayList.size() >= n&&i<customers.length) {
                arrayList.sort((o1, o2) -> {
                    return o1 - o2; //To change body of generated lambdas, choose Tools | Templates.
                });
                System.out.println("1st till = " +arrayList.get(0)+" add "+customers[i]);
                System.out.println("2st till = " +arrayList.get(1));
                System.out.println("---------------");
                Integer getFree = arrayList.get(0);
                arrayList.set(0, getFree + customers[i++]);
            }
        }
        arrayList.sort((o1, o2) -> {
                    return o1 - o2; //To change body of generated lambdas, choose Tools | Templates.
                });
        return arrayList.getLast();
    }

    public static void main(String[] args) {
        int solveSuperMarketQueue = solveSuperMarketQueue(new int[]{5,5,7,6,4,4,7,6,6,7,6,5,6,4,7,4,4,3,3,2,7,1,7,4,4}, 2);
        System.out.println(solveSuperMarketQueue);
    }
}
