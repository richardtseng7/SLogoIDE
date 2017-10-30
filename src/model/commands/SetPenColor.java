package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetPenColor extends Command{
	@Override
	public double execute(Turtle t){
		t.getPen().setPenColorIndex(0);
		return t.getPen().getPenColorIndex();
	}
}