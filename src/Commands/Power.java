package Commands;

public class Power {
	public double execute(double in1, double in2){
		return Math.pow(in1, in2);
	}
	@Override
	public int getNumParam() {
		return 2;
	}
}
