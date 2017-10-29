package Commands;

import java.util.List;
import java.util.Queue;

import logic.Parameter;


/**
 * @author Peilin Lai
 */

public abstract class Command {
	private List<String> myParam;
	private Queue<String> myParamType;
	
	public Command() {
	}
	
	public Boolean needMoreParam() {
		return !myParamType.isEmpty();
	}
	
	public String getNextParamType() {
		return myParamType.poll();
	}
	
	public void setNextParam(String argValue) {
		myParam.add(argValue);		
	}
	
	public abstract double execute();
}
