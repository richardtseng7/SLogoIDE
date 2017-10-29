package model.turn;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetHeading extends Turn{
	@Override
	public double execute(Turtle t) {
		return turn(t, 0);
	}
}