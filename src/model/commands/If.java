package model.commands;

import java.util.ArrayList;

import expression.Executor;
import model.turtle.Turtle;

public class If {
	public double execute(Turtle t, int expr, ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Integer> bracketBounds) {
		Executor e = new Executor(input, symbol, layers, bracketBounds, t);
		for(int i = 0; i< expr; i ++){ e.executeStarter();}
		return 0;
		//need variables
	}
	
	public int getNumParam() {
		return 5;
	}
}
