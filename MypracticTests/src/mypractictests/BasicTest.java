/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypractictests;

/**
 *
 * @author JavaDev
 */
public class BasicTest implements lala{

    @Override
    public void met() {
        lala.super.met(); //To change body of generated methods, choose Tools | Templates.
    }

    int t = lala.A;
    Integer a = t;
    public static void main(String[] args) {
        lala.stat();
        BasicTest basicTest = new BasicTest();
        basicTest.met();
    }
}

interface lala {

    int A = 10;
    default void met(){
        System.out.println("default");
    }
    static void stat(){
        System.out.println("static");
    }
            

}
