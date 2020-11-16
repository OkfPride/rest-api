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
public class ShowDuplicates {
    public static void main(String[] args) {
        int arr[]= {1,2,3,4,5,3};
        boolean showDuples = showDuples(arr);
        System.out.println(showDuples);
        
        
    }
    static boolean showDuples(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                if (arr[i]==arr[j]) {
                    return true;
                }
                
            }
            
        }
        return false;
    }
}
