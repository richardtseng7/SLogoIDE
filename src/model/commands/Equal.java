package model.commands;
import expression.Node;
import model.turtle.Turtle;
public class Equal extends Node {
	public boolean execute(Turtle t, double in1, double in2){
		return in1==in2;
	}
	@Override
	public int getNumParam() {
		return 2;
	}
}
