/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.git.test8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author summe
 */
public class ShortestWay {

    public static String[] dirReduc(String[] arr) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arr));
        for (int i = 1; i < arrayList.size(); i++) {
            if (i==0) {
               continue;
            }
            switch (arrayList.get(i)) {
                case "NORTH":
                    if (arrayList.get(i - 1) == "SOUTH") {
                        arrayList.remove(i - 1);
                        arrayList.remove(i - 1);
                        i -= 2;
                    }
                    break;
                case "SOUTH":
                    if (arrayList.get(i - 1) == "NORTH") {
                        arrayList.remove(i - 1);
                        arrayList.remove(i - 1);
                        i -= 2;
                    }
                    break;
                case "EAST":
                    if (arrayList.get(i - 1) == "WEST") {
                        arrayList.remove(i - 1);
                        arrayList.remove(i - 1);
                        i -= 2;
                    }
                    break;
                case "WEST":
                    if (arrayList.get(i - 1) == "EAST") {
                        arrayList.remove(i - 1);
                        arrayList.remove(i - 1);
                        i -= 2;
                    }
                    break;
            }
        }
        return arrayList.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] dirReduc
                = dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"});
        System.out.println(Arrays.toString(dirReduc));;
    }
}
