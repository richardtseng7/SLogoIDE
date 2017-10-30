package model.commands;
import expression.Node;
import model.turtle.Turtle;
public class Power extends Node{
	public double execute(Turtle t, double in1, double in2){
		return Math.pow(in1, in2);
	}
	@Override
	public int getNumParam() {
		return 2;
	}
}
