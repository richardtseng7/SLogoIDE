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

public abstract class ExpressionTree {
	protected extendNode treeOfNodes;
	protected ExpressionTree (ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Boolean> bracketBounds) {
		ArrayList<Integer> commIndexes = indexAll(symbol);
		ArrayList<extendNode> extendNodeList = new ArrayList<extendNode>();
		
		treeOfNodes = new extendNode(input.get(0), symbol.get(0));
		
		for(int i = 0 ; i<input.size(); i++){
			
			extendNode newextendNode = new extendNode(input.get(i), symbol.get(i));
			extendNodeList.add(newextendNode);
			
		}
		Factory comms;
		buildTree(input, symbol, layers, bracketBounds, extendNodeList);
	}

	private void buildTree(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<extendNode> extendNodeList) {
		Factory comms;
		try{
			for(int i = 0; i<extendNodeList.size(); i++){
				checkALandBuild(input, symbol, layers, bracketBounds, extendNodeList, i);
			}
		}
		catch(Exception ex){
			//instantiate GUI popup
		}
	}

	private void checkALandBuild(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<extendNode> extendNodeList, int i) {
		Factory comms;
		comms = new Factory(extendNodeList.get(i).getItem());
		int numArguments =  comms.getParameter();
		if(numArguments == 3 || extendNodeList.get(i).getType() == "Conditional"){
			ifConditional(input, symbol, layers, bracketBounds, extendNodeList, i);
			extendNodeList.get(i).setConditional(input.get(i));
		}
		else if(numArguments == 1){
			extendNodeList.get(i).left = extendNodeList.get(i+1); 
		}
		else if(numArguments == 2){
			extendNodeList.get(i).left = extendNodeList.get(i+1);
			extendNodeList.get(i).right = extendNodeList.get(i+2);
		}
	}

	private void ifConditional(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<extendNode> extendNodeList, int i) {
		extendNodeList.get(i).left = extendNodeList.get(i+1);
		int outofbrackets = -1;
		outofbrackets = buildNodeList(layers, extendNodeList, i, outofbrackets);
		if(outofbrackets != -1) { extendNodeList.get(i).left = extendNodeList.get(outofbrackets);}
		
		if(extendNodeList.get(i).getItem() != "IfElse"){
			oneCond(input, symbol, layers, bracketBounds, extendNodeList, i, outofbrackets);
		}
		else{
			twoCond(input, symbol, layers, bracketBounds, extendNodeList, i, outofbrackets);
					
		}
	}

	private void twoCond(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<extendNode> extendNodeList, int i, int outofbrackets) {
		oneCond(input, symbol, layers, bracketBounds, extendNodeList, i, outofbrackets);
		extendNodeList.get(i).setCond2(new Executor(new ArrayList<String>(input.subList(i+1, outofbrackets)), 
				new ArrayList<String>(symbol.subList(i+1, outofbrackets)), 
				new ArrayList<Integer>(layers.subList(i+1, outofbrackets)), 
				new ArrayList<Boolean>(bracketBounds.subList(i+1, outofbrackets))));
	}

	private void oneCond(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<extendNode> extendNodeList, int i, int outofbrackets) {
		extendNodeList.get(i).setCond1(new Executor(new ArrayList<String>(input.subList(i+1, outofbrackets)), 
				new ArrayList<String>(symbol.subList(i+1, outofbrackets)), 
				new ArrayList<Integer>(layers.subList(i+1, outofbrackets)), 
				new ArrayList<Boolean>(bracketBounds.subList(i+1, outofbrackets))));
	}

	private int buildNodeList(ArrayList<Integer> layers, ArrayList<extendNode> extendNodeList, int i,
			int outofbrackets) {
		for(int j = i+2; j < extendNodeList.size(); j++){
			if(layers.get(j) == layers.get(i)){
				outofbrackets = j;
				break;
			}
		}
		return outofbrackets;
	}
	
	/*
	public extendNode getHeader(){
		return tree;
	}
	*/
	
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
