package codeforces;

import java.io.InputStream;
import java.util.Scanner;

public class Task_13C {

    private static int size;
    private static int[] sequence;

    public static void main(String[] args) {
        readInput(System.in);
    }

    public static void readInput(InputStream s) {
        Scanner in = new Scanner(s);
        size = in.nextInt();
        sequence = new int[size];
        for (int i = 0; i < size; i++) {
            sequence[i] = in.nextInt();
        }
    }

    public static int findAnswer() {
        //NOP
        return -1;
    }
}
