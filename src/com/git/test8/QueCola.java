/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.git.test8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author summe
 */
public class QueCola {

    public static void main(String[] args) {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
//        System.out.println(WhoIsNext(names, 28_643_950));
        String WhoIsNext = WhoIsNext(names, 36);
        System.out.println(WhoIsNext);

    }

//    public static String WhoIsNext(String[] names, int n) {
//        int sumOfOrders = names.length;
//        while (true) {
//            if (n <= sumOfOrders) {
//                if (n==1) {
//                    return names[0];
//                }
//                if (n==2) {
//                    return names[1];
//                }
//                System.out.println(n + " n ");
//                if (n%(sumOfOrders/5)==0) {
//                    return names[n/(sumOfOrders/5)];
//                }else{int ans = n/(sumOfOrders/5)+1;
//                    System.out.println(ans);
//                    return names[ans-1];
//                }
//            }
//            n = n - sumOfOrders;
//            sumOfOrders = sumOfOrders *2;          
//        }
//    }
    public static String WhoIsNext(String[] names, int n) {
        while (n > names.length) {
            n = (n - (names.length - 1)) / 2;
        }
        return names[n - 1];
    }
}
