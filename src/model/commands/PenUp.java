package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class PenUp extends PenProperties{
	/**
	 * puts pen up such that when the turtle moves, it does not leave a trail
	 * @return 0
	 */
	@Override
	public double execute(Turtle t) {
		return putPen(t, false);
	}
	@Override
	public int getNumParam() {
		return 0;
	}
}