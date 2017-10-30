package model.commands;
import expression.Node;
import model.turtle.Turtle;

/**
 * @author Paul Lee
 */

public class Cosine extends Node {
	public double execute(Turtle t, double in1){
		return Math.cos(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
