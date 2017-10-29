package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Forward extends Movement{
	@Override
	public double execute(Turtle t) {
		return move(t, 1);
	}
}