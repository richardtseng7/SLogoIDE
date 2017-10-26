package expression;
import expression.extendNode;
import parsing.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Peilin Lai
 * 			Paul Lee
 */



public class ExpressionTree {
	private extendNode current;
	private extendNode tree;
	private extendNode last;
	public ExpressionTree (ArrayList<String> input, ArrayList<String> symbol) {
		int len = Collections.frequency(symbol, "Command");
		int counter = 0;
		ArrayList<Integer> commIndexes = indexAll(symbol);
		ArrayList<extendNode> extendNodeList = new ArrayList<extendNode>();
		
		tree = new extendNode(input.get(0));
		
		for(int i = 0 ; i<commIndexes.size(); i++){
			
			extendNode newextendNode = new extendNode(input.get(commIndexes.get(i)));
			extendNodeList.add(newextendNode);
			
		}
		
		Factory comms;
		
		for(int i = 0; i<extendNodeList.size(); i++){
			
			comms = new Factory(extendNodeList.get(i).getItem());
			
			int numArguments =  comms.getParameter();
			if(numArguments == 1){
				extendNodeList.get(i).left = extendNodeList.get(i+1); 
			}
			else if(numArguments == 2){
				extendNodeList.get(i).left = extendNodeList.get(i+1);
				extendNodeList.get(i).right = extendNodeList.get(i+2);
			}
			else if(numArguments == 3){
				//extendNodeList.get(i).left = extendNodeList
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
