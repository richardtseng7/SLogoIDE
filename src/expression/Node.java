package expression;

import model.turtle.Turtle;

public abstract class Node {
	String value;
	Node left, right;
	
	public Node() {
		
	}
	
	public Node(String item) {
		value = item;
		left = right = null;
	}
	
	protected abstract double execute(Turtle t);
	protected int getNumParam() {
		return 0;
	}
}
