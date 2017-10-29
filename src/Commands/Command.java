package Commands;

import java.util.List;
import java.util.Queue;


/**
 * @author Peilin Lai
 */

public abstract class Command {
	private List<String> myParam;
	private Queue<String> myParamType;
	private Parameter myParameter;
	
	public Command(Parameter parameter) {
		myParameter = parameter;
	}
	
	public Boolean needMoreParam() {
		return !myParamType.isEmpty();
	}
	
	public String getNextParamType() {
		return myArgType.poll();
	}
	
	public void setNextParam(String argValue) {
		myParam.add(argValue);		
	}
	
	public abstract double execute();
}
