package cinema;

import java.util.Scanner;

public class Cinema {
    static String[][] grid = new String[8][9];

    public static void main(String[] args) {
        
    }

    static void totalIncome() {
        var s = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int a = s.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int b = s.nextInt();
        int income;
        if (a * b < 60) {
            income = a * b * 10;
        }
        else {
            income = a / 2 * 10 * b + ((a - (a / 2)) * 8) * b;
        }
        System.out.println("Total income:\n$" + income);
    }

    static void rysujSale() {
        System.out.println("Cinema:");
        grid[0][0] = " ";
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 9; j++) {
                grid[i][j] = "S";
            }
            grid[0][i] = String.valueOf(i);
            grid[i][0] = String.valueOf(i);
            grid[0][8] = String.valueOf(8);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}