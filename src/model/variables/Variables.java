package model.variables;

import java.util.HashMap;
import java.util.Observable;

/**
 * 
 * @author nathanlewis
 *
 */

public class Variables extends Observable {
	
	private HashMap<String,Double> variablesMap;
	
	public Variables(){
		variablesMap = new HashMap<String,Double>();
	}
	
	public void setVariables(String s, Double d) {
		variablesMap.put(s, d);
		setChanged();
		notifyObservers(variablesMap);
	}
	
	public Double getVariables(String s) {
		return variablesMap.get(s);
	}
	
	public HashMap<String,Double> map(){
		return variablesMap;
	}
}
