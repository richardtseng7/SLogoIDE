package Commands;
import expression.Node;

public class Cosine extends Node {
	public double execute(double in1){
		return Math.cos(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
