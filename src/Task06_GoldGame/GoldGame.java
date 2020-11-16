/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task06_GoldGame;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class GoldGame {

    public static void main(String[] args) {
        int[] name = new int[]{ 80, 939, 229, 183, 471, 144, 947, 93, 54};
//        int[] name2 = new int[]{  33, 812, 176, 391, 564, 523, 764, 200, 935, 999, 442, 79, 808, 553};
//        int[] toString = distributionOf(name);
        summArr(name);
//        summArr(name2);
//        summArr(toString);
//        System.out.println(Arrays.toString(toString));

    }

    static void summArr(int[] golds) {
        int res = 0;
        int even = 0;
        int odd = 0;
        for (int gold : golds) {
            res += gold;
        }
        for (int i = 1; i <= golds.length; i++) {
            if (i % 2 == 1) {
                odd += golds[i - 1];
            } else {
                even += golds[i - 1];
            }
        }
        System.out.println(res);
        System.out.println("odd = " + odd);
        System.out.println("even = " + even);
    }

    public static int[] distributionOf(int[] golds) {
        //int[] name = new int[]{986, 33, 812, 176, 391, 564, 523, 764, 200, 935, 999, 442, 79, 808, 553};
        System.out.println(Arrays.toString(golds));
        int leftPos = 0;
        int rightPos = golds.length - 1;
        int[] players = new int[]{0, 0};
        int turn = 1;

        int res = 0;
        int even = 0;
        int odd = 0;
//        for (int gold : golds) {
//            res += gold;
//        }
//        for (int i = 1; i <= golds.length; i++) {
//            if (i % 2 == 1) {
//                odd += golds[i - 1];
//            } else {
//                even += golds[i - 1];
//            }
//        }

        for (int i = 0; i < golds.length; i++) {
            int player = -1;
            if (turn++ % 2 == 0) {
                player = 1;
            } else {
                player = 0;
            }
            if (rightPos - leftPos <= 2) {
                if (golds[leftPos] > golds[rightPos]) {
                    System.out.println("player " + player + " + " + golds[leftPos]);
                    players[player] += golds[leftPos++];
                } else if (golds[leftPos] < golds[rightPos]) {
                    System.out.println("player " + player + " + " + golds[rightPos]);
                    players[player] += golds[rightPos--];
                } else if (golds[leftPos] == golds[rightPos]) {
                    System.out.println("player " + player + " + " + golds[leftPos]);
                    players[player] += golds[leftPos];
                }
            } else {
                if (leftPos < golds.length - 1 && rightPos > 0) {
                    for (int j = 1; j <= golds.length; j++) {
                        if (j % 2 == 1) {
                            odd += golds[j - 1];
                        } else {
                            even += golds[j - 1];
                        }
                    }
                    System.out.println("odd = " + odd);
                    System.out.println("even = " + even);
                    if (odd > even) {
                        System.out.println(rightPos - leftPos + 1);
                        System.out.println("left "+((leftPos+1) % 2 == 1) );
                        System.out.println("right "+((rightPos+1) % 2 == 1) );
                        
                        if ((leftPos+1) % 2 == 1 || (rightPos+1) % 2 == 1) {
                            if ((leftPos+1) % 2 == 0 && (rightPos+1) % 2 == 0) {
                                if (golds[leftPos] > golds[rightPos]) {
                                    System.out.println("player " + player + " + " + golds[leftPos]);
                                    players[player] += golds[leftPos];
                                    golds[leftPos++] = 0;
                                } else {
                                    System.out.println("player " + player + " + " + golds[rightPos]);
                                    players[player] += golds[rightPos];
                                    golds[rightPos--] = 0;
                                }
                            } else if ((leftPos+1) % 2 == 0) {
                                System.out.println("player " + player + " + " + golds[leftPos]);
                                players[player] += golds[leftPos];
                                golds[leftPos++] = 0;
                            } else if ((rightPos+1) % 2 == 0) {
                                System.out.println("player " + player + " + " + golds[rightPos]);
                                players[player] += golds[rightPos];
                                golds[rightPos--] = 0;
                            }
//                        if (golds[leftPos] > golds[rightPos]) {
//                            System.out.println("player " + player + " + " + golds[leftPos]);
//                            players[player] += golds[leftPos];
//                            golds[leftPos++] = 0;
//                        } else {
//                            System.out.println("player " + player + " + " + golds[rightPos]);
//                            players[player] += golds[rightPos];
//                            golds[rightPos--] = 0;
//                        }
                    } else if (odd <= even) {
                        System.out.println(rightPos - leftPos + 1);
                        System.out.println("left "+((leftPos+1) % 2 == 0) );
                        System.out.println("right "+((rightPos+1) % 2 == 0) );
                        if ((leftPos+1) % 2 == 0 || (rightPos+1) % 2 == 0) {
                            if ((leftPos+1) % 2 == 0 && (rightPos+1) % 2 == 0) {
                                if (golds[leftPos] > golds[rightPos]) {
                                    System.out.println("player " + player + " + " + golds[leftPos]);
                                    players[player] += golds[leftPos];
                                    golds[leftPos++] = 0;
                                } else {
                                    System.out.println("player " + player + " + " + golds[rightPos]);
                                    players[player] += golds[rightPos];
                                    golds[rightPos--] = 0;
                                }
                            } else if ((leftPos+1) % 2 == 0) {
                                System.out.println("player " + player + " + " + golds[leftPos]);
                                players[player] += golds[leftPos];
                                golds[leftPos++] = 0;
                            } else if ((rightPos+1) % 2 == 0) {
                                System.out.println("player " + player + " + " + golds[rightPos]);
                                players[player] += golds[rightPos];
                                golds[rightPos--] = 0;
                            }
                           
                        }else{
                            if (golds[leftPos] > golds[rightPos]) {
                            System.out.println("player " + player + " + " + golds[leftPos]);
                            players[player] += golds[leftPos];
                            golds[leftPos++] = 0;
                        } else {
                            System.out.println("player " + player + " + " + golds[rightPos]);
                            players[player] += golds[rightPos];
                            golds[rightPos--] = 0;
                        }
                        }

                    }
                    odd = 0;
                    even = 0;
                }

            }
        }
        return players;
    }
//    public static int[] distributionOf(int[] golds) {
//        System.out.println(Arrays.toString(golds));
//        int leftPos = 0;
//        int rightPos = golds.length - 1;
//        int[] players = new int[]{0, 0};
//        int turn = 1;
//        for (int i = 0; i < golds.length; i++) {
//            int player = -1;
//            if (turn++ % 2 == 0) {
//                player = 1;
//            } else {
//                player = 0;
//            }
//            if (rightPos - leftPos <= 2) {
//                if (golds[leftPos] > golds[rightPos]) {
//                    System.out.println("player " + player + " + " + golds[leftPos]);
//                    players[player] += golds[leftPos++];
//                } else if (golds[leftPos] < golds[rightPos]) {
//                    System.out.println("player " + player + " + " + golds[rightPos]);
//                    players[player] += golds[rightPos--];
//                } else if (golds[leftPos] == golds[rightPos]) {
//                    System.out.println("player " + player + " + " + golds[leftPos]);
//                    players[player] += golds[leftPos];
//                }
//            } else {
//                if (leftPos < golds.length - 1 && rightPos > 0) {
//                    if (golds[leftPos] + golds[rightPos - 1] > golds[leftPos + 1] + golds[rightPos]) {
//                        System.out.println("player " + player + " + " + golds[leftPos]);
//                        players[player] += golds[leftPos++];
//                    } else if (golds[leftPos] + golds[rightPos - 1] < golds[leftPos + 1] + golds[rightPos]) {
//                        System.out.println("player " + player + " + " + golds[rightPos]);
//                        players[player] += golds[rightPos--];
//                    } else if (golds[leftPos] + golds[rightPos - 1]== golds[leftPos + 1] + golds[rightPos]) {
//                        if (golds[leftPos + 1] > golds[rightPos - 1]) {
//                            System.out.println("player " + player + " + " + golds[rightPos]);
//                            players[player] += golds[rightPos--];
//                        } else if (golds[leftPos + 1] == golds[rightPos - 1]) {
//                            if (golds[leftPos] > golds[rightPos]) {
//                                System.out.println("player " + player + " + " + golds[leftPos]);
//                                players[player] += golds[leftPos++];
//                            } else {
//                                System.out.println("player " + player + " + " + golds[rightPos]);
//                                players[player] += golds[rightPos--];
//                            }
//                        } else {
//                            System.out.println("player " + player + " + " + golds[leftPos]);
//                            players[player] += golds[leftPos++];
//                        }
//                    }
//                }
//
//            }
//        }
//        return players;
//    }
}
