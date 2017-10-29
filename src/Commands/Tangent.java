package Commands;
import expression.Node;
public class Tangent extends Node{
	public double execute(double in1){
		return Math.tan(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
