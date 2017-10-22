package model.pen;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public abstract class Pen {
	protected int putPen(Turtle t, boolean penDown){
		t.setPen(penDown);
		return penDown ? 1 : 0;
	}
}