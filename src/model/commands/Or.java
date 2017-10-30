package model.commands;
import expression.Node;
public class Or extends Node{
	public boolean execute(double in1, double in2){
		return in1!= 0 || in2 !=0;
	}
	@Override
	public int getNumParam() {
		return 2;
	}
}
