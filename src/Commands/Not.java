package Commands;
import expression.Node;

public class Not extends Node{
	public boolean execute(double in1){
		return in1 == 0;
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
