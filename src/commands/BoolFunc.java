package Commands;

public interface BoolFunc {
	boolean LESS(double in1, double in2);
	boolean LESSP(double in1, double in2);
	boolean GREATER(double in1, double in2);
	boolean GREATERP(double in1, double in2);
	boolean EQUAL(double in1, double in2);
	boolean EQUALP(double in1, double in2);
	boolean NOTEQUAL(double in1, double in2);
	boolean NOTEQUALP(double in1, double in2);
	boolean AND(double in1, double in2);
	boolean OR(double in1, double in2);
	boolean NOT(double in1);
}
