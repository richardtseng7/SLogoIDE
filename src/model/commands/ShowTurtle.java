package model.commands;

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
	public double execute(Turtle t) {
		return show(t, true);
	}
}