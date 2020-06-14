package practice.specific;

import java.io.IOException;
import java.util.*;

//count subtree having root node and child node character as given node.
public class CountSubTree {
    // Tree Node
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Query {
        int v;
        char c;

        Query(int v, char c) {
            this.v = v;
            this.c = c;
        }
    }
    class Query1 {
        int v;
        char c;

        Query1(int v, char c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Query1)) return false;
            Query1 query = (Query1) o;
            return v == query.v &&
                    c == query.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, c);
        }
    }

    // Add any helper functions you may need here
    int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        Map<Query1, Node> charNodeMap = new HashMap<>();
        fillMap(root, charNodeMap, s);
        int[] res = new int[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Query q = queries.get(i);
            Node node = charNodeMap.get(new Query1(q.v, s.charAt(q.v-1)));
            res[i] = count(node, q.c, s);
        }
        return res;
    }

    int count(Node root, char c, String s) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        if (s.charAt(root.val-1) == c)
            ans += 1;
        for (Node n : root.children) {
            ans += count(n, c, s);
        }
        return ans;
    }

    void fillMap(Node root, Map<Query1, Node> charNodeMap, String s) {
        if (root == null) {
            return;
        }
        charNodeMap.put(new Query1(root.val, s.charAt(root.val-1)), root);
        for (Node n : root.children) {
            fillMap(n, charNodeMap, s);
        }
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() throws IOException {
        Scanner sc = new Scanner(System.in);

        //Testcase 1
        int n_1 = 3, q_1 = 1;
        String s_1 = "aba";
        Node root_1 = new Node(1);
        root_1.children.add(new Node(2));
        root_1.children.add(new Node(3));
        ArrayList<Query> queries_1 = new ArrayList<>();
        queries_1.add(new Query(1, 'a'));
        int[] output_1 = countOfNodes(root_1, queries_1, s_1);
        int[] expected_1 = {2};
        check(expected_1, output_1);

        // Testcase 2
        int n_2 = 7, q_2 = 3;
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));
        int[] output_2 = countOfNodes(root_2, queries_2, s_2);
        int[] expected_2 = {4, 1, 2};
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) throws IOException {
        new CountSubTree().run();
    }
}

