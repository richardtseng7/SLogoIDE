package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *		
 */
public class Right extends Turn{
	public double execute(Turtle t, double degrees) {
		return turn(t, degrees);
	}
	
	@Override
	public int getNumParam() {
		return 1;
	}
}