/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task06_GoldGame;

/**
 *
 * @author summe
 */
public class SpinWords {

    public static void main(String[] args) {
        String sentence = new SpinWords().spinWords("stop spinning words");
        System.out.println(sentence);
    }

    public String spinWords(String sentence) {
        String[] split = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (String string : split) {
            if (string.length()>=5) {
                StringBuilder stringBuilder = new StringBuilder(string);
                stringBuilder.reverse();
                StringBuilder reverse = stringBuilder.reverse();
                res.append(stringBuilder.reverse()+" ");
            }else{
                res.append(string+" ");
            }
        }
        return res.toString().trim();
    }
}
