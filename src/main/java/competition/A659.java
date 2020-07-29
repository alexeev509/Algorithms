package competition;

import java.io.InputStream;
import java.util.Scanner;

public class A659 {

    static int countOfDatasets;

    public static void main(String[] args) {
        readInput(System.in);
    }

    private static void readInput(InputStream s) {
        Scanner in = new Scanner(s);
        countOfDatasets = in.nextInt();
        for (int i = 0; i < countOfDatasets; i++) {
            int count_of_chars = in.nextInt();
            char[] firstString = in.next().toCharArray();
            char[] secondString = in.next().toCharArray();
            // find -1
            int counter = 0;
            boolean was_break = false;

            for (int j = 0; j < firstString.length && was_break == false; j++) {

                char prev = firstString[0];
                char min = secondString[0];
                int leftIndex = 0;
                int rightIndex = 0;
                for (int k = 0; k < firstString.length; k++) {
                    if (firstString[k] < secondString[k]) {
                        if (prev == firstString[k]) {
                            if (min > secondString[k]) {
                                min = secondString[k];
                            }
                            rightIndex = k;
                        } else if (prev < firstString[k]) {
                            break;
                        }
                    } else if (firstString[k] == secondString[k]) {
//                        prev=firstString[k+1];
                        if (k + 1 < firstString.length) {
                            min = secondString[k + 1];
                            leftIndex = k + 1;
                            prev = firstString[k + 1];
                        }
                    } else {
                        System.out.println(-1);
                        was_break = true;
                        break;
                    }
                }
                boolean changewas = false;
                for (int t = leftIndex; t <= rightIndex; t++) {
                    firstString[t] = min;
                    changewas = true;
                }
                if (changewas) {
                    counter++;
                }
            }
            if (was_break == false) {
                System.out.println(counter);
            }
        }
    }
}
