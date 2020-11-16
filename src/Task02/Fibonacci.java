/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task02;

/**
 *
 * @author summe
 */
public class Fibonacci {
    public static void main(String[] args) {
        int fibonacci = fibonacci(15000);
        System.out.println(fibonacci);
    }
    static int result=1;
static int  fibonacci(int n){
    if (n==0) {
        return 1;
    }
    return n*fibonacci(n-1);
}    
}
