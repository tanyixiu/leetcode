package org.example.tool;

public class Util {
    public static void printGrid(int[][] array) {
        System.out.println("******************************************");
        System.out.println();
        printColumns(array);
        printRowSeparator(array);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-3s| ", i);
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%-3s%s", array[i][j], (j < array[i].length - 1) ? "," : "");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("******************************************");
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-3s%s", array[i], (i < array.length - 1) ? "," : "");
        }
        System.out.println();
    }

    private static void printRowSeparator(int[][] array) {
        for (int i = 0; i <= array[0].length; i++) {
            System.out.print("----");
        }
        System.out.println();
    }

    private static void printColumns(int[][] array) {
        System.out.printf("%-3s| ", "dp");
        for (int i = 0; i < array[0].length; i++) {
            System.out.printf("%-3s%s", i, (i < array[0].length - 1) ? "," : "");
        }
        System.out.println();
    }
}
