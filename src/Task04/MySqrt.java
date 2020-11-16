/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task04;

import java.util.ArrayList;

/**
 *
 * @author summe
 */
public class MySqrt {

    public static void main(String[] args) {
//        int method = method(81);
        int method2 = method2(80);

//        System.out.println(9%3==0);
        System.out.println(method2);
    }



    private static int method2(int input) {

        int low = 0;
        int h = input;
        while (low <= h) {
            int middle = (h + low) / 2;
            int squaremid = middle * middle;
            if (squaremid == input) {
                return middle;
            }
            if (squaremid > input) {
                h = middle ;
            }
            if (squaremid < input) {
                low = middle ;
            }
            if (h-low==1) {
                return low;
            }
        }

        return low - 1;
    }

}
