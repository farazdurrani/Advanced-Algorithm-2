package com.faraz.algorithm.graph.one;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {

    private Map<Node, ArrayList<Node>> linkedEdges;
    private boolean directed;

    public Graph(boolean directed) {
	this.directed = directed;
	linkedEdges = new LinkedHashMap<>();
    }

    public void addEdges(Node source, Node destination) {
	addEdgesHelper(source, destination);
	if (!directed) {
	    addEdgesHelper(destination, source);
	}
    }

    private void addEdgesHelper(Node source, Node destination) {
	if (linkedEdges.containsKey(source)) {
	    ArrayList<Node> nodes = linkedEdges.get(source);
	    nodes.add(destination);
	    linkedEdges.put(source, nodes);
	} else {
	    ArrayList<Node> nodes = new ArrayList<>();
	    nodes.add(destination);
	    linkedEdges.put(source, nodes);
	}
    }

    public void printEdges() {
	System.out.println("Nodes has the following edges:");
	this.linkedEdges.forEach((node, nodes) -> {
	    System.out.print(node.label + " -> ");
	    nodes.forEach(n -> System.out.print(n.label + " "));
	    System.out.println();
	});
    }

    public boolean hasEdge(Node a, Node b) {
	return linkedEdges.containsKey(a) && linkedEdges.get(a).contains(b);
    }

    public void depthFirstTraversal(Node a) {
	depthFirstTraversalHelper(a);
	System.out.println();
	linkedEdges.keySet().forEach(node -> {
	    if (!node.isVisited()) {
		depthFirstTraversalHelper(node);
	    }
	});

    }

    private void depthFirstTraversalHelper(Node a) {
	a.setVisited(true);
	System.out.print(a.label + " ");
	List<Node> neighbors = linkedEdges.get(a);
	if (neighbors == null) {
	    return;
	}

	for (Node neighbor : neighbors) {
	    if (!neighbor.isVisited()) {
		depthFirstTraversalHelper(neighbor);
	    }
	}
    }

    public void breadthFirstTraversal(Node node) {
	breadthFirstTraversalHelper(node);
	linkedEdges.keySet().forEach(n -> {
	    if (!n.isVisited()) {
		breadthFirstTraversalHelper(n);
	    }
	});
    }

    private void breadthFirstTraversalHelper(Node node) {
	Queue<Node> q = new ArrayDeque<>();
	if (node != null) {
	    q.add(node);
	}
	while (!q.isEmpty()) {
	    Node n = q.poll();
	    if (n.isVisited()) {
		continue;
	    }
	    n.setVisited(true);
	    System.out.print(n.label + " ");
	    List<Node> neighbors = linkedEdges.get(node);
	    if (null == neighbors) {
		continue;
	    }

	    for (Node neighbor : neighbors) {
		if (!neighbor.isVisited()) {
		    q.add(neighbor);
		}
	    }
	}
	System.out.println();
    }
}
