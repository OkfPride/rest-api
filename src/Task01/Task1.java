/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author summe
 */
public class Task1 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 1, 5, 2, 1, 4, 3, 6, 4, 1, 3,6};
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        new ArrayList<Integer>();
        Stream<Integer> boxed = IntStream.of(arr).boxed();
        boxed.forEach((t) -> {hashMap.merge(t, 0, (w, u)  -> Integer.sum(w, u));});
        
//        for (int i = 0; i < arr.length; i++) {
//            if (hashMap.containsKey(arr[i])) {
//                Integer get = hashMap.get(arr[i]);
//                hashMap.put(arr[i], get + 1);
//            } else {
//                hashMap.put(arr[i], 1);
//            };
//        }
        System.out.println(hashMap);
    }

}
