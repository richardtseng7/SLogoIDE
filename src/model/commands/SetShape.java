package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetShape extends Command{
	public double execute(Turtle t, int index) {
		t.setShape(index);
		return t.getShape();
	}
	
	@Override
	public int getNumParam() {
		return 1;
	}
}