package expression;
import parsing.Factory;
import java.util.ArrayList;

import model.turtle.Turtle;

public class Executor extends ExpressionTree {
	public Executor(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Integer> bracketBounds, Turtle t){
		super(input, symbol, layers, bracketBounds, t);
	}
	
	public void executeStarter(){
		//for(int i = 0; i < NodeList.size(); i++){ System.out.println(NodeList.get(i).value);}
		//System.out.println(NodeList.get(0).left.value);
		executeFromTreeNode(NodeList.get(0));
	}
	
	private String executeFromTreeNode(Node current){
		//System.out.println(current.type.toString());
		
		if(current.type.equals("Constant")){return current.value.toString();}
		
		Factory fact = new Factory(current.value);
		int numargs = fact.numComs();
		//System.out.println(numargs);
		Object[] args = new Object[1+Math.abs(numargs)];
		args[0] = myTurtle;
		
		if(numargs == 1){ 
			Double d = Double.parseDouble(executeFromTreeNode(current.left));
			args[1] = d;
		}
		if(numargs == 2){
			Double d1 = Double.parseDouble(executeFromTreeNode(current.left));
			Double d2 = Double.parseDouble(executeFromTreeNode(current.right));
			
			args[1] = d1;
			args[2] = d2;
		}		
		System.out.println(args[1]);
		Object temp = fact.setArgs(args);
		return temp.toString();
	}
	
	private void branchOut(Node current){
		if(current.right != null) { executeFromTreeNode(current.right);}
		if(current.left != null) { executeFromTreeNode(current.left);}
	}
}
