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
    static double multiplicationNumber;
    static long countOfElements;
    static double[] mass;

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
        multiplicationNumber = Double.parseDouble(firstLine[1]);
        countOfElements = Long.parseLong(firstLine[2]);

        mass = new double[massLen];

        String[] secondLine = in.readLine().split(" ");
        for (int i = 0; i < massLen; i++) {
            mass[i] = Double.parseDouble(secondLine[i]);
        }
    }

    public static List<Integer> searchMultiplication() {
        double[] multiplication_mass = new double[mass.length];
        System.arraycopy(mass, 0, multiplication_mass, 0, mass.length);
        long[] counter_mass = new long[mass.length];
        Arrays.fill(counter_mass, 1);

        int[] index_mass = new int[mass.length];
        for (int i = 0; i < mass.length; i++) {
            index_mass[i] = i;
        }
        boolean stop = false;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < i; j++) {
                //Необходимо умножить новый элемент на текущий - брать новый элемент
                double mult = mass[j] * mass[i];
                //Или учитывать предыдущие умножения нового элемента
                double mult2 = multiplication_mass[j] * mass[i];

                double mult3 = multiplication_mass[i] * mass[j];

                if (i == 4) {
                    System.out.println("");
                }
                if (multiplicationNumber % mult == 0 && multiplicationNumber % mult2 == 0) {
                    if (mult >= mult2) {
                        // Если найдено нужное число и количествое его умножений = 2
                        if (mult == multiplicationNumber && countOfElements == counter_mass[i] + 1) {
                            multiplication_mass[i] = mult;
                            index_mass[i] = j;
                            counter_mass[i] += 1;
                            stop = true;
                            break;
                        }
                        //Иначе (может надо проверять - чтобы mult!=multiplicationNumber ??)
                        else if (countOfElements != counter_mass[i] + 1) {
                            multiplication_mass[i] = mult;
                            index_mass[i] = j;
//                            counter_mass[i] = 2;
                            counter_mass[i]++;

                        } else {
                            multiplication_mass[i] = mult;
                            index_mass[i] = j;
                            counter_mass[i] = 2;
                        }
                    } else {
                        if (mult2 == multiplicationNumber && countOfElements == counter_mass[j] + 1) {
                            multiplication_mass[i] = mult2;
                            index_mass[i] = j;
                            counter_mass[i] = counter_mass[j] + 1;
                            stop = true;
                            break;
                        } else if (countOfElements != counter_mass[j] + 1) {
                            multiplication_mass[i] = mult2;
                            index_mass[i] = j;
                            counter_mass[i] = counter_mass[j] + 1;
                        }
                    }
                } else if (multiplicationNumber % mult == 0) {
                    // Если найдено нужное число и количествое его умножений = 2
                    if (mult == multiplicationNumber && countOfElements == counter_mass[i] + 1) {
                        multiplication_mass[i] = mult;
                        index_mass[i] = j;
                        counter_mass[i]++;
                        stop = true;
                        break;
                    }
                    //Иначе (может надо проверять - чтобы mult!=multiplicationNumber ??)
                    else if (countOfElements != counter_mass[i] + 1) {
                        multiplication_mass[i] = mult;
                        index_mass[i] = j;
//                        counter_mass[i] = 2;
                        counter_mass[i]++;
                    } else {
                        multiplication_mass[i] = mult;
                        index_mass[i] = j;
                        counter_mass[i] = 2;
                    }
                } else if (multiplicationNumber % mult2 == 0) {
                    // Если найдено нужное число и количествое его умножений = counter_mass[j]+1
                    if (mult2 == multiplicationNumber && countOfElements == counter_mass[j] + 1) {
                        multiplication_mass[i] = mult2;
                        index_mass[i] = j;
                        counter_mass[i] = counter_mass[j] + 1;
                        stop = true;
                        break;
                    } else if (countOfElements != counter_mass[j] + 1) {
                        multiplication_mass[i] = mult2;
                        index_mass[i] = j;
                        counter_mass[i] = counter_mass[j] + 1;
                    }
                }
//                if ((mult <= multiplicationNumber && multiplicationNumber % mult == 0) ||
//                        (mult2 <= multiplicationNumber && multiplicationNumber % mult2 == 0)) {
//                    //counter_mass[i] change on counter_mass[j]
//                    if (2 == countOfElements && mult == multiplicationNumber) {
//                        multiplication_mass[i] = mult;
//                        index_mass[i] = j;
//                        counter_mass[i]++;
//                        stop = true;
//                        break;
//                    } else if (counter_mass[j] + 1 == countOfElements && mult2 == multiplicationNumber) {
//                        multiplication_mass[i] = mult2;
//                        index_mass[i] = j;
//                        counter_mass[i] = counter_mass[j] + 1;
//                        stop = true;
//                        break;
//                    } else if (counter_mass[j] + 1 < countOfElements && mult2 <= multiplicationNumber) {
//                        multiplication_mass[i] = mult2;
//                        index_mass[i] = j;
//                        counter_mass[i] = counter_mass[j] + 1;
//                    } else if (2 < countOfElements && mult <= multiplicationNumber && counter_mass[i] + 1 != countOfElements) {
//                        multiplication_mass[i] = mult;
//                        index_mass[i] = j;
//                        counter_mass[i]++;
//                    }
//
//                }
//
//            }
                if (stop) {
                    break;
                }
            }
        }
        System.out.println("MASS: " + Arrays.toString(mass));
        System.out.println("MULTIPLICATION: " + Arrays.toString(multiplication_mass));
        System.out.println("INDEX:          " + Arrays.toString(index_mass));
        System.out.println("COUNT: " + Arrays.toString(counter_mass));

        int find_index = find_index_of_searching_element(multiplication_mass, counter_mass);
        return getResultIdexes(find_index, index_mass);
    }

    private static int find_index_of_searching_element(double[] multiplication_mass, long[] counter_mass) {
        int find_index = -1;
        for (int i = 0; i < multiplication_mass.length; i++) {
            if (multiplication_mass[i] == multiplicationNumber && counter_mass[i] == countOfElements) {
                find_index = i;
                break;
            }
        }
        return find_index;
    }

    public static List<Integer> getResultIdexes(int find_index, int[] index_mass) {
        List<Integer> answer = new ArrayList<Integer>();
        while (countOfElements > 0) {
            answer.add(find_index + 1);
            find_index = index_mass[find_index];
            countOfElements--;
        }
//        System.out.println(answer);
        return answer;
    }
}