package expression;
import expression.Node;
import gui.popups.ErrorPopUp;
import model.turtle.Turtle;
import parsing.Factory;

import java.lang.reflect.Method;
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
	protected Turtle myTurtle;
	protected ExpressionTree (ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Integer> bracketBounds,Turtle t) {
		//ArrayList<Integer> commIndexes = indexAll(symbol);
		NodeList = new ArrayList<Node>();
		myTurtle = t;
		
		System.out.println(input.toString());
		System.out.println(symbol.toString());
		System.out.println(layers.toString());
		System.out.println(bracketBounds.toString());

		treeOfNodes = new Node(input.get(0), symbol.get(0));
		
		for(int i = 0 ; i<input.size(); i++){

			Node newNode = new Node(input.get(i), symbol.get(i));
			NodeList.add(newNode);
		}
		//Factory comms;
		buildTree(input, symbol, layers, bracketBounds, NodeList);
	}

	private void buildTree(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Integer> bracketBounds, ArrayList<Node> NodeList) {
		//Factory comms;
		try{
			for(int i = 0; i<NodeList.size(); i++){
				checkALandBuild(input, symbol, layers, bracketBounds, NodeList, i);
			}
		}
		catch(Exception ex){
			ErrorPopUp error = new ErrorPopUp("Syntax Error: " + ex.toString());
		}
	}

	private void checkALandBuild(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Integer> bracketBounds, ArrayList<Node> NodeList, int i) {
		int numArguments =0;
		if(symbol.get(i).equals("Command")){
			Factory comms = new Factory(NodeList.get(i).getItem());
			numArguments =  comms.numComs();
		}
		
		System.out.println(NodeList.get(i).getType());
		if(numArguments == 3 || NodeList.get(i).getType() == "Conditional"){
			//System.out.println("3");
			ifConditional(input, symbol, layers, bracketBounds, NodeList, i);
		}
		else if(numArguments == 1){
			//System.out.println(NodeList.get(i).value);
			//System.out.println(NodeList.get(i+1).value);
			
			NodeList.get(i).left = NodeList.get(i+1);
			NodeList.get(i+1).prev = NodeList.get(i);
		}
		else if(numArguments == 2){
			//System.out.println("2");
			NodeList.get(i).left = NodeList.get(i+1);
			NodeList.get(i+1).prev = NodeList.get(i);
			NodeList.get(i).right = NodeList.get(i+2);
			NodeList.get(i+2).prev = NodeList.get(i);
		}
		else{
			//System.out.println("HERE");
		}
	}

	private void ifConditional(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Integer> bracketBounds, ArrayList<Node> NodeList, int i) {
		
		ArrayList<Integer> outofbrackets = buildNodeList(bracketBounds, NodeList, i, pairsOfBrackets(input.get(i)));
		boolean numberExpr = numExpr(input.get(i));
		int firstB = firstBracket(bracketBounds, NodeList, i);
		
		System.out.println("Here " + outofbrackets.toString());
		if(input.get(i).equals("If") || input.get(i).equals("Repeat")) { 
			exprCond(input, symbol, layers, bracketBounds, NodeList, i, firstB);
			oneCond(input, symbol, layers, bracketBounds, NodeList, i, outofbrackets, firstB);
			
		}
		else if(input.get(i).equals("IfElse") || input.get(i).equals("To")) {
			exprCond(input, symbol, layers, bracketBounds, NodeList, i, firstB);
			oneCond(input, symbol, layers, bracketBounds, NodeList, i, outofbrackets, firstB);
			twoCond(input, symbol, layers, bracketBounds, NodeList, i, outofbrackets);
		}
		else{
			oneCond(input, symbol, layers, bracketBounds, NodeList, i, outofbrackets, firstB);
			twoCond(input, symbol, layers, bracketBounds, NodeList, i, outofbrackets);
		}
		NodeList.get(i).left = NodeList.get(Collections.max(outofbrackets) + 1);
	}

	private void twoCond(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Integer> bracketBounds, ArrayList<Node> NodeList, int i, ArrayList<Integer> outofbrackets) {
		System.out.println("here");
		NodeList.get(i).setCond2(new Executor(new ArrayList<String>(input.subList(outofbrackets.get(0)+1, 1+outofbrackets.get(1))), 
				new ArrayList<String>(symbol.subList(outofbrackets.get(0)+1, 1+outofbrackets.get(1))), 
				new ArrayList<Integer>(layers.subList(outofbrackets.get(0)+1, 1+outofbrackets.get(1))), 
				new ArrayList<Integer>(bracketBounds.subList(outofbrackets.get(0)+1, 1+outofbrackets.get(1))), myTurtle));
	}

	private void oneCond(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Integer> bracketBounds, ArrayList<Node> NodeList, int i, ArrayList<Integer> outofbrackets,
			int firstB) {
		NodeList.get(i).setCond1(new Executor(new ArrayList<String>(input.subList(firstB+1, 1+outofbrackets.get(0))), 
				new ArrayList<String>(symbol.subList(firstB+1, 1+outofbrackets.get(0))), 
				new ArrayList<Integer>(layers.subList(firstB+1, 1+outofbrackets.get(0))), 
				new ArrayList<Integer>(bracketBounds.subList(firstB+1, 1+outofbrackets.get(0))), myTurtle));
	}

	private void exprCond(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers,
			ArrayList<Integer> bracketBounds, ArrayList<Node> NodeList, int i, int firstB) {
		NodeList.get(i).setCondExpr(new Executor(new ArrayList<String>(input.subList(i+1, firstB+1)), 
			new ArrayList<String>(symbol.subList(i+1, firstB+1)), 
			new ArrayList<Integer>(layers.subList(i+1, firstB+1)), 
			new ArrayList<Integer>(bracketBounds.subList(i+1, firstB+1)), myTurtle));
	}
	
	private int firstBracket(ArrayList<Integer> bracketBounds, ArrayList<Node> NodeList, int i){
		for(int j = i; j < NodeList.size(); j++){
			if(bracketBounds.get(j) == 1){
				return j;
			}
		}
		return -1;
	}
	
	private int pairsOfBrackets(String comm){
		if(comm.equals("Repeat") || comm.equals("If")) { return 1;}
		else {return 2;}
	}
	
	private boolean numExpr(String comm){
		if(comm.equals("DoTimes") || comm.equals("For")){ return false;}
		else {return true;}
	}

	private ArrayList<Integer> buildNodeList(ArrayList<Integer> bracketBounds, ArrayList<Node> NodeList, int i, int numbrackets) {
		int outofbrackets1 = -1;
		int outofbrackets2 = -1;
		int BracketPairs = 0;
		for(int j = i; j < NodeList.size(); j++){
			if(bracketBounds.get(j) == -1){
				if(BracketPairs==0){ 	outofbrackets1 = j; }
				else if (BracketPairs == 1) { outofbrackets2 = j;}
				BracketPairs++;
				if(outofbrackets1 != -1) {	break;}
			}
			else if(bracketBounds.get(j) == 2){
				outofbrackets1 = j;
				BracketPairs++;
			}
		}
		ArrayList<Integer> returnarr  = new ArrayList<Integer>();
		returnarr.add(outofbrackets1);
		returnarr.add(outofbrackets2);
		return returnarr;
	}
}
