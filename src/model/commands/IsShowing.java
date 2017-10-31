package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class IsShowing extends Command{
	public double execute(Turtle t) {
		return t.getShowing();
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}