package expression;
import parsing.Factory;
import java.util.ArrayList;

import model.Model;
import model.turtle.Turtle;

public class Executor extends ExpressionTree {
	public Executor(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Integer> bracketBounds, Turtle t, Model mod){
		super(input, symbol, layers, bracketBounds, t, mod);
	}
	
	public String executeStarter(){
		//for(int i = 0; i < NodeList.size(); i++){ System.out.println(NodeList.get(i).value);}
		//System.out.println(NodeList.get(0).left.value);
		return executeFromTreeNode(NodeList.get(0));
	}
	
	private String executeFromTreeNode(Node current){
		//System.out.println(current.type.toString());
		if(current.type.equals("Constant")){return current.value;}
		
		else if(current.type.equals("Variable")) { 
		    return myTurtle.getVariablesMap().getVariables(current.value).toString();
		}
		
		Factory fact = new Factory(current.value);
		int numargs = fact.numComs();
		Object[] args = new Object[1+Math.abs(numargs)];
		args[0] = myTurtle;
		
		sorter(current, numargs, args);		
		//System.out.println(args[1]);
		Object temp = fact.setArgs(args);
		return temp.toString();
	}

	private void sorter(Node current, int numargs, Object[] args) {
		if(current.type.equals("Conditional")){ 
			if(current.value.equals("Repeat")){
				int expr = Integer.parseInt(current.expr.executeStarter());
				args[1] = expr;
				args[2] = current.c1;
			}
			else if(current.value.equals("DoTimes")){
				String varVal = current.c1.executeStarter();
				args[1] = varVal;
				args[2] = current.c2;
			}
			else if(current.value.equals("For")){
				args[1] = current.c1.NodeList.get(0).value.toString();
				args[2] = Integer.parseInt(current.c1.NodeList.get(1).value);
				args[3] = Integer.parseInt(current.c1.NodeList.get(2).value);
				args[4] = current.c1.NodeList.get(3).value.toString();
				args[5] = current.c2;
			}
			else if(current.value.equals("If")){
				boolean expr = Boolean.parseBoolean(current.expr.executeStarter());
				args[1] = expr;
				args[2] = current.c1;
			}
			else if(current.value.equals("IfElse")){
				boolean expr = Boolean.parseBoolean(current.expr.executeStarter());
				args[1] = expr;
				args[2] = current.c1;
				args[3] = current.c2;
			}
			else if(current.value.equals("To")){
				
			}
			else if(current.value.equals("MakeVariable")){
				String var = NodeList.get(1+NodeList.indexOf(current)).value;
				Double d2 = Double.parseDouble(current.c2.executeStarter());
				args[1] = var;
				args[2] = d2;
			}
		}
		else if(current.value.equals("SetPalette")){
			for(int i = 1; i<5; i++){ args[i] = Double.parseDouble(NodeList.get(i).value);}
		}
		else if(numargs == 1){ 
			Double d = Double.parseDouble(executeFromTreeNode(current.left));
			args[1] = d;
		}
		else if(numargs == 2){
			Double d1 = Double.parseDouble(executeFromTreeNode(current.left));
			Double d2 = Double.parseDouble(executeFromTreeNode(current.right));
			
			args[1] = d1;
			args[2] = d2;
		}
	}
	
	private void branchOut(Node current){
		if(current.right != null) { executeFromTreeNode(current.right);}
		if(current.left != null) { executeFromTreeNode(current.left);}
	}
}
