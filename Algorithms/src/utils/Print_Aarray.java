package utils;

public class Print_Aarray {

    public static void print_array_1(int[] arr) {
        for (Object x : arr)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("------------------------------");
    }

    public static void print_array_1(Object[] arr) {
        for (Object x : arr)
            System.out.print(x + " ");
        System.out.println("------------------------------");
    }

    public static void print_array_2(int[][] m) {
        int r = m.length;
        int c = m[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j] + "");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    public static void print_array_2(char[][] m) {
        int r = m.length;
        int c = m[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j] + "");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    public static void print_array_2(boolean[][] t) {
        int r = t.length;
        int c = t[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(t[i][j] ? " T" : " F");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
