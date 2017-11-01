package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetPosition extends Position{
	public double execute(Turtle t, double x, double y) {
		return moveTo(t, t.getHome().getX() + x, t.getHome().getY() - y);
	}
	
	@Override
	public int getNumParam() {
		return 2;
	}
}