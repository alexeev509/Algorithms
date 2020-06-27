package maxMultiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

//IN PROCESS !!
public class MultiplySequence {

    static int massLen;
    static int multiplicationNumber;
    static int countOfElements;
    static int[] mass;

    public static void main(String[] args) throws IOException {
        readInput(System.in);
        searchMultiplication();
    }


    public static void readInput(InputStream s) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(s));
        massLen = Integer.parseInt(in.readLine());
        multiplicationNumber = Integer.parseInt(in.readLine());
        countOfElements = Integer.parseInt(in.readLine());

        mass = new int[massLen];

        for (int i = 0; i < massLen; i++) {
            mass[i] = Integer.parseInt(in.readLine());
        }
    }

    public static List<Integer> searchMultiplication() {
        int[] multiplication_mass = new int[mass.length];
        System.arraycopy(mass, 0, multiplication_mass, 0, mass.length);
        int[] counter_mass = new int[mass.length];
        Arrays.fill(counter_mass, 1);
        System.out.println(Arrays.toString(counter_mass));

        int[] index_mass = new int[mass.length];
        for (int i = 0; i < mass.length; i++) {
            index_mass[i] = i;
        }

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < i; j++) {
                int mult = multiplication_mass[j] * multiplication_mass[i];
                if (mult <= multiplicationNumber) {
                    if (counter_mass[j] < countOfElements && mult < multiplicationNumber) {
                        multiplication_mass[i] = mult;
                        index_mass[i] = j;
                    }
                    if (counter_mass[j] == countOfElements && mult == multiplicationNumber) {
                        multiplication_mass[i] = mult;
                        index_mass[i] = j;
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(multiplication_mass));
        return null;
    }
}
