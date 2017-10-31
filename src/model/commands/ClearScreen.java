package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class ClearScreen extends Command{
	public double execute(Turtle t) {
		//Clear screen
		t.getPen().clearScreen();
		Home h = new Home();
		return h.execute(t);
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}