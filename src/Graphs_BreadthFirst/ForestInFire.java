/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs_BreadthFirst;

/**
 *
 * @author summe
 */
public class ForestInFire extends BreadthFirst {

    int arr[][] = new int[maxNumbers][maxNumbers];

    public ForestInFire(int maxNumbers) {
        super(maxNumbers);
    }

    public static void main(String[] args) {
        BreadthFirst graph = new ForestInFire(11);
        graph.addVertex("A");//0

        graph.addVertex("B");//1
        graph.addVertex("C");//2
        graph.addVertex("D");//3
        graph.addVertex("F");//4
        graph.addEdge(0, 1);//ab
        graph.addEdge(0, 2);//ac
        graph.addEdge(0, 3);//ad
        graph.addEdge(0, 4);//af

        graph.addVertex("BA");//5
        graph.addVertex("CA");//6
        graph.addVertex("BB");//7
        graph.addVertex("CB");//8
        graph.addEdge(1, 5);//b-ba
        graph.addEdge(2, 6);//c-ca
        graph.addEdge(1, 7);//b-bb
        graph.addEdge(2, 8);//c-cb

        graph.addVertex("CAA");//9
        graph.addVertex("CAB");//10
        graph.addEdge(6, 9);//ca-caa
        graph.addEdge(6, 10);//ca-cab

        graph.breadthFirst(0);
    }

    @Override
    void breadthFirst(int index) {
        int count = 2;
        int x = 0;
        int y = 0;
        System.out.println(listOfVertexs[index].getName() + " | count = " + count + "\n");
        listOfVertexs[index].setIsVisited(true);
        stack.add(index);
        int vertex;
        while (!stack.isEmpty()) {
            int temp = stack.poll();
            count++;

            System.out.println("");
            while ((vertex = check(temp)) != -1) {
//                if (check == -1) {
//                    stack.pop();
//                }
                System.out.println(listOfVertexs[vertex].getName() + " | count = " + count);
                listOfVertexs[vertex].setIsVisited(true);
                stack.add(vertex);
            }
        }
    }
}
