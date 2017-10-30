package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 * 			Paul Lee
 */
public abstract class Turn extends Command {
	protected double turn(Turtle t, double direction) {
	    double oldHeading = t.getHeading();
		double newHeading = oldHeading + direction;
	    t.setHeading(newHeading);
		return newHeading;
	}
	
	
	
	@Override
	public int getNumParam() {
		return 1;
	}



	public double execute(Turtle t, double degrees) {
		// TODO Auto-generated method stub
		return 0;
	}
}