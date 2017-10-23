package model.movement;

import model.turtle.Turtle;
import javafx.geometry.Point2D;
/**
 * @author richardtseng
 *	
 */
public abstract class Movement {
	protected double move(Turtle t, int direction, int pixels) {
		Point2D oldPos = t.getPos();
		double angle = Math.toRadians(t.getHeading());
		double x = oldPos.getX() + (direction * pixels * Math.sin(angle));
		double y = oldPos.getY() + (direction * pixels * Math.cos(angle));
		Point2D newPos = new Point2D(x, y);
		t.setPos(newPos);
		return pixels;
	}
}