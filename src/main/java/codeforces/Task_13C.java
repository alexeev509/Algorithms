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
        int[] first_path = new int[size];
        int[] second_path = new int[size];

        if (size > 1) {
            first_path[0] = 0;
            second_path[0] = (sequence[1] - sequence[0]);

            first_path[1] = (sequence[0] - sequence[1]);
            second_path[1] = 0;
        }

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] < sequence[i - 1] + first_path[i - 1]) {
                first_path[i] = sequence[i - 1] + first_path[i - 1] - sequence[i];
            }
            if (sequence[i] < sequence[i - 1] + second_path[i - 1]) {
                second_path[i] = sequence[i - 1] + second_path[i - 1] - sequence[i];
            }
        }

        int answer = getMaxSumm(first_path, second_path);
        System.out.println(answer);
        return answer;
    }

    public static int getMaxSumm(int[] first_path, int[] second_path) {
        int summ1 = 0;
        int summ2 = 0;

        for (int i = 0; i < size; i++) {
            summ1 += Math.abs(first_path[i]);
            summ2 += Math.abs(second_path[i]);
        }
        return Math.min(summ1, summ2);
    }
}
