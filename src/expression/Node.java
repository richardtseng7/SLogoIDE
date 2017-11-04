package expression;

import model.commands.Command;

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
	
	Executor c1, c2, expr;
	
	public String getItem(){
		return value;
	}
	
	public String getType(){
		return type;
	}
	public void setCond1(Executor e){
		c1 = e;
	}
	
	public void setCond2(Executor e){
		c2 = e;
	}
	
	public void setCondExpr(Executor e){
		expr = e;
	}
}