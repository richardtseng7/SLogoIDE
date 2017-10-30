package model.commands;
import expression.Node;
import model.turtle.Turtle;
/**
 * @author Paul Lee
 */
import java.util.concurrent.ThreadLocalRandom;
public class Random extends Node{
	public double execute(Turtle t, double in1){
		return ThreadLocalRandom.current().nextDouble(0.0, in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
