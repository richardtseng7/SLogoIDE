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
	private int shape = 0;
	private Dimension2D canvasDimension;
	private Pen myPen;
	
	public Turtle(int ID, Dimension2D canvas) {
		myID = ID;
		canvasDimension = canvas;
		setHome();
		setPos(home);
		setImageView();
		myPen = new Pen();
	}
		
	//returns the turtle's X coordinate from the center of the screen
	public double getXCor() {
		return myPos.getX() - canvasDimension.getWidth();
	}
	
	//returns the turtle's Y coordinate from the center of the screen
	public double getYCor() {
		return myPos.getY() - canvasDimension.getHeight();
	}
	
	//returns the turtle's heading in degrees
	public double getHeading(){
	    return heading;
	}
	
	//returns 1 if turtle is showing, 0 if it is hiding
	public int getShowing() {
		return showing ? 1 : 0;
	}
	
	public Point2D getHome() {
		return home;
	}
	
	public int getID() {
		return myID;
	}
	
	public ImageView getImageView() {
		return myImageView;
	}
	
	public Pen getPen(){
		return myPen;
	}
	
	public Point2D getPos() {
		return myPos;
	}	
	
	public int getShape(){
		return shape;
	}
	
	public void setHeading(double degrees){
	    heading = degrees;
	}
	
	public void setShowing(boolean bool) {
		showing = bool;
	}
	
	private void setHome() {
		home = new Point2D(canvasDimension.getWidth()/2, canvasDimension.getHeight()/2);
	}
	
	private void setImageView() {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
		myImageView = new ImageView(image);
		myImageView.setFitHeight(TURTLE_SIZE);
		myImageView.setFitWidth(TURTLE_SIZE);
		myImageView.setX(home.getX());
		myImageView.setY(home.getY());
	}
	
	public void setPos(Point2D newPos) {
		myPos = newPos;
	}
	
	public void setShape(int index) {
		shape = index;
	}
}