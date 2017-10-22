package model.pen;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class PenDown extends Pen{
	@Override
	public int execute(Turtle t) {
		return putPen(t, true);
	}
}
