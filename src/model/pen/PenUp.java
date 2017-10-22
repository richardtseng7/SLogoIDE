package model.pen;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class PenUp extends Pen{
	/**
	 * puts pen up such that when the turtle moves, it does not leave a trail
	 * @return 0
	 */
	@Override
	public int execute(Turtle t) {
		return putPen(t, false);
	}
}