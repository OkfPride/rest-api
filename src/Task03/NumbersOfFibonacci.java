/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task03;

/**
 *
 * @author summe
 */
public class NumbersOfFibonacci {

    public static void main(String[] args) {
//        int method = method(300);
//        int method2 = method2(1200);
        double num = 123456789012345678901234567890123456789F;
        System.out.printf("%f\n",num);
        long num2 = 1234567890123456789L;
        System.out.printf("%d",num2);
        
    }

    static int method(int number) {
        if (number < 1) {
            return 1;
        } else {
            return method(number - 1) + method(number - 2);
        }
    }

    static int method2(int number) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < number; i++) {
            int f = a + b;
            a = b;
            b = f;
        }
        return b;
    }

}
