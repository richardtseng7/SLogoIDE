package model.movement;

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
}