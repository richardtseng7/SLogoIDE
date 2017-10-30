package model;

import java.util.Observable;

import javafx.geometry.Point2D;

public class PositionObservable extends Observable {
	
	private Point2D pos;
	
	public PositionObservable(Point2D newPos) {
		pos = newPos;
	}
	
	public void setValue(Point2D newPos) {
		pos = newPos;
		setChanged();
		notifyObservers(pos);
	}
	
	public Point2D getValue() {
		return pos;
	}
}


