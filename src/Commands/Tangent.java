package Commands;

public class Tangent {
	public double execute(double in1){
		return Math.tan(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
