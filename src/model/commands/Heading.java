package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Heading extends Command{
	public double execute(Turtle t) {
		return t.getHeading();
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}
