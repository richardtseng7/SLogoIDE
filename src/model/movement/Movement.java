package model.movement;

import model.turtle.Turtle;
import gui.UIController;
import javafx.geometry.Point2D;
/**
 * @author richardtseng
 *         paullee
 *	
 */
public abstract class Movement {
	UIController ui = new UIController();
	protected double move(Turtle t, int direction, int pixels) {
		ui.storeOriginalPos(t);
		Point2D pos = t.getPos();
		double x = pos.getX();
		double unitX = x/pos.magnitude();
		double y = pos.getY();
		double unitY = y/pos.magnitude();
		Point2D newPos = new Point2D(x+unitX*pixels*direction, y+unitY*pixels*direction);
		t.setPos(newPos);
		ui.updateScene(t);
		return pixels;
	}
}