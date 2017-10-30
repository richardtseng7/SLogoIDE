package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Backward extends Movement{
	@Override
	public double execute(Turtle t) {
		return move(t, -1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}