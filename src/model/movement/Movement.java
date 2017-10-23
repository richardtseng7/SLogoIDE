package model.movement;

import model.turtle.Turtle;
import gui.UIController;
import javafx.geometry.Point2D;
/**
 * @author richardtseng
 *	
 */
public abstract class Movement {
	protected double move(Turtle t, int direction) {
		UIController ui = new UIController();
		ui.storeOriginalPos(t);
		int pixels = 0;
		Point2D oldPos = t.getPos();
		double angle = Math.toRadians(t.getHeading());
		double x = oldPos.getX() + (direction * pixels * Math.cos(angle));
		double y = oldPos.getY() + (direction * pixels * Math.sin(angle));
		Point2D newPos = new Point2D(x, y);
		t.setPos(newPos);
		ui.updateScene(t);
		return pixels;
	}
}