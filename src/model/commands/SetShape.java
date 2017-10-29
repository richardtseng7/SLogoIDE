package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetShape extends Command{
	@Override
	public double execute(Turtle t) {
		t.setShape(0);
		return t.getShape();
	}
}