package expression;

import java.util.ArrayList;

/**
 * @author Peilin Lai
 */

public class ExpressionTree {
	public ExpressionTree (ArrayList<String> input, ArrayList<String> symbol) {
		
	}
	
	private boolean isOperator(String s) {
		if (s.equals("Command")) return true;
		else return false;
	}
}
