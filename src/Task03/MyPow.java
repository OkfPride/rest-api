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
public class MyPow {

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
//        int pow2 = myPow.pow2();
        long nanoTime = System.nanoTime();
        long pow1 = myPow.pow2(53, 11200);
//        long pow2 = myPow.pow1(53, 11200);
        long nanoTime2 = System.nanoTime() - nanoTime;
//        System.out.println(pow1);
//        System.out.println(pow2);

        System.out.println(nanoTime2 );
    }

    long pow1(long value, int extent) {
        long result = 1;
        for (int i = 0; i < extent; i++) {
            result *= value;
        }
        return result;
    }

    long pow2(int value, int extent) {
        int first = 1;
        int count = 0;
        while (first < extent) {
            first *= 2;
            count++;
            if (first>=extent) {
                first/=2;
                count--;
                break;
            }
        }
//        System.out.println("first = "+first);
//        System.out.println("count = "+count);
        int secont = extent - first;
//        System.out.println("secont = "+secont);
        long middle = value;
        for (int i = 0; i < count; i++) {
            middle *= middle;
        }
//        System.out.println("first value = "+ middle);
        if (secont!=0) {
        middle*=pow1(value, secont);
        }

        return middle;
    }
}
