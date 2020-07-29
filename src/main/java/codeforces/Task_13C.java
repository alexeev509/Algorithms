package codeforces;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Task_13C {

    private static int size;
    private static long[] sequence;

    public static void main(String[] args) {
        readInput(System.in);
        findAnswer();
    }

    public static void readInput(InputStream s) {
        Scanner in = new Scanner(s);
        size = in.nextInt();
        sequence = new long[size];
        for (int i = 0; i < size; i++) {
            sequence[i] = in.nextLong();
        }
    }

    public static long findAnswer() {
        long[] first_path = new long[size];
        long[] second_path = new long[size];

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

        long answer = getMaxSumm(first_path, second_path);
        System.out.println(answer);

        System.out.println(Arrays.toString(sequence));
        Arrays.sort(sequence);
        System.out.println(Arrays.toString(sequence));

        return answer;
    }

    public static long getMaxSumm(long[] first_path, long[] second_path) {
        long summ1 = 0;
        long summ2 = 0;

        for (int i = 0; i < size; i++) {
            summ1 += Math.abs(first_path[i]);
            summ2 += Math.abs(second_path[i]);
        }
        return Long.min(summ1, summ2);
    }
}


//а [3, 2, -1, 2, 11]
//b [-1, 2, 2, 3, 11]
//f[0]+=Math.abs(a[0]-b[0])=4;
//f[1]=Math.min(4,0+1)=1
//f[2]=Math.min(1,0+1)=1
//f[3]=Math.min(1,0+0)=0
//f[4]=Math.min(0,0+8)=0
//f [4 1 1 0 0]

//f[0]+=Math.abs(a[1]-b[0])=4+3=7
//f[1]=Math.min(7,1+0)=1
//f[2]=Math.min(1,1+0)=1
//f[3]=Math.min(1,0+1)=1
//f[4]=Math.min(1,0+9)=1

//f[0]+=Math.abs(a[2]-b[0])=7+0=7
//f[1]=Math.min(7,1+3)=4
//f[2]=Math.min(4,1+3)=4
//f[3]=Math.min(4,1+4)=4
//f[4]=Math.min(4,1+12)4

//f[0]+=Math.abs(a[3]-b[0])=7+3=10
//f[1]=Math.min(10,4+0)=4
//f[2]=Math.min(4,4+0)=4
//f[3]=Math.min(4,4+1)=4
//f[4]=Math.min(4,9)=4

//f[0]+=Math.abs(a[4]-b[0])=10+12=22
//f[1]=Math.min(22,4+12)=16
//f[2]=Math.min(16,4+9)=13
//f[3]=Math.min(13,4+9)=13
//f[4]=Math.min(13,4+0)=4