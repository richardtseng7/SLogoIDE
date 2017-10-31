package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class PenDown extends PenProperties{
	/**
	 * puts pen down such that when the turtle moves, it leaves a trail
	 * @return 1
	 */
	public double execute(Turtle t) {
		return putPen(t, true);
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}