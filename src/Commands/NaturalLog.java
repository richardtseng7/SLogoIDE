package Commands;

public class NaturalLog {
	public double execute(double in1){
		return Math.log(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
