package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class XCoordinate extends Command{
	public double execute(Turtle t) {
		return t.getHome().getX() - t.getXCor();
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}