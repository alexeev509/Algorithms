package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Task_10D {

    static int size_of_first_sequence;
    static int[] first_sequence;

    static int size_of_second_sequence;
    static int[] second_sequence;

    static int[][] result_mass;

    public static void main(String[] args) throws IOException {
        readInput(System.in);
        getAnswerSequence();
    }

    public static void readInput(InputStream s) throws IOException {
        Scanner in = new Scanner(s);
        size_of_first_sequence = in.nextInt();
        first_sequence = new int[size_of_first_sequence + 1];
        for (int i = 1; i <= size_of_first_sequence; i++) {
            first_sequence[i] = in.nextInt();
        }

        size_of_second_sequence = in.nextInt();
        second_sequence = new int[size_of_second_sequence + 1];
        for (int i = 1; i <= size_of_second_sequence; i++) {
            second_sequence[i] = in.nextInt();
        }
        result_mass = new int[size_of_second_sequence][size_of_first_sequence];
    }

    public static void getAnswerSequence() {

        //f - this is mass of count of elements in max sequences
        int[] f = new int[size_of_first_sequence + 1];
        //g - this is mass for indexes for every max element
        int[] g = new int[size_of_first_sequence + 1];
        for (int i = 1; i <= size_of_second_sequence; i++) {
            int k = 0;
            for (int j = 1; j <= size_of_first_sequence; j++) {
                if (second_sequence[i] == first_sequence[j]) {
                    f[j] = f[k] + 1;
                    g[j] = k;
                } else {
                    if (second_sequence[i] > first_sequence[j] && f[k] < f[j]) {
                        k = j;
                    }
                }
            }
        }

        int x = getMaxIndex(f);
        System.out.println(f[x]);
        printAnswer(x, g);
    }

    private static void printAnswer(int x, int[] g) {
        if (x == 0) return;
        printAnswer(g[x], g);
        System.out.print(first_sequence[x] + " ");
    }

    private static int getMaxIndex(int[] f) {
        int x = 0;
        for (int i = 1; i <= size_of_first_sequence; i++) {
            if (f[i] > f[x])
                x = i;
        }
        return x;
    }
}
