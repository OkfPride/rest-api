/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task03;

/**
 *
 * @author summe наибольший общий дедлитель
 */
public class EuclidAlgoritm {

    public static void main(String[] args) {
        EuclidAlgoritm euclidAlgoritm = new EuclidAlgoritm();
        long nanoTime = System.nanoTime();
        long NOD = euclidAlgoritm.NOD1(1234567890, 12);
        long nanoTime2 = System.nanoTime()-nanoTime;
        System.out.println(NOD);
        System.out.println(nanoTime2/1000);
    }

    long NOD2(long a, long b) {
        long middle = 0;
        while (a != 0&&b!=0) {
            if (a > b) {
                a %= b;
            } else {
//                middle = two - one;
//                two = Math.min(one, two);
//                one = middle;
                b=b%a;
            }
        }
        return Math.max(a, b);
    }
    long NOD1(long a, long b) {
        long middle = 0;
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
//                middle = two - one;
//                two = Math.min(one, two);
//                one = middle;
                b-=a;
            }
        }
        return a;
    }
}
