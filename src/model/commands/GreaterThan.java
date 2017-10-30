package model.commands;
import expression.Node;
public class GreaterThan extends Node {
	public boolean execute(double in1, double in2){
		return in1>in2;
	}
	@Override
	public int getNumParam() {
		return 2;
	}
}
