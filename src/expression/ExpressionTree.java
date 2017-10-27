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
	private extendNode tree;
	public ExpressionTree (ArrayList<String> input, ArrayList<String> symbol, ArrayList<String> layers, ArrayList<Integer> bracketBounds) {
		ArrayList<Integer> commIndexes = indexAll(symbol);
		ArrayList<extendNode> extendNodeList = new ArrayList<extendNode>();
		
		tree = new extendNode(input.get(0), symbol.get(0));
		
		for(int i = 0 ; i<input.size(); i++){
			
			extendNode newextendNode = new extendNode(input.get(i), symbol.get(i));
			extendNodeList.add(newextendNode);
			
		}
		Factory comms;
		try{
			for(int i = 0; i<extendNodeList.size(); i++){
				
				comms = new Factory(extendNodeList.get(i).getItem());
				
				int numArguments =  comms.getParameter();
				if(numArguments == 3 || extendNodeList.get(i).getType() == "Conditional"){
					extendNodeList.get(i).left = extendNodeList.get(i+1);
					int outofbrackets = -1;
					for(int j = i+2; j < extendNodeList.size(); j++){
						if(layers.get(j) == layers.get(i)){
							outofbrackets = j;
							break;
						}
					}
					if(outofbrackets != -1) { extendNodeList.get(i).left = extendNodeList.get(outofbrackets);}
					
				}
				else if(numArguments == 1){
					extendNodeList.get(i).left = extendNodeList.get(i+1); 
				}
				else if(numArguments == 2){
					extendNodeList.get(i).left = extendNodeList.get(i+1);
					extendNodeList.get(i).right = extendNodeList.get(i+2);
				}
			}
		}
		catch(Exception ex){
			
		}
	}
	
	public extendNode getHeader(){
		return tree;
	}
	
	private ArrayList<Integer> indexAll(ArrayList<String> symbol){
		ArrayList<Integer> returnlist = new ArrayList<Integer>();
		for(int i = 0; i<symbol.size(); i++){
			if(symbol.get(i) == "Command" || symbol.get(i) == "Conditional"){
				returnlist.add(i);
			}
		}
		return returnlist;
	}
	
}
