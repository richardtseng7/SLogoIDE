package Commands;

public class Sine {
	public double execute(double in1){
		return Math.sin(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
