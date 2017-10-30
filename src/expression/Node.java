package expression;

import model.commands.Command;
import model.turtle.Turtle;

/**
 * @author Paul Lee
 */


public class Node extends Command {
	String value, type;
	Node left, right, prev;
	
	public Node() {
		
	}
	
	public Node(String item, String symbol) {
		value = item;
		left = right = prev = null;
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
	public double execute(Turtle t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
