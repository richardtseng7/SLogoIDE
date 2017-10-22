package Commands;

import java.util.concurrent.ThreadLocalRandom;

public class Commands implements MathFunc, BoolFunc {
	public double SUM (double in1, double in2){
		return in1+in2;
	}
	public double DIFFERENCE(double in1, double in2){
		return in1-in2;
	}
	public double PRODUCT(double in1, double in2){
		return in1*in2;
	}
	public double QUOTIENT(double in1, double in2){
		return in1/in2;
	}
	public double REMAINDER(double in1, double in2){
		return in1%in2;
	}
	public double MINUS(double exp){
		return -exp;
	}
	public double RANDOM(double max){
		return ThreadLocalRandom.current().nextDouble(0.0, max);
	}
	public double SIN(double degrees){
		return Math.sin(degrees);
	}
	public double COS(double degrees){
		return Math.cos(degrees);
	}
	public double TAN(double degrees){
		return Math.tan(degrees);
	}
	public double ATAN(double degrees){
		return Math.atan(degrees);
	}
	public double LOG(double exp){
		return Math.log(exp);
	}
	public double POW(double base, double exponent){
		return Math.pow(base, exponent);
	}
	public double PI(){
		return Math.PI;
	}
	public boolean LESS(double in1, double in2){
		return in1<in2;
	}
	public boolean LESSP(double in1, double in2){
		return in1<in2;
	}
	public boolean GREATER(double in1, double in2){
		return in1>in2;
	}
	public boolean GREATERP(double in1, double in2){
		return in1>in2;
	}
	public boolean EQUAL(double in1, double in2){
		return in1==in2;
	}
	public boolean EQUALP(double in1, double in2){
		return in1==in2;
	}
	public boolean NOTEQUAL(double in1, double in2){
		return in1!=in2;
	}
	public boolean NOTEQUALP(double in1, double in2){
		return in1!=in2;
	}
	public boolean AND(double in1, double in2){
		return in1!=0 && in2!=0;
	}
	public boolean OR(double in1, double in2){
		return in1!= 0 || in2 !=0;
	}
	public boolean NOT(double in1){
		return in1 == 0;
	}
}
