package model.movement;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Forward extends Movement{
	@Override
	public int execute(Turtle t) {
		return move(t, 1);
	}
}