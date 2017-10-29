package model.commands;
import expression.Node;
public class Power extends Node{
	public double execute(double in1, double in2){
		return Math.pow(in1, in2);
	}
	@Override
	public int getNumParam() {
		return 2;
	}
}
