package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetBackground extends Command{
	public double execute(Turtle t, double index) {
		t.getCanvasObject().setBackground((int) index);
		return 0;
	}
	
	@Override
	public int getNumParam() {
		return 1;
	}
}