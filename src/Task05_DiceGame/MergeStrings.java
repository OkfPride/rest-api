/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_DiceGame;

/**
 *
 * @author summe
 */
public class MergeStrings {

    public static void main(String[] args) {
//        boolean merge = isMerge("y>hd9PbavA`Q-qkvpD[fM[9atJRb #)GF g=HJ@4P%Qy>hd9PbavA`Q-qkvpuEg)DQSyxPr?IQF>\\T9ZLrGrC?,O(!u*@(I\\/nzIb", "y>hd9PbavA`Q-qkvpuEg)DQSyxPr?IQF>\\T", "y>hd9PbavA`Q-qkvpD[fM[9atJRb #)GF g=HJ@4P%Q9ZLrGrC?,O(!u*@(I\\/nzIb");
        boolean merge = isMerge("aabba", "aaba", "ab");
        System.out.println(merge);

    }

    public static boolean isMerge(String s, String part1, String part2) {
        String[] split1 = part1.toLowerCase().split("");
        String[] split2 = part2.toLowerCase().split("");
        String[] Word = s.toLowerCase().split("");
        String toLowerCase = s.toLowerCase();
        int count1 = 0;
        int count2 = 0;
        int save1=0;
        int save2=0;
        int saveI=0;
        
        StringBuilder stringBuilder = new StringBuilder();
        if (s.length()!=part1.length()+part2.length()) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            System.out.println("i = "+i);
            System.out.println("count1 = "+count1);
            System.out.println("count2 = "+count2);
            if (true) {
                
            }
            if (count1 < part1.length() && Word[i].equals(split1[count1]) || count2 < part2.length() && Word[i].equals(split2[count2])) {
                if (count1 < part1.length() && Word[i].equals(split1[count1])) {
                    stringBuilder.append(split1[count1++]);
                } else if (count2 < part2.length() && Word[i].equals(split2[count2])) {
                    stringBuilder.append(split2[count2++]);
                }
                System.out.println(stringBuilder);
            } else {
                System.out.println("string = " +Word[i]+" count1 = "+split1[count1]+ " count2 = "+split2[count2]);
                return false;
            }
        }
        if (stringBuilder.toString().equals(toLowerCase)) {
            return true;
        }
        return false;
    }
}
