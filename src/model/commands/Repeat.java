package model.commands;

import java.util.ArrayList;

import expression.Executor;
import model.turtle.Turtle;

public class Repeat {
	
	public double execute(Turtle t, int expr, ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Integer> bracketBounds) {
		Executor e = new Executor(input, symbol, layers, bracketBounds, t);
		double returnval = 0;
		for(int i = 0; i< expr; i ++){ returnval = Double.parseDouble( e.executeStarter());}
		return returnval;
	}
	
	public int getNumParam() {
		return 5;
	}
}
