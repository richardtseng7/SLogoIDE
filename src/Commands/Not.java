package Commands;

public class Not {
	public boolean execute(double in1){
		return in1 == 0;
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}
