package model.turn;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public abstract class Turn {

	protected int turn(Turtle t, int direction) {
	    t.setHeading((double)direction);
		
		return degrees;
	}
}