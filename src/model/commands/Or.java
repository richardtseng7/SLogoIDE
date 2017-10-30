package model.commands;
import expression.Node;
import model.turtle.Turtle;

/**
 * @author Paul Lee
 */
public class Or extends Node{
	public boolean execute(Turtle t, double in1, double in2){
		return in1!= 0 || in2 !=0;
	}
	@Override
	public int getNumParam() {
		return 2;
	}
}
