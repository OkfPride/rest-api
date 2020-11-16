/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author summe
 */
public class FindDuplicates {
    public static int duplicateCount(String text) {
        char[] toCharArray = text.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < toCharArray.length; i++) {
            map.compute(toCharArray[i], (Character t, Integer u) -> {
                if (map.containsKey(t)) {
                    return u + 1;
                } else {
                    map.put(t, 0);
                }
                return 0;
            });
        }
        System.out.println(map);
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        int finish = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next > 0) {
                finish++;
            }
        }
        System.out.println(finish);
        return finish;
    }
}
