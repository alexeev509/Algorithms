package competition;

import javafx.util.Pair;

import java.io.InputStream;
import java.util.*;

public class E656 {
    static int countOfDatasets;
    private static int m;
    private static int n;
    private static boolean[] used;
    private static LinkedList<Integer> answer;

    public static void main(String[] args) {
        readInput(System.in);
    }

    private static void readInput(InputStream s) {
        Scanner in = new Scanner(s);
        countOfDatasets = in.nextInt();
        for (int i = 0; i < countOfDatasets; i++) {
            n = in.nextInt();
            m = in.nextInt();
//            int[][] mass = new int[n + 1][n + 1];
            Map<Integer, List<Pair<Integer, Integer>>> mapOfVertexes = new HashMap<>();

            //Initialization process
            for (int t = 1; t < n + 1; t++) {
                ArrayList<Pair<Integer, Integer>> listOfPairs = new ArrayList<>();
                mapOfVertexes.put(t, listOfPairs);
            }
            //
            for (int j = 0; j < m; j++) {
                int weHaveOrNot = in.nextInt();
                int start = in.nextInt();
                int end = in.nextInt();
                if (weHaveOrNot == 1) {
                    mapOfVertexes.get(start).add(new Pair<>(1, end));
                } else {
                    mapOfVertexes.get(start).add(new Pair<>(-1, end));
                }
            }
            printMap(mapOfVertexes, i);
            topological_sort(mapOfVertexes, n);
            System.out.println("Answer: " + answer);
        }
    }

    private static void topological_sort(Map<Integer, List<Pair<Integer, Integer>>> mapOfVertexes, int n) {
        used = new boolean[n + 1];
        answer = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (!used[i]) {
                dfs(i, mapOfVertexes);
            }
        }
    }

    private static void dfs(int i, Map<Integer, List<Pair<Integer, Integer>>> mapOfVertexes) {
        used[i] = true;
        for (int size = 0; size < mapOfVertexes.get(i).size(); size++) {
            System.out.println();
            int to = mapOfVertexes.get(i).get(size).getValue();
            if (!used[to]) {
                dfs(to, mapOfVertexes);
            }
        }
        answer.push(i);
    }

    private static void printMap(Map<Integer, List<Pair<Integer, Integer>>> mapOfVertexes, int i) {
        System.out.println("№ " + i);
        for (Map.Entry<Integer, List<Pair<Integer, Integer>>> v : mapOfVertexes.entrySet()) {
            System.out.println(v.getKey() + " " + v.getValue());
        }
    }
}
