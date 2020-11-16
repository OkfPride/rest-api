/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task06_GoldGame;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class test06find {

    static int find(int[] integers) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if (odd > even) {
            for (int integer : integers) {
                if (integer % 2 ==0) {
                    return integer;
                }
            }
        } else {
            for (int integer : integers) {
                if (integer % 2 == 1||integer % 2 == -1) {
                    return integer;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println((-3%2)+"| |");
        int[] exampleTest1 = {2, -6, 8, -10, -3};
        int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
        int find = find(exampleTest1);
        System.out.println(find);

    }
}
