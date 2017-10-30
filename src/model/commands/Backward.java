package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Backward extends Movement{
	@Override
	public double execute(Turtle t, double dist) {
		return move(t, -dist);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
	@Override
	public double execute(Turtle t) {
		// TODO Auto-generated method stub
		return 0;
	}
}