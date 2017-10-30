package model.commands;

import model.turtle.Turtle;

import java.util.Queue;

import javafx.geometry.Point2D;
/**
 * @author richardtseng
 *	
 */
public abstract class Movement extends Command{
	
	protected double move(Turtle t, double distance) {
		//System.out.println(t.getYCor());
		Point2D oldPos = t.getPos();
		System.out.println(distance);
		System.out.println(t.getXCor());
		System.out.println(t.getYCor());
		double angle = Math.toRadians(t.getHeading());
		double x = oldPos.getX() - (distance * Math.cos(angle));
		double y = oldPos.getY() - (distance * Math.sin(angle));
		Point2D newPos = new Point2D(x, y);
		System.out.println(newPos.getX());
		System.out.println(newPos.getY());
		t.setPos(newPos);
		System.out.println(t.getXCor());
		System.out.println(t.getYCor());
		return distance;
	}
	/*
	@Override
	public void addmyParamType() {
		myParamType.add("Double");
	}*/
	
	@Override
	public int getNumParam() {
		return 1;
	}

	public double execute(Turtle t, double dist) {
		// TODO Auto-generated method stub
		return 0;
	}
}
