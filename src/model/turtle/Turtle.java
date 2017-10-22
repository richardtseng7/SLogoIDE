package model.turtle;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

/**
 * @author richardtseng
 *
 */
public class Turtle {
	
	private ImageView myImageView;
	private Point2D myPos;
	private Point2D home;
	private final int myID;
	
	public Turtle(int ID) {
		myID = ID;
		myPos = home;
	}
	
	public Point2D getPos() {
		return myPos;
	}	
	
	public double getXCor() {
		return myPos.getX();
	}
	
	public double getYCor() {
		return myPos.getY();
	}
	
	public int getID() {
		return myID;
	}
	
	public double home() {
		double distance = myPos.distance(home);
		myPos = home;
		return distance;
	}
	
	public int show() {
		
		return 1;
	}
	
	public int hide() {
		
		return 0;
	}
}