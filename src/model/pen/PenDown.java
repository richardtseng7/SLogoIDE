package model.pen;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class PenDown extends Pen{
	/**
	 * puts pen down such that when the turtle moves, it leaves a trail
	 * @return 1
	 */
	@Override	
	public double execute(Turtle t) {
		return putPen(t, true);
	}
}