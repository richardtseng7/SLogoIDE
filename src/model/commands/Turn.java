package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 * 			
 */
public abstract class Turn extends Command{
	protected double turn(Turtle t, double direction) {
	    double oldHeading = t.getHeading();
		double newHeading = oldHeading + direction;
	    t.setHeading(newHeading);
		return newHeading;
	}
}