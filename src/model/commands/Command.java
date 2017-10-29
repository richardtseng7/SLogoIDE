package model.commands;

import java.util.List;
import java.util.Queue;

import logic.Parameter;
import model.turtle.Turtle;


/**
 * @author Peilin Lai, richardtseng
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
	
	public int getNumParam() {
		return 0;
	}
	
	public abstract double execute(Turtle t);
}