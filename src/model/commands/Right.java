package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Right extends Turn{
	@Override
	public double execute(Turtle t) {
		return turn(t, -1);
	}
}