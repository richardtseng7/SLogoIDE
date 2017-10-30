package model.turtle;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ObjectObservable;
import model.PositionObservable;

/**
 * @author richardtseng
 *
 */
public class Turtle {
	
	private ObjectObservable image;
	private ImageView myImageView;
	//private ObjectObservable myImageView;
	private static final String IMAGE1 = "Turtle_Slogo.png";
	private static final String IMAGE2 = "Turtle 2.png";
	private static final String IMAGE3 = "Turtle 3.png";
	private Map<Integer, String> turtleImages;
	private static final int TURTLE_SIZE = 30;
	private Point2D oldPos;
	//private Point2D myPos;
	private ObjectObservable myPos;
	private Point2D home;
	private final int myID;
	private ObjectObservable heading = new ObjectObservable(90.0);
	private ObjectObservable showing = new ObjectObservable(true);
	private int shape = 0;
	private Dimension2D canvasDimension;
	private Pen myPen;
	
	public Turtle(int ID, Dimension2D canvas) {
		myID = ID;
		canvasDimension = canvas;
		setHome();		
		initializeImageView();
		myPen = new Pen();
	}
		
	//returns the turtle's X coordinate from the center of the screen
	public double getXCor() {
		return ((Point2D) myPos.getValue()).getX() - canvasDimension.getWidth();
		//return myPos.getX() - canvasDimension.getWidth();
	}
	
	//returns the turtle's Y coordinate from the center of the screen
	public double getYCor() {
		return ((Point2D) myPos.getValue()).getY() - canvasDimension.getHeight();
		//return myPos.getY() - canvasDimension.getHeight();
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
	
	public ObjectObservable getPosObservable() {
		return myPos;
	}
	
	public Point2D getPos() {
		return (Point2D) myPos.getValue();
		//return myPos;
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
		myPos = new ObjectObservable(home);
		//myPos = home;
	}
	
	private void initializeImageView() {
		turtleImages = new HashMap<>();
		turtleImages.put(1, IMAGE1);
		turtleImages.put(2, IMAGE2);
		turtleImages.put(3, IMAGE3);
		image = new ObjectObservable(new Image(getClass().getClassLoader().getResourceAsStream(IMAGE1)));
		//Image image = new Image(getClass().getClassLoader().getResourceAsStream(IMAGE1));
		myImageView = new ImageView((Image) image.getValue());
		myImageView.setFitHeight(TURTLE_SIZE);
		myImageView.setFitWidth(TURTLE_SIZE);
		myImageView.setX(home.getX());
		myImageView.setY(home.getY());
	}
	
	private int setImageView(int index) {
		image.setValue(new Image(getClass().getClassLoader().getResourceAsStream(turtleImages.get(index))));
		//Image image = new Image(getClass().getClassLoader().getResourceAsStream(turtleImages.get(index)));
		myImageView.setImage((Image) image.getValue());
		return index;
	}
	
	public void setPos(Point2D newPos) {
		oldPos = (Point2D) myPos.getValue();
		myPos.setValue(newPos);
		//oldPos = myPos;
		//myPos = newPos;
	}
	
	public void setShape(int index) {
		shape = index;
	}
}