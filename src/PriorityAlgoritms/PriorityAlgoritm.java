/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityAlgoritms;

import Graphs_DeepFirst.Vertex;
import java.util.Deque;
import java.util.LinkedList;
import Graphs_DeepFirst.Color;

/**
 *
 * @author summe
 */
public class PriorityAlgoritm {

    public static void main(String[] args) throws Exception {
        PriorityAlgoritm graph = new PriorityAlgoritm(10);
        graph.addVertex("A");//0
        graph.addVertex("B");//1
        graph.addVertex("C");//2
        graph.addVertex("D");//3
        graph.addVertex("E");//4
        graph.addVertex("F");//5
        graph.addEdge(0, 5);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);
        graph.addEdge(5, 2);
        graph.addEdge(4, 1);
        graph.addEdge(5, 4);
        
//        graph.addEdge(2, 5);
        graph.attempt2();
graph.result.forEach((t) -> {System.out.println(t.getName());
});
//        graph.deepFirst(0);
    }
    private int maxNumbers;
    private Vertex[] listOfVertexs;
    private int[][] adjancency;
    int currentNumber;
    Deque<Integer> path = new LinkedList<>();
    Deque<Vertex> result = new LinkedList<>();
    
    void attempt2() throws Exception {
        for (int i = 0; i < currentNumber; i++) {
            int savedPossition = i;
            int vertexPossition = i;
            
            if (path.size() > 0) {
                i--;
                vertexPossition = path.pop();
                savedPossition = vertexPossition;
            }
            
            if (listOfVertexs[vertexPossition].getColor() == Color.BLACK) {
                continue;
            }
            listOfVertexs[vertexPossition].setColor(Color.GRAY);
            path.push(vertexPossition);
            
            for (int j = 0; j < currentNumber; j++) {
                if (adjancency[vertexPossition][j]!=0&&listOfVertexs[j].getColor()!=Color.BLACK) {
                    if (listOfVertexs[j].getColor()==Color.GRAY) {
                        throw new Exception("vertex = "+vertexPossition+" j = "+j);
                    }
                    vertexPossition=j;
                    path.push(vertexPossition);
                    break;
                }
            }
            if (vertexPossition==savedPossition) {
                listOfVertexs[vertexPossition].setColor(Color.BLACK);
                result.push(listOfVertexs[vertexPossition]);
                path.pop();
                
            }
        }
    }

    public PriorityAlgoritm(int maxNumbers) {
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
//        adjancency[end][start] = 1;
    }
    
    int check(int value) {
        
        for (int i = 0; i < currentNumber; i++) {
            if (adjancency[value][i] == 1 && !listOfVertexs[i].isIsVisited()) {
                listOfVertexs[i].setColor(Color.WHITE);
                return i;
            }
            if (listOfVertexs[i].isIsVisited()) {
                
            }
        }
        return -1;
    }
    
    void deepFirst(int index) {
        System.out.println(listOfVertexs[index].getName());
        listOfVertexs[index].setIsVisited(true);
        path.push(index);
        while (!path.isEmpty()) {
            int check = check(path.peek());
            if (check == -1) {
                path.pop();
                
            } else {
                System.out.println(listOfVertexs[check].getName());
                listOfVertexs[check].setIsVisited(true);
                path.push(check);
            }
        }
        for (int i = 0; i < currentNumber; i++) {
            listOfVertexs[i].setIsVisited(false);
        }
    }

    void priorityTasks(int indexCurrendPossition) {
        path.push(indexCurrendPossition);
        listOfVertexs[indexCurrendPossition].setColor(Color.GRAY);
        while (!path.isEmpty()) {            
            int indexNextVertex = check(path.peek());
            
        }
    }
}
