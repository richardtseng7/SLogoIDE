package model.commands;

import java.util.ArrayList;

import expression.Executor;
import model.turtle.Turtle;

public class For {
	public double execute(Turtle t, String var, int start, int end, String incr, ArrayList<String> input, ArrayList<String> symbol, ArrayList<Integer> layers, ArrayList<Integer> bracketBounds) {
		Executor e = new Executor(input, symbol, layers, bracketBounds, t);
		for(int i = start; i< end; i= i + 1 /*incr.val*/){
			
		}
		return 0;
		//need variables
	}
	
	public int getNumParam() {
		return 9;
	}
}
