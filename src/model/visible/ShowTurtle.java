package model.visible;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class ShowTurtle extends Visible{
	@Override
	public int execute(Turtle t) {
		return show(t, true);
	}
}