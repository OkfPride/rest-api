/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs_DeepFirst;

/**
 *
 * @author summe
 */

public class Vertex {
    private String name;
    private boolean isVisited;
    private int cost;
    Color color ;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
}
