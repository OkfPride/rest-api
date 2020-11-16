/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestWay;

import Graphs_DeepFirst.Vertex;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author summe
 */
public class Graph {

    protected int maxLength;
    protected Vertex[] vertexList;
    protected int[][] adjancency;
    protected int currentNumber;
    protected LinkedList stack;
//    int[] distance = new int[maxLength];

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("A");//0
        graph.addVertex("B");//1
        graph.addVertex("C");//2
        graph.addVertex("D");//3
        graph.addVertex("E");//4
        graph.addVertex("F");//5

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 2);
        graph.addEdge(0, 3, 16);
        graph.addEdge(1, 2, 20);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 5);
        graph.addEdge(3, 5, 4);
        graph.shortest(0);
        
        for (int i = 0; i < graph.vertexList.length; i++) {
            if (graph.vertexList[i]!=null) {
                
            int cost = graph.vertexList[i].getCost();
            System.out.println("distance to "+graph.vertexList[i].getName()+" = "+cost);
            }
            
        }
    }
       private Vertex parent;

    public Graph(int maxLength) {
        this.maxLength = maxLength;
        adjancency = new int[maxLength][maxLength];
        vertexList = new Vertex[maxLength];
        stack = new LinkedList<Integer>();
    }

    void addVertex(String nameString) {
        Vertex vertex = new Vertex(nameString);
//        vertex.setCost(cost); 
        vertexList[currentNumber++] = vertex;
    }

    void addEdge(int start, int end, int cost) {
        adjancency[start][end] = cost;

//        adjancency[end][start] = 1;
    }

    int check(int value) {

        for (int i = 0; i < currentNumber; i++) {
            if (adjancency[value][i] > 1 && !vertexList[i].isIsVisited()) {
//                parent = vertexList[i];
                vertexList[i].setCost(adjancency[value][i]+parent.getCost());
//                System.out.println(vertexList[i].getName() +" set cost in check = "+(adjancency[value][i]+parent.getCost()));
//                distance[i] = 0;
                return i;
            }
            int newcost = adjancency[value][i]+parent.getCost(); 
            if (adjancency[value][i] > 1 &&vertexList[i].isIsVisited()&&vertexList[i].getCost()>newcost) {
               vertexList[i].setCost(newcost);
               return i;
//               System.out.println(vertexList[i].getName()+" new cost is = " +vertexList[i].getCost());
            }
            
        }
        return -1;
    }

    void shortest(int index) {
        vertexList[index].setIsVisited(true);
//        System.out.println(vertexList[index].getName() + " distance is = " + vertexList[index].getCost());
        stack.add(index);
//        distance[index] = 0;
        int vertex;
        while (!stack.isEmpty()) {
            int temp = (int) stack.poll();
            parent = vertexList[temp];
//            System.out.println("distance to "+parent.getName()+" " +parent.getCost());
            while ((vertex = check(temp)) != -1) {
//               vertexList[vertex].setCost(temp);
//                System.out.println(vertexList[vertex].getName() + " distance is = " + (vertexList[vertex].getCost()));
                vertexList[vertex].setIsVisited(true);
                stack.add(vertex);

            }

        }
        for (int i = 0; i < currentNumber; i++) {
            vertexList[i].setIsVisited(false);
        }

    }

    ArrayList<Integer> getShortestWay(int start) {
        ArrayList<Integer> ListDistance = new ArrayList<Integer>();
        for (int i = 0; i < currentNumber; i++) {
            ListDistance.add(Integer.MAX_VALUE);
        }
        ListDistance.set(0, 0);
        int index = -1;
        for (int i = 0; i < currentNumber; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < currentNumber; j++) {
                if (!vertexList[j].isIsVisited() && ListDistance.get(j) <= min) {
                    min = ListDistance.get(j);
                    index = j;
                }
            }
            vertexList[index].setIsVisited(true);
            for (int j = 0; j < currentNumber; j++) {
                if (!vertexList[j].isIsVisited()
                        && adjancency[index][j] > 0
                        && ListDistance.get(index) != Integer.MAX_VALUE
                        && ListDistance.get(index) + adjancency[index][j] < ListDistance.get(j)) {

                    ListDistance.set(index, (ListDistance.get(index) + adjancency[index][j]));
                }
            }
        }
        return ListDistance;
    }
}
