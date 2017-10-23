package model.visible;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class ShowTurtle extends Visible{
	/**
	 * makes turtle visible
	 * @return 1
	 */
	@Override
	public int execute(Turtle t) {
		return show(t, true);
	}
}