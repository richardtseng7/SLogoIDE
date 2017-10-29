package model.commands;

import model.turtle.Turtle;

public class ClearScreen extends Command{
	@Override
	public double execute(Turtle t) {
		//clear screen
		t.getPen().clearScreen();
		Home h = new Home();
		return h.execute(t);
	}
}