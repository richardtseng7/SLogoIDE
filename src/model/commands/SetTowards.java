package model.commands;

import javafx.geometry.Point2D;
import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class SetTowards extends Command{
	public double execute(Turtle t, double xCor, double yCor) {
		Point2D home = t.getHome();
		Point2D oldPos = t.getPos();
		double x = home.getX() + xCor;
		double y = home.getY() + yCor;
		double newHeading = Math.toDegrees(Math.atan2(x - oldPos.getY(), y - oldPos.getX()));
		double oldHeading = t.getHeading();
		t.setHeading(newHeading);
		return newHeading - oldHeading;
	}
	
	@Override
	public int getNumParam() {
		return 2;
	}
}