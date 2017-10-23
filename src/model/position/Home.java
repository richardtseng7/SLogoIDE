package model.position;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Home extends Position{
	@Override
	public int execute(Turtle t) {
		return moveTo(t, t.getHome().getX(), t.getHome().getY());
	}
}