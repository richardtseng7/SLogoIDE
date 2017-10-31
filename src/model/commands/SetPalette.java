package model.commands;

import model.turtle.Turtle;

public class SetPalette extends Command{
	public double execute(Turtle t, double index, double r, double g, double b) {
		
		return 0;
	}
	
	@Override
	public int getNumParam() {
		return 4;
	}
}