/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task04;

/**
 *
 * @author summe
 */
public class task04 {

    public static void main(String[] args) {
        String[] arr = {"abcqqqq", "abd", "abedwers", "abqwe", "abqwe", "abasd", "ab"};
        String method = method(arr);
        System.out.println(method);
    }

    private static String method(String[] arr) {
        StringBuilder res = new StringBuilder("");
        int count = 0;
        while (true) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[0].charAt(count) != arr[j].charAt(count)) {
                    return res.toString();
                }
            }
            res.append(arr[0].charAt(count));
            count++;
        }
    }
}
