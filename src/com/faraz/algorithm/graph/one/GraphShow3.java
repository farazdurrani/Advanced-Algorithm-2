package com.faraz.algorithm.graph.one;

public class GraphShow3 {
    public static void main(String[] args) {
	Graph graph = new Graph(false);
        Node a = new Node("0");
        Node b = new Node("1");
        Node c = new Node("2");
        Node d = new Node("3");
        Node e = new Node("4");

        graph.addEdges(a,d);
        graph.addEdges(a,b);
        graph.addEdges(c,e);

        graph.breadthFirstTraversal(a);
    }
}
