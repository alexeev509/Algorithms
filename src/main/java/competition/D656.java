package competition;

import java.io.InputStream;
import java.util.Scanner;

public class D656 {
    static int countOfDatasets;
    public static int numberOfChar = 97;
    static int summ;

    public static void main(String[] args) {
        readInput(System.in);
    }

    private static void readInput(InputStream s) {
        Scanner in = new Scanner(s);
        countOfDatasets = in.nextInt();
        for (int i = 0; i < countOfDatasets; i++) {
            int size = in.nextInt();
            String str = in.next();
            numberOfChar = 97;
            summ = 0;
            int q = getAnswer(str.toCharArray(), 0, str.length(), (char) numberOfChar);
            System.out.println(q);

        }
    }


    public static int getAnswer(char[] massOfChars, int start, int end, char c) {
        if (start >= end) {
            return 0;
        }
        if (start == end - 1) {
            if (massOfChars[start] == c) {
                return 0;
            } else {
                return 1;
            }
        }
        int middle = (end + start) / 2;
        int counter_1 = 0;
        int counter_2 = 0;

        for (int i = start; i < middle; i++) {
            if (massOfChars[i] == c) {
                counter_1++;
            }
        }
        for (int i = middle; i < end; i++) {
            if (massOfChars[i] == c) {
                counter_2++;
            }
        }
        c++;
        return Math.min((middle - start) - counter_1 + getAnswer(massOfChars, middle, end, c)
                , (end - middle) - counter_2 + getAnswer(massOfChars, start, middle, c));
    }
}


//    public static int getAnswer(char[] massOfChars, int start, int end,char c) {
//        if(start<=end){
//            if(massOfChars[start]==c){
//                return 0;
//            }else {
//                return 1;
//            }
//        }
//        int middle = (end + start) / 2;
//        numberOfChar++;
//        int summ=0;
//        summ+=getAnswer(massOfChars, start, middle,(char)numberOfChar);
//        return summ;
//    }

//    public static void getAnswer(char[] massOfChars, int start, int end, char c) {
//        if(start>=end){
//            return;
//        }
//        int middle = (end + start) / 2;
//        int counter_1 = 0;
//        int counter_2 = 0;
//
//        for (int i = start; i < middle; i++) {
//            if (massOfChars[i] == c) {
//                counter_1++;
//            }
//        }
//        for (int i = middle; i < end; i++) {
//            if (massOfChars[i] == c) {
//                counter_2++;
//            }
//        }
//        numberOfChar++;
//        if (counter_1 > counter_2) {
//            summ += (middle-start)-counter_1;
//            getAnswer(massOfChars,middle,end,(char)numberOfChar);
//        }else if(counter_1 <= counter_2) {
//            summ+=(end-middle)-counter_2;
//            getAnswer(massOfChars,start,middle,(char)numberOfChar);
//        }
//        else {
//            summ += (middle-start)-counter_1;
//
//        }
//    }


//    public static int getAnswer(char[] massOfChars, int start, int end, char c) {
//        if (start >= end) {
//            return 0;
//        }
//        if (start == end - 1) {
//            if (massOfChars[start] == c) {
//                return 0;
//            } else {
//                return 1;
//            }
//        }
//        int middle = (end + start) / 2;
//        numberOfChar++;
//        summ += Math.min(getAnswer(massOfChars, middle, end, (char) numberOfChar), getAnswer(massOfChars, middle, end, (char) numberOfChar));
//        return summ;
//    }


//            if (str.length() == 1 && "a".equals(str)) {
//                System.out.println(0);
//            } else if (str.length() == 1) {
//                System.out.println(1);
//            } else {