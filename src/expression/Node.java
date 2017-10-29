package expression;

import model.turtle.Turtle;

public class Node {
	String value;
	Node left, right;
	
	public Node() {
		
	}
	
	public Node(String item) {
		value = item;
		left = right = null;
	}
	
	protected double execute(Turtle t) {
		return 0;
	};
	
	protected int getNumParam() {
		return 0;
	}
}
