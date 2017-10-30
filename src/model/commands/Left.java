package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Left extends Turn{
	@Override
	public double execute(Turtle t) {
		return turn(t, 1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}