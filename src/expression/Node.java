package expression;

import Commands.Command;
import model.turtle.Turtle;

public class Node extends Command {
	String value, type;
	Node left, right;
	
	public Node() {
		
	}
	
	public Node(String item, String symbol) {
		value = item;
		left = right = null;
		type = symbol;
	}
	
	private Turtle myT;
	private String mySymbol;
	private Executor c1, c2;
	
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

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
