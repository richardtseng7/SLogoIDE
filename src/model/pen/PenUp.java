package model.pen;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class PenUp extends Pen{
	@Override
	public int execute(Turtle t) {
		return putPen(t, false);
	}
}
