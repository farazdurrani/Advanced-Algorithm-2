package com.faraz.algorithm.graph.one;

public class Node {
    String label;
    boolean visited;

    public Node(String label) {
	this.label = label;
    }

    public boolean isVisited() {
	return visited;
    }

    public void setVisited(boolean visited) {
	this.visited = visited;
    }

    @Override
    public String toString() {
	return label;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((label == null) ? 0 : label.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Node other = (Node) obj;
	if (label == null) {
	    if (other.label != null)
		return false;
	} else if (!label.equals(other.label))
	    return false;
	return true;
    }

}