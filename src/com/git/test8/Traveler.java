/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.git.test8;

import java.util.HashMap;

/**
 *
 * @author summe
 */
public class Traveler {
    public static void main(String[] args) {
        char []charr = new char []{'n','s','n','s','n','s','n','s','n','s'};
        
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (Character character : charr) {
        hashMap.compute(character, (Character t, Integer u) -> {
            if (hashMap.containsKey(t)) {
                 return u+1;
            }else{
                 return hashMap.put(t, 1);
            }
        });
        }
        System.out.println(hashMap);  
        boolean valid = isValid(charr);
        System.out.println(valid);
        
       
    }
    
    public static boolean isValid(char[] walk) {
        if (walk.length>10) 
            return false;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (Character character : walk) {
        hashMap.compute(character, (Character t, Integer u) -> {
            if (hashMap.containsKey(t)) {
                 return u+1;
            }else{
                 return hashMap.put(t, 1);
            }
        });
        }
        if (hashMap.get('e')==hashMap.get('w')&&hashMap.get('s')==hashMap.get('n')) {
            return true;
        }else{
            return false;
        }
  }
    
}
