package expression;
import parsing.Factory;
import java.util.ArrayList;

public class Executor extends ExpressionTree {
	public Executor(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Boolean> bracketBounds){
		super(input, symbol, layers, bracketBounds);
	}
	
	public void executeStarter(){
		Factory fact = new Factory(treeOfNodes.value);
		fact.doExecution();
		branchOut(treeOfNodes);
	}
	
	private void executeFromTreeNode(extendNode current){
		Factory fact = new Factory(current.value);
		fact.doExecution();
		branchOut(current);
		
	}
	
	private void branchOut(extendNode current){
		if(current.right != null) { executeFromTreeNode(current.right);}
		if(current.left != null) { executeFromTreeNode(current.left);}
	}
}
