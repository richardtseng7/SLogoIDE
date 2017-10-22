package Commands;

public interface MathFunc {
	double SUM (double in1, double in2);
	double DIFFERENCE(double in1, double in2);
	double PRODUCT(double in1, double in2);
	double QUOTIENT(double in1, double in2);
	double REMAINDER(double in1, double in2);
	double MINUS(double exp);
	double RANDOM(double max);
	double SIN(double degrees);
	double COS(double degrees);
	double TAN(double degrees);
	double ATAN(double degrees);
	double LOG(double exp);
	double POW(double base, double exponent);
	double PI();
}
