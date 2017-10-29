package model.commands;

import expression.Node;

public class ArcTangent extends Node {
	public double execute(double in1){
		return Math.atan(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
