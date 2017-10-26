package model.turn;

import model.turtle.Turtle;

/**
 * @author richardtseng
 * 
 */
public abstract class Turn {
	protected double turn(Turtle t, int direction) {
		int degrees = 0;
	    double oldHeading = t.getHeading();
		double newHeading = (direction) == 0 ? degrees : oldHeading + (direction * degrees);
	    t.setHeading(newHeading);
		return newHeading;
	}
	
	@Override
	protected int getNumParam() {
		return 1;
	}
}