package model.commands;

import expression.Executor;
import model.turtle.Turtle;

public class IfElse {
	public double execute(Turtle t, boolean expr, Executor e, Executor alt) {
		double returnval = 0;
		if(expr) { returnval = Double.parseDouble(e.executeStarter());}
		else{returnval = Double.parseDouble(alt.executeStarter());}
		return returnval;
		//need variables
	}
	
	public int getNumParam() {
		return 3;
	}
}
