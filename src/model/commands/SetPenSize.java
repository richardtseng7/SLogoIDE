package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetPenSize extends Command{
	@Override
	public double execute(Turtle t) {
		t.getPen().setPenSize(0);
		return t.getPen().getPenSize();
	}
}