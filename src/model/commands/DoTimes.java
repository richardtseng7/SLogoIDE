package model.commands;

import java.util.ArrayList;

import expression.Executor;
import model.turtle.Turtle;

public class DoTimes {
	public double execute(Turtle t, String var, Executor e) {
		double returnval = 0;
		double origVal = t.getVariablesMap().getVariables(var);
		for(int i = 1; i<= origVal; i ++){
			t.getVariablesMap().setVariables(var, (double)i);
			returnval = Double.parseDouble(e.executeStarter());
		}
		return returnval;
	}
	
	public int getNumParam() {
		return 2;
	}
}
