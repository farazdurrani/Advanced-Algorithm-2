package com.faraz.algorithm.graph.one;

public class GraphShow2 {
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
    }
}
