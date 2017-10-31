package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class IsPenDown extends Command{
	public double execute(Turtle t) {
		return t.getPen().getPenDown() ? 1 : 0;
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}
