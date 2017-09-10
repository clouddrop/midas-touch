/**
 * Created by samar.kumar on 9/8/16.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        int sumE = 0;
        int sumD = 0;
        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < n; a_j++) {
                a[a_i][a_j] = in.nextInt();
                if (a_i == a_j) {
                    sumE += a[a_i][a_j];
                }

                if (a_i + a_j == n - 1) {
                    sumD += a[a_i][a_j];
                }


            }


        }

        if (sumE > sumD) {
            System.out.println((sumE - sumD));
        } else {
            System.out.println((sumD - sumE));

        }
    }
}