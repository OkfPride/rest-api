/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task07;

/**
 *
 * @author summe
 */
public class Scrambles {

    public static boolean scramble(String str1, String str2) {
        System.out.println(str1);
        System.out.println(str2);
            for (int i = 0; i < str2.length(); i++) {
                boolean contains = str1.contains(str2.substring(i, i+1));
                if (contains) {
                    String substring = str2.substring(i, i+1);
                    str2=str2.replaceFirst(substring, "");
                    str1=str1.replaceFirst(substring, "");
                    i-=1;
                }
            }
            if (str2.length()!=0) {
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        boolean scramble = scramble("rkqodlw","world");
        System.out.println(scramble);
    }

}
