package model.commands;
import expression.Node;
import model.turtle.Turtle;

/**
 * @author Paul Lee
 */
public class Not extends Node{
	public boolean execute(Turtle t, double in1){
		return in1 == 0;
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
