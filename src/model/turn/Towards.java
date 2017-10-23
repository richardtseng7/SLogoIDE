package model.turn;

import javafx.geometry.Point2D;
import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Towards {
	@Override
	public double execute(Turtle t) {
		Point2D home = t.getHome();
		Point2D oldPos = t.getPos();
		double x = home.getX() + 0;
		double y = home.getY() + 0;
		double newHeading = Math.toDegrees(Math.atan2(x - oldPos.getY(), y - oldPos.getX()));
		double oldHeading = t.getHeading();
		t.setHeading(newHeading);
		return newHeading - oldHeading;
	}
}