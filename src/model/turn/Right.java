package model.turn;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Right extends Turn{
	@Override
	public int execute(Turtle t) {
		return turn(t, -1);
	}
}