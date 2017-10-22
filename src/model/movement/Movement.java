package model.movement;

import model.turtle.Turtle;
import javafx.geometry.Point2D;
/**
 * @author richardtseng
 *         paullee
 *	
 */
public abstract class Movement {
	
	protected int move(Turtle t, int direction, int pixels) {
	    //direction is 1 for forward, -1 for backwards
		Point2D pos = t.getPos();
		double x = pos.getX();
		double unitX = x/pos.magnitude();
		double y = pos.getY();
		double unitY = y/pos.magnitude();
		
		t.setPos(x+unitX*pixels*direction,y+unitY*pixels*direction);
		return pixels;
	}
}