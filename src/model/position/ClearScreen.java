package model.position;

import expression.Node;
import model.turtle.Turtle;

public class ClearScreen extends Node{
	@Override
	public double execute(Turtle t) {
		//clear screen
		Home h = new Home();
		return h.execute(t);
	}
}