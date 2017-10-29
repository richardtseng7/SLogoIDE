package model.commands;

import model.turtle.Pen;
import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public abstract class PenProperties extends Command {
	protected double putPen(Turtle t, boolean penDown){
		t.getPen().setPenDown(penDown);
		return penDown ? 1 : 0;
	}
}