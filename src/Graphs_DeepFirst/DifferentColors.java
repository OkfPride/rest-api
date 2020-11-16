/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs_DeepFirst;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author summe
 */
public class DifferentColors {

    public static void main(String[] args) {
        DifferentColors graph = new DifferentColors(20);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);

        graph.addVertex("E");
        graph.addVertex("F");
        graph.addEdge(4, 5);

        graph.addVertex("G");
//        graph.deepFirst(0);
graph.changecolors();
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    int color = 0;
    private int maxNumbers;
    private Vertex[] listOfVertexs;
    private int[][] adjancency;
    int currentNumber;
    Deque<Integer> stack = new LinkedList<>();

    public DifferentColors(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        this.listOfVertexs = new Vertex[maxNumbers];
        this.adjancency = new int[maxNumbers][maxNumbers];
        this.currentNumber = 0;
    }

    void addVertex(String name) {
        Vertex vertex = new Vertex(name);
        listOfVertexs[currentNumber++] = vertex;
    }

    void addEdge(int start, int end) {
        adjancency[start][end] = 1;
        adjancency[end][start] = 1;
    }

    int check(int value) {

        for (int i = 0; i < currentNumber; i++) {
            if (adjancency[value][i] == 1 && !listOfVertexs[i].isIsVisited()) {
                return i;
            }
        }
        return -1;
    }

    void deepFirst(int index) {
//        System.out.println(listOfVertexs[index].getName());
        listOfVertexs[index].setIsVisited(true);
        if (!map.containsKey(index)) {
                map.put(index, color);
                }
        stack.push(index);
        while (!stack.isEmpty()) {
            int check = check(stack.peek());
            if (check == -1) {
                stack.pop();

            } else {
//                System.out.println(listOfVertexs[check].getName());
                listOfVertexs[check].setIsVisited(true);
                if (!map.containsKey(check)) {
                map.put(check, color);
                }
                stack.push(check);
            }
        }
        
    }

    void changecolors() {
        int count = currentNumber-1;
        while (count>=0) {            
            deepFirst(count);
            color++;
        count--;
        }
        System.out.println(map);
    }
}
