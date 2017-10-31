package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class YCoordinate extends Command{
	public double execute(Turtle t) {
		return t.getHome().getY() + t.getYCor();
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}
