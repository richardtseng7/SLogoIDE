package expression;

import model.commands.Command;
import model.turtle.Turtle;

/**
 * @author Peilin Lai
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
	Executor c1, c2, expr;
	
	public String getItem(){
		return value;
	}
	
	public String getType(){
		return type;
	}
	public void setCond1(Executor e){
		System.out.println("Here: " + e.NodeList.get(0).value.toString());
		c1 = e;
	}
	
	public void setCond2(Executor e){
		c2 = e;
	}
	public void setCondExpr(Executor e){
		expr = e;
	}
	
	

	public double execute(Turtle t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
