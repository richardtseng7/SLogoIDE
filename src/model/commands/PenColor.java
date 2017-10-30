package model.commands;

import model.turtle.Turtle;

public class PenColor extends Command{
	@Override
	public double execute(Turtle t) {
		return t.getPen().getPenColor();
	}
	@Override
	public int getNumParam() {
		return 0;
	}
}