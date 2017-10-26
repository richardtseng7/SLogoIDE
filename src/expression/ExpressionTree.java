package expression;
import expression.extendNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Peilin Lai
 * 			Paul Lee
 */



public class ExpressionTree {
	private ArrayList<String> zeroargComms = new ArrayList<String>(Arrays.asList(
			"PENDOWN", "PENUP", "SHOWTURTLE", "HIDETURTLE", "HOME", "CLEARSCREEN",
			"XCOR", "YCOR", "HEADING", "PENDOWN","SHOWING", "PI"
			));
	private ArrayList<String> oneargComms = new ArrayList<String>(Arrays.asList(
			"FORWARD", "BACK", "LEFT", "RIGHT", "SETHEADING",  "MINUS", "RANDOM",
			"SIN", "COS", "TAN", "ATAN", "LOG", "NOT"
			));
	private ArrayList<String> twoargComms = new ArrayList<String>(Arrays.asList(
			"TOWARDS", "SETXY",	"SUM", "DIFFERENCE", "PRODUCT", "QUOTIENT", "REMAINDER", "POW", 
			"LESS","GREATER","EQUAL","NOTEQUAL", "AND", "OR","MAKE","SET"
			));
	private ArrayList<String> threeplusComms = new ArrayList<String>(Arrays.asList(
			"REPEAT", "DOTIMES","FOR", "FOR", "IF", "IFELSE", "TO"
			));
	private extendNode current;
	private extendNode tree;
	private extendNode last;
	public ExpressionTree (ArrayList<String> input, ArrayList<String> symbol) {
		int len = Collections.frequency(symbol, "Command");
		int counter = 0;
		ArrayList<Integer> commIndexes = indexAll(symbol);
		ArrayList<extendNode> nodeList = new ArrayList<extendNode>();
		
		tree = new extendNode(input.get(0));
		
		for(int i = 0 ; i<commIndexes.size(); i++){
			
			extendNode newNode = new extendNode(input.get(commIndexes.get(i)));
			nodeList.add(newNode);
			
		}
		
		for(int i = 0; i<nodeList.size(); i++){
			int numArguments = numArgs(symbol.get(commIndexes.get(i)));
			if(numArguments == 1){
				nodeList.get(i).left = nodeList.get(i+1); 
			}
			else if(numArguments == 2){
				nodeList.get(i).left = nodeList.get(i+1);
				nodeList.get(i).right = nodeList.get(i+2);
			}
			else if(numArguments == 3){
				nodeList.get(i).left = nodeList
			}
		}
	}
	
	private int nextIndex(int ind, ArrayList<String> ar){
		if(ind == ar.size()) {return -1;}
		for(int i = ind+1; i<ar.size(); i++){
			if(ar.get(i) == "Command"){ return i;}
		}
		return -1;
	}
	
	private int numArgs(String s){
		if(zeroargComms.contains(s)) {return 0;}
		if(oneargComms.contains(s)) {return 1;}
		if(twoargComms.contains(s)) {return 2;}
		else{ return 3;}
	}
	
	private ArrayList<Integer> indexAll(ArrayList<String> symbol){
		ArrayList<Integer> returnlist = new ArrayList<Integer>();
		for(int i = 0; i<symbol.size(); i++){
			if(symbol.get(i) == "Command"){
				returnlist.add(i);
			}
		}
		return returnlist;
	}
	
	private boolean isOperator(String s) {
		if (s.equals("Command")) return true;
		else return false;
	}
}
