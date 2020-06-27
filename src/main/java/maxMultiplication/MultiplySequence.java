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
    static long multiplicationNumber;
    static int countOfElements;
    static long[] mass;

    public static void main(String[] args) throws IOException {
        readInput(System.in);
        List<Integer> answer = searchMultiplication();
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }


    public static void readInput(InputStream s) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(s));
        String[] firstLine = in.readLine().split(" ");
        massLen = Integer.parseInt(firstLine[0]);
        multiplicationNumber = Long.parseLong(firstLine[1]);
        countOfElements = Integer.parseInt(firstLine[2]);

        mass = new long[massLen];

        String[] secondLine = in.readLine().split(" ");
        for (int i = 0; i < massLen; i++) {
            mass[i] = Integer.parseInt(secondLine[i]);
        }
    }

    public static List<Integer> searchMultiplication() {
        long[] multiplication_mass = new long[mass.length];
        System.arraycopy(mass, 0, multiplication_mass, 0, mass.length);
        int[] counter_mass = new int[mass.length];
        Arrays.fill(counter_mass, 1);

        int[] index_mass = new int[mass.length];
        for (int i = 0; i < mass.length; i++) {
            index_mass[i] = i;
        }
        boolean stop = false;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < i; j++) {
                //Необходимо выбрать - брать новый элемент
                long mult = mass[j] * mass[i];
                //Или учитывать предыдущие умножения
                long mult2 = multiplication_mass[j] * mass[i];
//                if(i==6 && j==5){
//                    System.out.println();
//                }

                if (mult <= multiplicationNumber && multiplicationNumber % mult == 0) {

                    if (counter_mass[i] + 1 == countOfElements && mult == multiplicationNumber) {
                        multiplication_mass[i] = mult;
                        index_mass[i] = j;
                        counter_mass[i]++;
                        stop = true;
                        break;
                    } else if (counter_mass[i] + counter_mass[j] == countOfElements && mult2 == multiplicationNumber) {
                        multiplication_mass[i] = mult2;
                        index_mass[i] = j;
                        counter_mass[i] += counter_mass[j];
                        stop = true;
                        break;
                    } else if (counter_mass[i] + 1 < countOfElements && mult < multiplicationNumber) {
                        multiplication_mass[i] = mult;
                        index_mass[i] = j;
                        counter_mass[i]++;
                    }

                }

            }
            if (stop) {
                break;
            }
        }
//        System.out.println("MASS: " + Arrays.toString(mass));
//        System.out.println("MULTIPLICATION: " + Arrays.toString(multiplication_mass));
//        System.out.println("INDEX:          " + Arrays.toString(index_mass));
//        System.out.println("COUNT: " + Arrays.toString(counter_mass));

        int find_index = find_index_of_searching_element(multiplication_mass);
        return getResultIdexes(find_index, index_mass);
    }

    private static int find_index_of_searching_element(long[] multiplication_mass) {
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
        return answer;
    }
}


// else if (mult2 <= multiplicationNumber && multiplicationNumber % mult2 == 0) {
//
//         if (counter_mass[i] + counter_mass[j] < countOfElements && mult2 < multiplicationNumber) {
//        multiplication_mass[i] = mult2;
//        index_mass[i] = j;
//        counter_mass[i]+=counter_mass[j];
//        }
//        if (counter_mass[i] + counter_mass[j] == countOfElements && mult2 == multiplicationNumber) {
//        multiplication_mass[i] = mult2;
//        index_mass[i] = j;
//        counter_mass[i]+=counter_mass[j];
//        stop=true;
//        break;
//        }
//        }