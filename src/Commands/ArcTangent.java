package Commands;

public class ArcTangent {
	public double execute(double in1){
		return Math.atan(in1);
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
