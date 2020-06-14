package practice.specific;

import java.util.*;

public class Ub1 {


    public static void main(String args[]) throws Exception {
        System.out.println("Hello World");

        Ub1 s = new Ub1();
        int[] arr = new int[]{1, 1, 2, 3, 3, 4, 4, 4, 5,5};
        int ele = 4;

    }

    private boolean oneCharDiff(String a, String b) {
        return true;
    }

    class Graph {
        int v;
        Map<String, Set<String>> adj = new HashMap<>();

        Graph(int nodes) {
            v = nodes;
        }

        void addEdge(String u, String v) {
            if (!adj.containsKey(u)) {
                adj.put(u, new HashSet<>());
            }
            if (!adj.containsKey(v)) {
                adj.put(v, new HashSet<>());
            }
            adj.get(u).add(v); //undireted graph
            adj.get(v).add(u);
        }
    }

    // Given a dictionarry of words(of same length), start_word and end_word, find the number of minimum steps
// abc -> abd (Valid Move)
// abc -> add (Invalid move)
    int pathLength(String source, String dest, List<String> words) {
        Graph g = new Graph(words.size());
        //initialize too
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (oneCharDiff(words.get(i), words.get(j))) {
                    g.addEdge(words.get(i), words.get(j));
                }
            }
        }

        int len = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(source);
        queue.add(null);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word == null) {
                if (queue.size() > 0) {
                    queue.add(null);
                    len++;
                    continue;
                }
                return -1;
            }
            if (word.equals(dest)) {
                return len;
            }
            visited.add(word);
            for (String neighbour : g.adj.getOrDefault(word, new HashSet<>())) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }

        return -1;
    }
}
































