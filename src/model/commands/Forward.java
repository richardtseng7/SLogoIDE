package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *		
 */
public class Forward extends Movement{
	public double execute(Turtle t, double dist) {
		return move(t, dist);
	}
	
	@Override
	public int getNumParam() {
		return 1;
	}
}