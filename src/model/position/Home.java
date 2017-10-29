package model.position;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Home extends Position{
	@Override
	public double execute(Turtle t) {
		return moveTo(t, t.getHome().getX(), t.getHome().getY());
	}
}