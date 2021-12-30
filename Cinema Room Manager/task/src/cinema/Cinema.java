package cinema;

import java.util.Scanner;

public class Cinema {
    static String[][] grid = new String[10][10];
    static String[][] gridPrice = new String[10][10];
    static int a, b;

    public static void main(String[] args) {
        start();
    }

    static void start() {
        var s = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        a = s.nextInt();
        System.out.println("Enter the number of seats in each row:");
        b = s.nextInt();

        rysujSale(a, b, 1);

        while (true) {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");

            int choice = s.nextInt();

            switch (choice) {
                case 1 : rysujSale(a, b, 3);
                    break;
                case 2 :
                    System.out.println("\nEnter a row number:");
                    int c = s.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int d = s.nextInt();
                    System.out.println("\nTicket price: $" + gridPrice[c][d]);
                    rysujSale(c, d, 2);
                    break;
                case 0 : return;
            }
        }
    }

    /**
     *
     * @param x rozmiar sali (rzedy)
     * @param y rozmiar sali (miejsca w rzedzie)
     * @param wariant 1-tworzy sale o zadanych parametrach i ustala ceny dla poszczegolnych miejsc
     *                2-dodaje rezerwacje na zadanym miejscu
     *                3-drukuje aktualny stan sali
     */

    static void rysujSale(int x, int y,int wariant) {
        System.out.println("\nCinema:");

        if (wariant == 1) {

        //wypelnia tablice obrazem sali o zadanych wymiarach
        //wypelnia tez druga tablice, ktora zawiera ceny biletow dla poszczegolnych miejsc
        grid[0][0] = " ";
        gridPrice[0][0] = " ";
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                grid[i][j] = "S";
                if (x * y < 60) {
                    gridPrice[i][j] = String.valueOf(10);
                }
                else {
                    if (x / 2 >= i) {
                        gridPrice[i][j] = String.valueOf(10);
                    }
                    else {
                        gridPrice[i][j] = String.valueOf(8);
                    }

                }
            }
            grid[0][i] = String.valueOf(i);
            grid[i][0] = String.valueOf(i);
            gridPrice[0][i] = String.valueOf(i);
            gridPrice[i][0] = String.valueOf(i);

        }
        //przypadek, gdy jest wiecej miejsc w rzedzie niz rzedow
        if (x < y) {
            for (int i = 1; i <= y; i++) {
                grid[0][i] = String.valueOf(i);
                gridPrice[0][i] = String.valueOf(i);

            }
        }
        //rysuje sale
//        for (int i = 0; i <= x; i++) {
//            for (int j = 0; j <= y; j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for (int i = 0; i <= a; i++) {
//            for (int j = 0; j <= b; j++) {
//                System.out.print(gridPrice[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
        //zaznacza wybrane miejsce na sali
        if (wariant == 2) {
            grid[x][y] = "B";
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= b; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
        //drukuje aktualny stan sali
        if (wariant == 3) {
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= b; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}