package expression;

public class Operator extends Node{
	String value;
	Node left, right;
	int numofpm;
	
	public Operator(String item) {
		super(item);
	}

}
