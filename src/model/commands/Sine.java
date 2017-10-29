package model.commands;
import expression.Node;
public class Sine extends Node{
	public double execute(double in1){
		return Math.sin(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
