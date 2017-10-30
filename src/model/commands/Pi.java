package model.commands;
import expression.Node;
public class Pi extends Node{
	public double execute(){
		return Math.PI;
	}
	@Override
	public int getNumParam() {
		return 0;
	}
}
