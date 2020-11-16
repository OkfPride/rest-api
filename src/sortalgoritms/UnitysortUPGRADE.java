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
public class UnitysortUPGRADE {
static int[] arr1 = {10,9,8,7,6,5,4,3,2,1};
    static int[] arrfinal = new int[arr1.length];

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(arr1));
        new UnitysortUPGRADE().unitySort(arr1,0,arr1.length);
        System.out.println(Arrays.toString(arr1));
    }

    public void unitySort(int[] arr,int start, int finish) throws Exception {
//        int middle = arr.length / 2;
       
        if ((start+finish/2)-start==1||(finish - (start+finish/2))==1) {
            return;
        }
        unitySort(arr,start,(start+finish/2));

        unitySort(arr,start+finish/2,finish);
        
        merge(arr,start, finish);
    }

    void merge(int [] mainARRAY, int leftINDEX, int rightINDEX) {
        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = 0;
        for (int i = 0; i < (rightINDEX-leftINDEX); i++) {
            System.out.println("right = "+ rightINDEX + " left = "+leftINDEX);
        }
        
    }
    
}
