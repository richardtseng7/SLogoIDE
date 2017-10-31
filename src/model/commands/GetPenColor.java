package model.commands;

import model.turtle.Turtle;

public class GetPenColor extends Command{
	public double execute(Turtle t) {
		return t.getPen().getPenColorIndex();
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}