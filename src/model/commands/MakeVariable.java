package model.commands;

import model.turtle.Turtle;

/**
 * 
 * @author nathanlewis
 *
 */

public class MakeVariable {
	public double execute(Turtle t, String s, double d){
		t.getVariablesMap().setVariables(s, d);
		return d;
	}
	
	public int getNumParam() {
		return 2;
	}
	
}
