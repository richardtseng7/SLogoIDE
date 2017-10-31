package model.commands;

import model.turtle.Turtle;

/**
 * 
 * @author nathanlewis
 *
 */

public class MakeVariable {

	public void execute(Turtle t, String s, Double d) {
		t.getVariablesMap().setVariables(s, d);
	}
	
	public int getNumParam() {
		return 2;
	}
	
}
