/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task06_GoldGame;

import javax.naming.spi.DirStateFactory;

/**
 *
 * @author summe
 */
public class MorseCodeTest {

    public static void main(String[] args) {
//        MorseCode.get(".--");

        decode("h l   l o  .   ");

    }

    public static String decode(String morseCode) {
        System.out.println(morseCode);
        morseCode = morseCode.trim();
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = morseCode.trim().split("   ");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(" ");
            for (int j = 0; j < split1.length; j++) {
//                System.out.print(split1[j]);
//                String ss = MorseCode.get(split1[j]);
//                stringBuilder.append(ss);
                if (j == split1.length - 1) {
                    System.out.print("_");

                }
            }
//            stringBuilder.append("SPACE");
        }
        StringBuilder delete = stringBuilder.delete(0,1);
        System.out.println(delete);
        
        return stringBuilder.toString();
    }

}
