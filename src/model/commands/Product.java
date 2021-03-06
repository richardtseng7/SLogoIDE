package model.commands;
import expression.Node;
import model.turtle.Turtle;

/**
 * @author Paul Lee
 */
public class Product extends Node{
	public double execute(Turtle t, double in1, double in2){
		return in1*in2;
	}
	@Override
	public int getNumParam() {
		return 2;
	}
}
