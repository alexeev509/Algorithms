package maxMultiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        int[] index_mass = new int[mass.length];
        for (int i = 0; i < mass.length; i++) {
            index_mass[i] = i;
        }

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < i; j++) {
                int mult = mass[j] * mass[i];
                if (mult <= multiplicationNumber && multiplicationNumber % mult == 0) {

                    if (counter_mass[i] + 1 < countOfElements && mult < multiplicationNumber) {
                        multiplication_mass[i] = mult;
                        index_mass[i] = j;
                        counter_mass[i]++;
                    }
                    if (counter_mass[i] + 1 == countOfElements && mult == multiplicationNumber) {
                        multiplication_mass[i] = mult;
                        index_mass[i] = j;
                        counter_mass[i]++;
                        break;
                    }
                }
            }
//            if (counter_mass[i] != countOfElements) {
//                index_mass[i]=i;
//            }
        }
        System.out.println("MASS: " + Arrays.toString(mass));
        System.out.println("MULTIPLICATION: " + Arrays.toString(multiplication_mass));
        System.out.println("INDEX:          " + Arrays.toString(index_mass));
        System.out.println("COUNT: " + Arrays.toString(counter_mass));

        int find_index = find_index_of_searching_element(multiplication_mass);
        return getResultIdexes(find_index, index_mass);
    }

    private static int find_index_of_searching_element(int[] multiplication_mass) {
        int find_idex = -1;
        for (int i = 0; i < multiplication_mass.length; i++) {
            if (multiplication_mass[i] == multiplicationNumber) {
                find_idex = i;
                break;
            }
        }
        return find_idex;
    }

    public static List<Integer> getResultIdexes(int find_index, int[] index_mass) {
        List<Integer> answer = new ArrayList<Integer>();
        while (countOfElements > 0) {
            answer.add(find_index + 1);
            find_index = index_mass[find_index];
            countOfElements--;
        }
        System.out.println(answer.toString());
        return answer;
    }
}
