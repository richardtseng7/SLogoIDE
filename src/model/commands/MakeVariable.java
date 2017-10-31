package model.commands;

import model.turtle.Turtle;

/**
 * 
 * @author nathanlewis
 *
 */

public class MakeVariable {

	public Double execute(Turtle t, String s, Double d) {
		t.getVariablesMap().setVariables(s, d);
		return d;
	}
	
	public int getNumParam() {
		return 2;
	}
	
}
