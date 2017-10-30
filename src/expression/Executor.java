package expression;
import parsing.Factory;
import java.util.ArrayList;

public class Executor extends ExpressionTree {
	public Executor(ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Boolean> bracketBounds){
		super(input, symbol, layers, bracketBounds);
	}
	
	public void executeStarter(){
		//for(int i = 0; i < NodeList.size(); i++){ System.out.println(NodeList.get(i).value);}
		//System.out.println(NodeList.get(0).left.value);
		Factory fact = new Factory(NodeList.get(0).value);
		Object[] args = {10.0};
		fact.setArgs(args);
		branchOut(NodeList.get(0));
	}
	
	private void executeFromTreeNode(Node current){
		//System.out.println(current.value);
		Factory fact = new Factory(current.value);
		branchOut(current);
		
	}
	
	private void branchOut(Node current){
		//if(current.right != null) { executeFromTreeNode(current.right);}
		//if(current.left != null) { executeFromTreeNode(current.left);}
	}
}
