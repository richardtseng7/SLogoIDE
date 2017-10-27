package Commands;

public class Product {
	public double execute(double in1, double in2){
		return in1*in2;
	}
	@Override
	public int getNumParam() {
		return 2;
	}
}
