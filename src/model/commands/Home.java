package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Home extends Position{
	public double execute(Turtle t) {
		return moveTo(t, t.getHome().getX(), t.getHome().getY());
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}