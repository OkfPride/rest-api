/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgoritms;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class UnitySort {

    static int[] arr1 = {10,9,8,7,6,5,4,3,2,1};
    static int[] arrfinal = new int[arr1.length];

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(arr1));
        new UnitySort().unitySort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public void unitySort(int[] arr) throws Exception {
        int middle = arr.length / 2;
        if (arr.length<=1) {
            return;
        }
        int[] leftARRAY = new int[middle];
        System.arraycopy(arr, 0, leftARRAY, 0, middle);
        System.out.println("left = " + Arrays.toString(leftARRAY));
        unitySort(leftARRAY);

        int[] rightARRAY = new int[arr.length - middle];
        System.arraycopy(arr, middle, rightARRAY, 0, arr.length - middle);
        System.out.println("right= " + Arrays.toString(rightARRAY));
        unitySort(rightARRAY);
        int[] merge = merge(arr,leftARRAY, rightARRAY);
        System.out.println("merge = "+Arrays.toString(merge));
    }

    int[] merge(int [] mainARRAY, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = 0;
//            int[] name = new int[left.length + right.length];
        
        for (int i = 0; i < left.length + right.length; i++) {
            if (leftIndex>=left.length) {
                mainARRAY[targetIndex]=right[rightIndex++];
            }else if(rightIndex>=right.length){
                mainARRAY[targetIndex]= left[leftIndex++];
                
                
            }else if (left[leftIndex] > right[rightIndex]){
                System.out.println(rightIndex+" right index");
                System.out.println(""+left[leftIndex]+" > "+right[rightIndex]);
                mainARRAY[targetIndex]=right[rightIndex++];
                
                
                
            } else if (right[rightIndex]>left[leftIndex]){
                mainARRAY[targetIndex]=left[leftIndex++];
                        
            }
            targetIndex++;
        }
        return mainARRAY;
    }

}
