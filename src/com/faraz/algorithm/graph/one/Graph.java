package com.faraz.algorithm.graph.one;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class Graph {

    private Map<Node, ArrayList<Node>> linkedNodes;
    private boolean directed;

    public Graph(boolean directed) {
	this.directed = directed;
	linkedNodes = new LinkedHashMap<>();
    }

    public void addNodes(Node source, Node destination) {
	addNodesHelper(source, destination);
	if (!directed) {
	    addNodesHelper(destination, source);
	}
    }

    private void addNodesHelper(Node source, Node destination) {
	if (linkedNodes.containsKey(source)) {
	    ArrayList<Node> nodes = linkedNodes.get(source);
	    nodes.add(destination);
	    linkedNodes.put(source, nodes);
	} else {
	    ArrayList<Node> nodes = new ArrayList<>();
	    nodes.add(destination);
	    linkedNodes.put(source, nodes);
	}
    }

    public void printNodes() {
	System.out.println("Nodes has the following edges:");
	this.linkedNodes.forEach((node, nodes) -> {
	    System.out.print(node.label + " -> ");
	    nodes.forEach(n -> System.out.print(n.label + " "));
	    System.out.println();
	});
    }

    public boolean hasEdge(Node a, Node b) {
	return linkedNodes.containsKey(a) && linkedNodes.get(a).contains(b);
    }

    public void depthFirstTraversal(Node a) {
	depthFirstTraversalHelper(a);
	System.out.println();
	linkedNodes.keySet().forEach(node -> {
	    if (!node.isVisited()) {
		depthFirstTraversalHelper(node);
	    }
	});

    }

    private void depthFirstTraversalHelper(Node a) {
	a.setVisited(true);
	System.out.print(a.label + " ");
	List<Node> neighbors = linkedNodes.get(a);
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
	linkedNodes.keySet().forEach(n -> {
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
	    List<Node> neighbors = linkedNodes.get(node);
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
