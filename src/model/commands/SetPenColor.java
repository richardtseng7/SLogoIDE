package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetPenColor extends Command{
	public double execute(Turtle t, double index){
		t.getPen().setPenColorIndex((int) index);
		return t.getPen().getPenColorIndex();
	}
	
	@Override
	public int getNumParam() {
		return 1;
	}
}