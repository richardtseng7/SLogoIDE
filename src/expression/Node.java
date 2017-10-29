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
	protected int getNumParam() {
		return 0;
	}
	
	private Turtle myT;
	private String mySymbol;
	private Executor c1, c2;
	
	public double execute(Turtle t){
		return 0;
	}
	
	public void setTurtle(Turtle t){
		myT = t;
	}
	
	
	
	public String getItem(){
		return value;
	}
	
	public String getType(){
		return mySymbol;
	}
	public void setCond1(Executor e){
		c1 = e;
	}
	
	public void setCond2(Executor e){
		c2 = e;
	}
	
}
