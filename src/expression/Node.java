package expression;

public class Node {
	String value;
	Node left, right;
	
	public Node(String item) {
		value = item;
		left = right = null;
	}
}
