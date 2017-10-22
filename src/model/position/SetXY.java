package model.position;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetXY extends Position{
	@Override
	public int execute(Turtle t) {
		return moveTo(t, 0 + t.getHome().getX(), 0 + t.getHome().getY());
	}
}