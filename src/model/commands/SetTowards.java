package model.commands;

import javafx.geometry.Point2D;
import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetTowards extends Command{
	
	private static final double OFFSET = 90.0;

	public double execute(Turtle t, double xCor, double yCor) {
		Point2D home = t.getHome();
		Point2D oldPos = t.getPos();
		double x = home.getX() + xCor;
		double y = home.getY() - yCor;
		double newHeading = OFFSET + Math.toDegrees(Math.atan2(x - oldPos.getX(), oldPos.getY() - y));
		double oldHeading = t.getHeading();
		t.setHeading(newHeading);
		return newHeading - oldHeading;
	}
	
	@Override
	public int getNumParam() {
		return 2;
	}
}