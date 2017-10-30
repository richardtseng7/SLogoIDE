package model.commands;
import expression.Node;
import model.turtle.Turtle;
public class Sine extends Node{
	public double execute(Turtle t, double in1){
		return Math.sin(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
