package model.commands;
import expression.Node;
public class NaturalLog extends Node{
	public double execute(double in1){
		return Math.log(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
