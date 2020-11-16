/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_DiceGame;

/**
 *
 * @author summe
 */
public class SellTicketsWOChange {

    public static void main(String[] args) {
        SellTicketsWOChange sellTicketsWOChange = new SellTicketsWOChange();
        String Tickets = SellTicketsWOChange.Tickets(new int[]{25, 50, 50, 100, 25, 25, 50});
        System.out.println(Tickets);
    }
//    public static String Tickets(int[] peopleInLine){
//        int change = 0;
//        for (int i : peopleInLine) {
//            if (i==25) {
//            change+=25;
//            }else if (change<i) {
//                return "NO";
//            }
//            change-=i-25;
//        }
//      return "YES";
//  }

    public static String Tickets(int[] peopleInLine) {
        int change = 0;
        int d25 = 0;
        int d50 = 0;
        for (int i : peopleInLine) {
            if (i==25) {
                d25++;
            }
            if (i==50) {
                if (d25<=0) {
                    return "NO";
                }
                else {
                d25--;
                d50++;
                }
            }
            if (i==100) {
                if (change<75) {
                    return "NO";
                }
                if ((d25<1||d50<1)&&(d25<3)) {
                    return "NO";
                }
                if (d25>=1&&d50>=1) {
                    d25--;
                    d50--;
                }
                if (d25>=3) {
                    d25-=3;
                }
            }
             change+=25;
        }
        return "YES";
    }
}
