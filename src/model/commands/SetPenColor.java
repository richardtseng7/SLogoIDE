package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetPenColor extends Command{
	public double execute(Turtle t, int index){
		t.getPen().setPenColorIndex(index);
		return t.getPen().getPenColorIndex();
	}
	
	@Override
	public int getNumParam() {
		return 1;
	}
}