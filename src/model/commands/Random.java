package model.commands;
import expression.Node;
import java.util.concurrent.ThreadLocalRandom;
public class Random extends Node{
	public double execute(double in1){
		return ThreadLocalRandom.current().nextDouble(0.0, in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
