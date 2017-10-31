package model.commands;

import java.util.ArrayList;

import expression.Executor;
import model.turtle.Turtle;

public class If {
	public double execute(Turtle t, boolean expr, Executor e) {
		double returnval = 0;
		if(expr) { returnval = Double.parseDouble(e.executeStarter());}
		return returnval;
		//need variables
	}
	
	public int getNumParam() {
		return 2;
	}
}
