package model.variables;

import java.util.HashMap;

public class Variables {
	
	private HashMap<String,Double> variablesMap;
	
	public Variables(){
		variablesMap = new HashMap<String,Double>();
	}
	
	public void setVariables(String s, Double d) {
		variablesMap.put(s, d);
	}
	
	public Double getVariables(String s) {
		return variablesMap.get(s);
	}
}
