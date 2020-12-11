/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task08;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class Dubstep {

    public static void main(String[] args) {
        String SongDecoder = SongDecoder("RWUBWUBWUBLWUB");
        System.out.println(SongDecoder);
//        System.out.println("12345".substring(1,5));
    }

    public static String SongDecoder(String song) {
        System.out.println(song);
        String res="";
        while (song.startsWith("WUB")) {
            song = song.replaceFirst("WUB", "");
        }
        while (song.endsWith("WUB")) {
            song = song.subSequence(0, song.length() - 3).toString();
        }
        while (!song.isEmpty()) {
            if (song.startsWith("WUB")) {
                song = song.replaceFirst("WUB", "");
            }else{
                res=res+song.charAt(0);
                song= song.substring(1,song.length());
                if (song.startsWith("WUB")) {
                    res=res+" ";
                }
            }
        }
        return res;
    }
}
