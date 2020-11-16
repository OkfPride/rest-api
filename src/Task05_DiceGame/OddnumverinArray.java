/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_DiceGame;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 *
 * @author summe
 */
public class OddnumverinArray {
    public static void main(String[] args) {
        int findIt = OddnumverinArray.findIt(new int[]{1,5,2,-2,5,2,4,4,-1,-2,5});
        System.out.println(findIt);
        
    }
     public static int findIt(int[] A) {
    int xor = 0;
    for (int i = 0; i < A.length; i++) {
        System.out.print(xor+" ^= "+A[i] +" = ");
      xor ^= A[i];
        System.out.println(xor);
    }
    return xor;
  }
//    public static int findIt(int[] a) {
//        int odd = 0;
//        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//        IntStream.of(a).forEach((value) -> {
//            hashMap.merge(value, 1, Integer::sum);
//        });
//        System.out.println(hashMap);
//        for (int i = 0; i < hashMap.size(); i++) {
//            Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
//            Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
//            while (iterator.hasNext()) {                
//                Map.Entry<Integer, Integer> next = iterator.next();
//                 odd = next.getKey();
//                Integer value = next.getValue();if (value%2!=0) {
//                    return odd;
//                }
//            }
//        }
//        return odd;
//    }
}
