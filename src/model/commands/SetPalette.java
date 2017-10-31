package model.commands;

import model.turtle.Turtle;

public class SetPalette extends Command{
	public double execute(Turtle t, double index, double r, double g, double b) {
		t.getCanvasObject().setPalette((int) index, (int) r,(int) g,(int) b);
		return index;
	}
	
	@Override
	public int getNumParam() {
		return 4;
	}
}