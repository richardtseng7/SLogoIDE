package model;

import java.util.Observable;

import javafx.geometry.Point2D;

public class PositionObservable extends Observable {
	
	private Point2D myPos;
	
	public PositionObservable(Point2D pos) {
		myPos = pos;
	}
	
	public void setValue(Point2D pos) {
		myPos.add(pos.getX() - myPos.getX(), pos.getY() - myPos.getY());
		setChanged();
		notifyObservers();
	}
	
	public Point2D getValue() {
		return myPos;
	}
}


