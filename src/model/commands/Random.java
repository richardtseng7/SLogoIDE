package model.commands;
import expression.Node;
public class Random extends Node{
	public double execute(double in1){
		return ThreadLocalRandom.current().nextDouble(0.0, in1);
	}
	@Override
	protected int getNumParam() {
		return 1;
	}
}
