package model.commands;

import model.turtle.Turtle;

public class ClearStamps extends Command{
	public double execute(Turtle t) {
		int ret = t.getGroup().getChildren().size() > 0 ? 1 : 0;
		t.getGroup().getChildren().clear();
		return ret;
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}
