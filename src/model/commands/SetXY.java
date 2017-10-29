package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetXY extends Position{
	@Override
	public double execute(Turtle t) {
		return moveTo(t, 0 + t.getHome().getX(), 0 + t.getHome().getY());
	}
}