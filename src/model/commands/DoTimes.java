package model.commands;

import java.util.ArrayList;

import expression.Executor;
import model.turtle.Turtle;

public class DoTimes {
	public double execute(Turtle t, String var, ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Integer> bracketBounds) {
		Executor e = new Executor(input, symbol, layers, bracketBounds, t);
		double returnval = 0;
		//double origvarval = var.getval;
		for(int i = 0; i< 10 /*var.getval*/; i ++){
			//var.set(i);
			returnval = Double.parseDouble(e.executeStarter());
		}
		return returnval;
		//need variables
	}
	
	public int getNumParam() {
		return 5;
	}
}
