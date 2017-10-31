package model.commands;

import java.util.ArrayList;

import expression.Executor;
import model.turtle.Turtle;

public class For {
	public double execute(Turtle t, String var, int start, int end, String incr, Executor e) {
		double returnval = 0;
		for(int i = start; i< end; i= (int) (i + t.getVariablesMap().getVariables(incr))){
			t.getVariablesMap().setVariables(var, (double)i);
			e.executeStarter();
		}
		return returnval;
		//need variables
	}
	
	public int getNumParam() {
		return 5;
	}
}
