package model.commands;

import model.turtle.Turtle;

import java.util.Queue;

import javafx.geometry.Point2D;
/**
 * @author richardtseng
 *	
 */
public abstract class Movement extends Command{
	
	protected double move(Turtle t, int distance) {
		int pixels = distance;
		int direction = 0; // need to get the direction from turtle
		Point2D oldPos = t.getPos();
		double angle = Math.toRadians(t.getHeading());
		double x = oldPos.getX() + (direction * pixels * Math.cos(angle));
		double y = oldPos.getY() + (direction * pixels * Math.sin(angle));
		Point2D newPos = new Point2D(x, y);
		t.setPos(newPos);
		return pixels;
	}
	
	@Override
	public void addmyParamType() {
		myParamType.add("Double");
	}
	@Override
	public int getNumParam() {
		return 1;
	}
}