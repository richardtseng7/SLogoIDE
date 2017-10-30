package expression;
import expression.Node;
import parsing.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Peilin Lai
 * 			Paul Lee
 */

public abstract class ExpressionTree {
	protected Node treeOfNodes;
	protected ArrayList<Node> NodeList;
	protected ExpressionTree (ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Boolean> bracketBounds) {
		//ArrayList<Integer> commIndexes = indexAll(symbol);
		NodeList = new ArrayList<Node>();
		
		//System.out.println(input.get(0));
		//System.out.println(symbol.get(0));
		treeOfNodes = new Node(input.get(0), symbol.get(0));
		
		for(int i = 0 ; i<input.size(); i++){
			Node newNode = new Node(input.get(i), symbol.get(i));
			NodeList.add(newNode);
		}
		//Factory comms;
		buildTree(input, symbol, layers, bracketBounds, NodeList);
	}

	private void buildTree(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<Node> NodeList) {
		//Factory comms;
		System.out.println(input.toString());
		System.out.println(symbol.toString());
		System.out.println(layers.toString());
		System.out.println(bracketBounds.toString());
		try{
			for(int i = 0; i<NodeList.size(); i++){
				checkALandBuild(input, symbol, layers, bracketBounds, NodeList, i);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private void checkALandBuild(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<Node> NodeList, int i) {
		Factory comms = new Factory(NodeList.get(i).getItem());
		int numArguments =  comms.getCommand().getNumParam();
		if(numArguments == 3 || NodeList.get(i).getType() == "Conditional"){
			System.out.println("3");
			ifConditional(input, symbol, layers, bracketBounds, NodeList, i);
		}
		else if(numArguments == 1){
			System.out.println("1");
			NodeList.get(i).left = NodeList.get(i+1); 
		}
		else if(numArguments == 2){
			System.out.println("2");
			NodeList.get(i).left = NodeList.get(i+1);
			NodeList.get(i).right = NodeList.get(i+2);
		}
		else{System.out.println("HERE");}
	}

	private void ifConditional(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<Node> NodeList, int i) {
		NodeList.get(i).left = NodeList.get(i+1);
		int outofbrackets = -1;
		outofbrackets = buildNodeList(layers, NodeList, i, outofbrackets);
		if(outofbrackets != -1) { NodeList.get(i).left = NodeList.get(outofbrackets);}
		
		if(NodeList.get(i).getItem() != "IfElse"){
			oneCond(input, symbol, layers, bracketBounds, NodeList, i, outofbrackets);
		}
		else{
			twoCond(input, symbol, layers, bracketBounds, NodeList, i, outofbrackets);
					
		}
	}

	private void twoCond(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<Node> NodeList, int i, int outofbrackets) {
		oneCond(input, symbol, layers, bracketBounds, NodeList, i, outofbrackets);
		NodeList.get(i).setCond2(new Executor(new ArrayList<String>(input.subList(i+1, outofbrackets)), 
				new ArrayList<String>(symbol.subList(i+1, outofbrackets)), 
				new ArrayList<Integer>(layers.subList(i+1, outofbrackets)), 
				new ArrayList<Boolean>(bracketBounds.subList(i+1, outofbrackets))));
	}

	private void oneCond(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Boolean> bracketBounds, ArrayList<Node> NodeList, int i, int outofbrackets) {
		NodeList.get(i).setCond1(new Executor(new ArrayList<String>(input.subList(i+1, outofbrackets)), 
				new ArrayList<String>(symbol.subList(i+1, outofbrackets)), 
				new ArrayList<Integer>(layers.subList(i+1, outofbrackets)), 
				new ArrayList<Boolean>(bracketBounds.subList(i+1, outofbrackets))));
	}

	private int buildNodeList(ArrayList<Integer> layers, ArrayList<Node> NodeList, int i,
			int outofbrackets) {
		for(int j = i+2; j < NodeList.size(); j++){
			if(layers.get(j) == layers.get(i)){
				outofbrackets = j;
				break;
			}
		}
		return outofbrackets;
	}
	
	/*
	public Node getHeader(){
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
