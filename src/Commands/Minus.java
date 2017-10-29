package Commands;
import expression.Node;
public class Minus extends Node{
	public double execute(double in1){
		return -in1;
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
