/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincidenceInStrings;

import java.util.Arrays;

/**
 *
 * @author summe
 */
public class Straight {

    int[][] tableOfCoincidence;
    String up;
    String left;
    char[] upArray;
    char[] leftray;

    public static void main(String[] args) {
        Straight straight = new Straight("abc", "abbc");
        straight.straightCoincidence();
        straight.summOfALlCoincidence();

    }

    public Straight(String up, String left) {
        this.tableOfCoincidence = new int[left.length() + 1][up.length() + 1];
        this.up = up;
        this.left = left;
        this.upArray = up.toCharArray();
        this.leftray = left.toCharArray();
    }

    void straightCoincidence() {
        for (int i = 0; i < left.length(); i++) {
            for (int j = 0; j < up.length(); j++) {
                if (upArray[j] == leftray[i]) {
                    if (j == 0 || i == 0) {
                        tableOfCoincidence[i + 1][j + 1] = 1;
                    } else {
                        tableOfCoincidence[i + 1][j + 1] = 1 + tableOfCoincidence[i][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(tableOfCoincidence));
    }

    void summOfALlCoincidence() {
        for (int i = 0; i < left.length(); i++) {
            for (int j = 0; j < up.length(); j++) {
                if (upArray[j] == leftray[i]) {

                    tableOfCoincidence[i + 1][j + 1] = 1 + Math.max(tableOfCoincidence[i][j + 1], tableOfCoincidence[i + 1][j]);

                } else {
                    tableOfCoincidence[i + 1][j + 1] = Math.max(tableOfCoincidence[i][j + 1], tableOfCoincidence[i + 1][j]);
                }

            }
        }
        System.out.println(Arrays.deepToString(tableOfCoincidence));
    }

}
