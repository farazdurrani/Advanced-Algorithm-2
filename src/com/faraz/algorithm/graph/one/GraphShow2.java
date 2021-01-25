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

	graph.addNodes(one, zero);
	graph.addNodes(three, one);
	graph.addNodes(two, seven);
	graph.addNodes(two, four);
	graph.addNodes(five, two);
	graph.addNodes(five, zero);
	graph.addNodes(six, five);
	graph.addNodes(six, three);
	graph.addNodes(six, eight);
	graph.addNodes(seven, five);
	graph.addNodes(seven, six);
	graph.addNodes(seven, eight);

	graph.depthFirstTraversal(seven);
    }
}
