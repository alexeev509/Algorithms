package maxSummSunsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//I used this lesson for this algorithm
//https://www.youtube.com/watch?v=99ssGWhLPUE
public class MaxSequence {
    static int[] mass;


    public static void main(String[] args) throws IOException {
        readInput(System.in);
        findMaxSubSequence();
    }

    public static void readInput(InputStream in) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(in));
        mass = new int[Integer.parseInt(input.readLine())];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = Integer.parseInt(input.readLine());
        }

    }

    public static List<Integer> findMaxSubSequence() {
        int[] summMass = new int[mass.length];
        int[] index = new int[mass.length];

        System.arraycopy(mass, 0, summMass, 0, mass.length);

        for (int i = 0; i < mass.length; i++) {
            index[i] = i;
        }


        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < i; j++) {
                if (mass[j] < mass[i]) {
                    if (summMass[i] < summMass[j] + mass[i]) {
                        summMass[i] = summMass[j] + mass[i];
                        index[i] = j;
                    }
                }
            }
        }


        int maxIndex = getMaxSummIndex(summMass);


        return getResult(maxIndex, index);
    }

    private static int getMaxSummIndex(int[] summMass) {
        int maxIndex = -1;
        int maxSumm = summMass[0];
        for (int i = 1; i < mass.length; i++) {
            if (summMass[i] > maxSumm) {
                maxSumm = summMass[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static List<Integer> getResult(int maxIndex, int[] index) {
        List<Integer> answer = new ArrayList<Integer>();
        answer.add(mass[maxIndex]);
        while (maxIndex > 0) {
            maxIndex = index[maxIndex];
            answer.add(mass[maxIndex]);
        }
        return answer;
    }
}
