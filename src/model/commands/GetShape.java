package model.commands;

import model.turtle.Turtle;

public class GetShape extends Command{
	public double execute(Turtle t) {
		return t.getShape();
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}