package model;

import java.util.Observable;

public class ObjectObservable extends Observable{
	private Object obj;
	
	public ObjectObservable(Object val) {
		obj = val;
	}
	
	public void setValue(Object val) {
		obj = val;
		setChanged();
		notifyObservers();
	}
	
	public Object getValue() {
		return obj;
	}
}