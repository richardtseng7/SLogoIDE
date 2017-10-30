package model.turtle;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ObjectObservable;

/**
 * @author richardtseng
 *
 */
public class Turtle {
	
	private ImageView myImageView;
	private static final String TURTLE_IMAGE = "Turtle_Slogo.png";
	private static final int TURTLE_SIZE = 30;
	private Point2D oldPos;
	private ObjectObservable myPos;
	private Point2D home;
	private final int myID;
	private ObjectObservable heading = new ObjectObservable(90);
	private ObjectObservable showing = new ObjectObservable(true);
	private int shape = 0;
	private Dimension2D canvasDimension;
	private Pen myPen;
	
	public Turtle(int ID, Dimension2D canvas) {
		myID = ID;
		canvasDimension = canvas;
		setHome();		
		setImageView();
		myPen = new Pen();
	}
		
	//returns the turtle's X coordinate from the center of the screen
	public double getXCor() {
		return ((Point2D) myPos.getValue()).getX() - canvasDimension.getWidth();
	}
	
	//returns the turtle's Y coordinate from the center of the screen
	public double getYCor() {
		return ((Point2D) myPos.getValue()).getX() - canvasDimension.getHeight();
	}
	
	//returns the turtle's heading in degrees
	public double getHeading(){
	    return (double) heading.getValue();
	}
	
	//returns 1 if turtle is showing, 0 if it is hiding
	public int getShowing() {
		return (boolean) showing.getValue() ? 1 : 0;
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
	
	public Point2D getOldPos(){
		return oldPos;
	}
	
	public Point2D getPos() {
		return (Point2D) myPos.getValue();
	}	
	
	public int getShape(){
		return shape;
	}
	
	public void setHeading(double degrees){
	    heading.setValue(degrees);
	}
	
	public void setShowing(boolean bool) {
		showing.setValue(bool);
	}
	
	private void setHome() {
		home = new Point2D(canvasDimension.getWidth()/2, canvasDimension.getHeight()/2);
		oldPos = home;
		myPos.setValue(home);
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
		oldPos = (Point2D) myPos.getValue();
		myPos.setValue(newPos);
	}
	
	public void setShape(int index) {
		shape = index;
	}
}