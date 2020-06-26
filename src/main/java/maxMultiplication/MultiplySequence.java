package maxMultiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

//IN PROCESS !! 
public class MultiplySequence {

    static int massLen;
    static int multiplicationNumber;
    static int countOfElements;
    static int [] mass;

    public static void main(String[] args) throws IOException {
        readInput(System.in);
        searchMultiplication();
    }


    public static void readInput(InputStream s) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(s));
        massLen = Integer.parseInt(in.readLine());
        multiplicationNumber = Integer.parseInt(in.readLine());
        countOfElements = Integer.parseInt(in.readLine());

        mass=new int[massLen];

        for (int i = 0; i < massLen; i++) {
            mass[i]=Integer.parseInt(in.readLine());
        }
    }

    public static void searchMultiplication() {
        LinkedList<Structure> linkedList=new LinkedList<Structure>();
        for (int i = 0; i < mass.length; i++) {
            linkedList.add(new Structure(i,mass[i],1));
        }

        for (int i = 0; i < linkedList.size(); i++) {
//            Structure value = linkedList.pop();

        }
    }

    private static class Structure{
        int index;
        int multValue;
        int counter;

        public Structure(int index, int multValue, int counter) {
            this.index = index;
            this.multValue = multValue;
            this.counter = counter;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getMultValue() {
            return multValue;
        }

        public void setMultValue(int multValue) {
            this.multValue = multValue;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }


}
