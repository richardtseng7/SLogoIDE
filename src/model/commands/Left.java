package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *		Paul Lee
 */
public class Left extends Turn{
	@Override
	public double execute(Turtle t, double degrees) {
		return turn(t, -degrees);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
	@Override
	public double execute(Turtle t) {
		// TODO Auto-generated method stub
		return 0;
	}
}