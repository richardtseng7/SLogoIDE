package model.turtle;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author richardtseng
 *
 */
public class Turtle {
	
	private ImageView myImageView;
	private static final String TURTLE_IMAGE = "Turtle_Slogo.png";
	private static final int TURTLE_SIZE = 30;

	private Point2D myPos;
	private Point2D home;
	private final int myID;
	private double heading = 90;
	private boolean showing = true;
	private boolean penDown = true;
	
	public Turtle(int ID, Dimension2D canvasDimension) {
		myID = ID;
		myPos = home;
		setImageView(canvasDimension);
	}
	
	private void setImageView(Dimension2D canvasDimension) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
		myImageView = new ImageView(image);
		myImageView.setFitHeight(TURTLE_SIZE);
		myImageView.setFitWidth(TURTLE_SIZE);
		myImageView.setX(canvasDimension.getWidth()/2);
		myImageView.setY(canvasDimension.getHeight()/2);
	}
	
	public Point2D getPos() {
		return myPos;
	}	
	
	public void setPos(Point2D newPos) {
		myPos = newPos;
	}
	
	public double getXCor() {
		return myPos.getX();
	}
	
	public double getYCor() {
		return myPos.getY();
	}
	
	public double getHeading(){
	    return heading;
	}
	
	public void setHeading(double degrees){
	    heading = degrees;
	}
	
	public int getID() {
		return myID;
	}
	
	public boolean getShowing() {
		return showing;
	}
	
	public void setShowing(boolean bool) {
		showing = bool;
	}
	
	public boolean getPenDown() {
		return penDown;
	}
	
	public void setPen(boolean bool) {
		penDown = bool;
	}
	
	public double home() {
		double distance = myPos.distance(home);
		myPos = home;
		return distance;
	}
	
	public ImageView getImageView() {
		return myImageView;
	}
}