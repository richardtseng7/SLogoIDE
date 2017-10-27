package Commands;

public class Cosine {
	public double execute(double in1){
		return Math.cos(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
