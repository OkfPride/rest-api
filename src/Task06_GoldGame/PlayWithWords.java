/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task06_GoldGame;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author summe
 */
public class PlayWithWords {

    public static void main(String[] args) {
        String s221="hello";
        System.out.println(s221.substring(1));
        String pigIt = pigIt("Pig latin is cool !");
        String pigIt2 = pigIt2("Pig latin is cool !");
        System.out.println(pigIt);
        System.out.println(pigIt2);
    }
 public static String pigIt2(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1lay");
    }
    public static String pigIt(String str) {
        String[] split = str.split(" ");
        Stream<String> of = Stream.of(split);
        return of.map((String t) -> {
            char charAt = t.charAt(0);
            String substring = t.substring(1, t.length());
            if (!Character.isLetter(charAt)) {
                return new String(new char[]{charAt});
            }
            substring = substring + charAt + "ay";
            return substring; //To change body of generated lambdas, choose Tools | Templates.
        }).collect(Collectors.joining(" "));
    }
}
