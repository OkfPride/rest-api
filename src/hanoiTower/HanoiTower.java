/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoiTower;

/**
 *
 * @author summe
 */
public class HanoiTower {
    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.build(3,1,3,2);
        
    }
    void build(int numberOfDiscs,int from, int to, int helpfulPIVOT){
        if (numberOfDiscs!=0) {
            
        build(numberOfDiscs-1,from,helpfulPIVOT,to);
        System.out.println(from+" -> "+to);
        build(numberOfDiscs-1,helpfulPIVOT,to,from);
        }
    }
}
