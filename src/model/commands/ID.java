package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class ID extends Command{
	public double execute(Turtle t) {
		return t.getID();
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}