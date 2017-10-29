package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 * 
 */
public abstract class Turn extends Command {
	protected double turn(Turtle t, int direction) {
		int degrees = 0;
	    double oldHeading = t.getHeading();
		double newHeading = (direction) == 0 ? degrees : oldHeading + (direction * degrees);
	    t.setHeading(newHeading);
		return newHeading;
	}
	
	@Override
	public int getNumParam() {
		return 1;
	}
}