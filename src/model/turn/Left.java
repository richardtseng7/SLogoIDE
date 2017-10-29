package model.turn;

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
}