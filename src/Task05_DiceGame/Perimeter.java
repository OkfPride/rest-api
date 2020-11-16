/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_DiceGame;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author summe
 */
public class Perimeter {
    
    public static void main(String[] args) {
        BigInteger perimeter = perimeter(new BigInteger("5"));
        System.out.println(perimeter);
    }
    
    public static BigInteger perimeter0(BigInteger n) {
        int intValueExact = n.intValueExact();
        
        int[] arr = new int[intValueExact + 1];
        while (intValueExact != 0) {
            arr[intValueExact] = intValueExact;
            intValueExact--;
        }
        arr[0] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        for (int i = 0; i < arr.length; i++) {
            intValueExact += arr[i];
        }
        intValueExact *= 4;
        BigInteger bigInteger = new BigInteger(new Integer(intValueExact).toString());
        return bigInteger;
    }

    //n==7
    public static BigInteger perimeter(BigInteger n) {
        BigInteger count = new BigInteger("2");
        BigInteger num1 = new BigInteger("1");
        BigInteger num2 = new BigInteger("1");
        BigInteger num3 = new BigInteger("2");
        BigInteger result = num3;
        while (!count.equals(n.add(new BigInteger("1")))) {            
            System.out.println(count + " | " + n);
            num3 = num1.add(num2);
            num1 = num2;
            num2 = num3;
            result=result.add(num3);
            count = count.add(new BigInteger("1"));
        }
        result = result.multiply(new BigInteger("4"));
        return result;
    }
}
