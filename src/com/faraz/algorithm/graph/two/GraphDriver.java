package com.faraz.algorithm.graph.two;

public class GraphDriver {
    public static void main(String[] args) {
	Graph graph = new Graph(true);
	Node zero = new Node("0");
	Node one = new Node("1");
	Node two = new Node("2");
	Node three = new Node("3");
	Node four = new Node("4");
	Node five = new Node("5");
	Node six = new Node("6");
	Node seven = new Node("7");
	Node eight = new Node("8");

	graph.addEdges(one, zero);
	graph.addEdges(three, one);
	graph.addEdges(two, seven);
	graph.addEdges(two, four);
	graph.addEdges(five, two);
	graph.addEdges(five, zero);
	graph.addEdges(six, five);
	graph.addEdges(six, three);
	graph.addEdges(six, eight);
	graph.addEdges(seven, five);
	graph.addEdges(seven, six);
	graph.addEdges(seven, eight);

	graph.depthFirstTraversal(seven);
	
	graph = new Graph(false);
	
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
