/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_DiceGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author summe
 */
class Permutations {

    public static void main(String[] args) {
        List<String> singlePermutations = Permutations.singlePermutations("ab");
        System.out.println(singlePermutations);
//        String a = "ab";
//        String substring = a.replaceFirst("a", "");
//        System.out.println(substring);
//        System.out.println(a);

    }

    public static List<String> singlePermutations2(String s) {
        String[] split = s.split("");
        char[] toCharArray = s.toCharArray();
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add(s);
        for (int i = 0; i < 10_000_000; i++) {
            StringBuilder stringBuilder = new StringBuilder(s);
            Random random = new Random();
            int nextInt = random.nextInt(s.length());
            int nextInt2 = random.nextInt(s.length());
            if (nextInt != nextInt2) {
                char one = s.charAt(nextInt);
                char two = s.charAt(nextInt2);
                stringBuilder.setCharAt(nextInt, two);
                stringBuilder.setCharAt(nextInt2, one);
            } else {
                i--;
                continue;
            }
            hashSet.add(stringBuilder.toString());
        }
        return new ArrayList<>(hashSet);
    }

    public static List<String> singlePermutations(String s) {
        String[] split = s.split("");
        int[] toArray = s.chars().distinct().toArray();
        byte[] Distinct = new byte[toArray.length];
        for (int i = 0; i < toArray.length; i++) {
            Distinct[i] = (byte) toArray[i];
        }
        String stringNEW = new String(Distinct);
        String[] split1 = stringNEW.split("");
        HashSet<String> hashSet = new HashSet<String>();
        double count = Math.pow(stringNEW.length(), stringNEW.length());
//        while (hashSet.size() != count + (s.length() - stringNEW.length())) {
        for (int j = 0; j < 10_000_000; j++) {

            StringBuilder stringBuilder = new StringBuilder(s);
            StringBuilder result = new StringBuilder(s);

            for (int i = 0; i < s.length(); i++) {
                Random random = new Random();
                int nextInt = random.nextInt(stringNEW.length());
                String afterMUTETED = stringBuilder.toString();
                if (afterMUTETED.contains(split1[nextInt])) {
                    afterMUTETED = afterMUTETED.replaceFirst(split1[nextInt], "");
                    stringBuilder = new StringBuilder(afterMUTETED);
                }
                result.append(s.charAt(nextInt));
//                System.out.println(stringBuilder);
            }
//            System.out.println(result);
            hashSet.add(result.toString());
        }
        return new ArrayList<>(hashSet);
    }
}
