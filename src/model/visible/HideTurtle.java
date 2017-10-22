package model.visible;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class HideTurtle extends Visible{
	@Override
	public int execute(Turtle t) {
		return show(t, false);
	}
}