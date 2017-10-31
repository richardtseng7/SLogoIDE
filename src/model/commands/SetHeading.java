package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetHeading extends Turn{
	public double execute(Turtle t, double degrees) {
		return turn(t, degrees - t.getHeading());
	}
	
	@Override
	public int getNumParam() {
		return 1;
	}
}