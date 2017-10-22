package model.turn;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *         paullee
 */
public abstract class Turn {

	protected double turn(Turtle t, int direction, int pixels) {
	    double degrees = direction * pixels;
	    t.setHeading(degrees);
		return degrees;
	}
}