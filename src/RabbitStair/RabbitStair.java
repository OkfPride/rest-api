/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RabbitStair;

/**
 *
 * @author summe
 */
public class RabbitStair {

    public static void main(String[] args) {
        RabbitStair rabbitStair = new RabbitStair();
        int method = rabbitStair.method(4, 2);
        System.out.println(method);
    }

    int method(int NumberOfStairs, int maximumStep) {
        int[] arr = new int[NumberOfStairs + 1];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int start = Math.max(0, i - maximumStep);
            arr[i] = 0;
            for (int j = start; j < i; j++) {
                arr[i]+=arr[j];
            }
        }

        return arr[NumberOfStairs];
    }
}
