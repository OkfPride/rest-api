/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_DiceGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author summe
 */
public class Pangram {

    public static void main(String[] args) {
        boolean check = new Pangram().check("The quick brown fox jumps over the lazy dog.");
        System.out.println(check);
    }

    public boolean check(String sentence) {
        sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct();
        String toLowerCase = sentence.toLowerCase();
        HashSet<Character> hashSet = new HashSet<Character>();
        for (int i = 0; i < toLowerCase.length(); i++) {
            if (toLowerCase.charAt(i)>='a'&&toLowerCase.charAt(i)<='z') {
            hashSet.add(toLowerCase.charAt(i));
            }
        }
        if (hashSet.size()==26) {
            return true;
        }
        return false;
    }
}
