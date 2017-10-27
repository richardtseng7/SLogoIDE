package model.position;

import expression.Node;
import javafx.geometry.Point2D;
import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public abstract class Position extends Node {
	protected double moveTo(Turtle t, double xCor, double yCor) {
		Point2D oldPos = t.getPos();
		Point2D newPos = new Point2D(xCor, yCor);
		t.setPos(newPos);
		return oldPos.distance(newPos);
	}
	
	@Override
	protected int getNumParam() {
		return 2;
	}
}