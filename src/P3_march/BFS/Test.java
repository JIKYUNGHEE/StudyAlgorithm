package P3_march.BFS;

import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {

    }
}

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
            this.marked = false;
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];
        for(int i=0; i<size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
//            Node r =
        }
    }
}
