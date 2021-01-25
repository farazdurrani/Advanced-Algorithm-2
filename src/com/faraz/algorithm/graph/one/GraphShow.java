package com.faraz.algorithm.graph.one;

import com.faraz.algorithm.graph.one.Node;

public class GraphShow {
    public static void main(String[] args) {

	Graph graph = new Graph(true);
	Node a = new Node("A");
	Node b = new Node("B");
	Node c = new Node("C");
	Node d = new Node("D");
	Node e = new Node("E");

	graph.addNodes(a, b);
	graph.addNodes(b, c);
	graph.addNodes(b, d);
	graph.addNodes(c, e);
	graph.addNodes(b, a);

	graph.printNodes();

	System.out.println(graph.hasEdge(a, b));
	System.out.println(graph.hasEdge(d, a));
	
    }
}
