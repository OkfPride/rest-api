/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs_BreadthFirst;

import Graphs_DeepFirst.Vertex;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author summe
 */
public class BreadthFirst {

    public static void main(String[] args) {
        BreadthFirst graph = new BreadthFirst(10);
        graph.addVertex("A");//0
        graph.addVertex("B");//1
        graph.addVertex("C");//2
        graph.addVertex("D");//3
        graph.addVertex("F");//4
        graph.addVertex("E");//5
        graph.addVertex("F");//6
        graph.addEdge(0, 1);//ab
        graph.addEdge(1, 2);//bc
        graph.addEdge(2, 3);//cd
        graph.addEdge(0, 4);//af
        graph.addEdge(4, 5);//fe
        graph.addEdge(0, 6);//fe
//        graph.addEdge(5, 6);//
        graph.breadthFirst(0);
    }
    protected int maxNumbers;
    protected Vertex[] listOfVertexs;
    protected int[][] adjancency;
    int currentNumber;
    Deque<Integer> stack = new LinkedList<>();

    public BreadthFirst(int maxNumbers) {
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

    void breadthFirst(int index) {
        System.out.println(listOfVertexs[index].getName());
        listOfVertexs[index].setIsVisited(true);
        stack.add(index);
        int vertex;
        while (!stack.isEmpty()) {
            int temp = stack.poll();
            while ((vertex = check(temp)) != -1) {
//                if (check == -1) {
//                    stack.pop();
//                }
                System.out.println(listOfVertexs[vertex].getName());
                listOfVertexs[vertex].setIsVisited(true);
                stack.add(vertex);

            }

        }
        for (int i = 0; i < currentNumber; i++) {
            listOfVertexs[i].setIsVisited(false);
        }

    }

}
