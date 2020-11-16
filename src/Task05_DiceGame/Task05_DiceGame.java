package Task05_DiceGame;

import java.util.Arrays;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author summe
 *
 * Three 1's => 1000 points Three 6's => 600 points Three 5's => 500 points
 * Three 4's => 400 points Three 3's => 300 points Three 2's => 200 points One 1
 * => 100 points One 5 => 50 point
 */
public class Task05_DiceGame {

    public static void main(String[] args) {
        int greedy = Task05_DiceGame.greedy(new int[]{5, 5, 5, 6, 1});
        System.out.println(greedy);
    }

    public static int greedy(int[] dice) {
        int n[] = new int[7];
        for (int d : dice) {
            n[d]++;
        }
        int one= n[1]/3*1000;
        int two= n[1]%3*100;
        int three= n[2]/3*200;
        int four= n[3]/3*300;
        int bestpractise = n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
        System.out.println(bestpractise);
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Arrays.stream(dice).forEach((value) -> {
            hashMap.merge(value, 1, Integer::sum);
        });
        System.out.println(hashMap);
        for (int i = 1; i < 7; i++) {
            if (hashMap.containsKey(i)) {
                Integer valueofDie = hashMap.get(i);
                if (i == 1 && valueofDie == 1) {
                    result += 100;
                }
                if (i == 1 && valueofDie == 2) {
                    result += 200;
                }
                if (i == 1 && valueofDie >= 3) {
                    result += 100 * (valueofDie - 3);
                    result += 1000;
                }
                if (i == 5 && valueofDie == 1) {
                    result += 50;
                }
                if (i == 5 && valueofDie == 2) {
                    result += 100;
                }
                if (i == 5 && valueofDie >= 3) {
                    result += 50 * (valueofDie - 3);
                    result += 500;
                }
                if (valueofDie >= 3 && i != 1 && i != 5) {
                    result += i * 100;
                }
            }
        }
        return result;
    }
}
