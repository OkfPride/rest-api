/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs_BreadthFirst;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author summe
 */
public class FireinForest {

    static LinkedList<Integer> linkedList = new LinkedList<>();
    static int arrey[][] = {
        {1, 1, 0, 1, 1, 0, 0, 1},
        {1, 0, 1, 0, 0, 1, 1, 0},
        {1, 0, 0, 1, 0, 0, 0, 1},
        {0, 1, 0, 0, 1, 1, 0, 1},
        {1, 0, 0, 1, 0, 1, 1, 1},};
    static boolean fired[][] = new boolean[arrey.length][arrey[0].length];

    public static void main(String[] args) {

        FireinForest fireinForest = new FireinForest();
        fireinForest.method(arrey);
        for (int i = 0; i < arrey.length; i++) {
            for (int j = 0; j < arrey[0].length; j++) {
                System.out.print(arrey[i][j] + " | ");
            }
            System.out.println("");

        }
    }

    public void method(int[][] arr) {

        int y = 0;
        int x = 0;
        int count = 2;
        arrey[y][x] = count;
        fired[y][x] = true;
        linkedList.add(arrey[y][x]);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            
            ++count;
            while (size>0) {
            outer:
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arrey[i][j] == linkedList.peek() && fired[i][j] == false) {
//                        arrey[i][j] = count++;
                        y = i;
                        x = j;
                        break outer;
                    }
                }
            }
            
            
            checkCondicion(y, x, count);
            size--;
            }
        }

    }

    private void checkCondicion(int y, int x, int count) {
        if ((y >= 0 &&y<arrey.length-1&& x >= 0&&x<arrey[0].length-1) && arrey[y + 1][x] == 1) {
            arrey[y + 1][x] = count;
            FireinForest.linkedList.add(count);
            fired[y][x] = true;
        }
        if ((y >= 0 && y<arrey.length-1 && x >= 1&&x<arrey[0].length-1) && arrey[y + 1][x-1] == 1) {
            arrey[y + 1][x-1] = count;
            FireinForest.linkedList.add(count);
            fired[y][x] = true;
        }
        if ((y >= 0 &&y<arrey.length-1&& x >= 0&&x<arrey[0].length-1) && arrey[y + 1][x + 1] == 1) {
            arrey[y + 1][x + 1] = count;
            FireinForest.linkedList.add(count);
            fired[y][x] = true;
        }
        if ((x >= 0&&x<arrey[0].length-1) && arrey[y][x + 1] == 1) {
            arrey[y][x + 1] = count;
            FireinForest.linkedList.add(count);
            fired[y][x] = true;
        }
        if (y >= 1 && arrey[y - 1][x + 1] == 1) {
            arrey[y - 1][x + 1] = count;
            FireinForest.linkedList.add(count);
            fired[y][x] = true;
        }
        if ((y >= 1) && arrey[y - 1][x] == 1) {
            arrey[y - 1][x] = count;
            FireinForest.linkedList.add(count);
            fired[y][x] = true;
        }
        if ((y >= 1 && x >= 1) && arrey[y - 1][x - 1] == 1) {
            arrey[y - 1][x - 1] = count;
            FireinForest.linkedList.add(count);
            fired[y][x] = true;
        }
        if ((x >= 1) && arrey[y][x - 1] == 1) {
            arrey[y][x - 1] = count;
            FireinForest.linkedList.add(count);
            fired[y][x] = true;
        }
        
        FireinForest.linkedList.remove();
    }
}
