package model.turtle;

import java.util.Map;

import gui.Canvas;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ObjectObservable;
import model.variables.Variables;

/**
 * @author richardtseng, nathanlewis
 *
 */
public class Turtle extends TurtleProperties{
	
	private ImageView myImageView;
	private final int myID;
	private Point2D home;
	private Point2D oldPos;
	private ObjectObservable myPos;
	private ObjectObservable heading = new ObjectObservable(90.0);
	private ObjectObservable showing = new ObjectObservable(true);
	private int shape = 0;
	private Dimension2D canvasDimension;
	private Pen myPen;
	private Variables variablesMap;
	private Canvas canvasObject;
	
	public Turtle(int ID, Dimension2D canvas, Variables variables, Canvas canvasObj) {
		myID = ID;
		variablesMap = variables;
		canvasDimension = canvas;
		canvasObject = canvasObj;
		setHome();		
		initializeImageView();
		myPen = new Pen();
	}
		
	//returns the turtle's X coordinate from the center of the screen
	public double getXCor() {
		return ((Point2D) myPos.getValue()).getX() - home.getX();
	}
	
	//returns the turtle's Y coordinate from the center of the screen
	public double getYCor() {
		return  home.getY() - ((Point2D) myPos.getValue()).getY();
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
	
	public Map<Integer, String> getImageMap(){
		return turtleImages;
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
	
	public ObjectObservable getHeadingObservable() {
		return heading;
	}
	
	public ObjectObservable getPositionObservable() {
		return myPos;
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
		home = new Point2D(canvasDimension.getWidth()/2 - TURTLE_SIZE/2, canvasDimension.getHeight()/2 - TURTLE_SIZE/2);
		oldPos = home;
		myPos = new ObjectObservable(home);
	}
	
	private void initializeImageView() {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(IMAGE1));
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

	public Variables getVariablesMap() {
		return variablesMap;
	}
	
	public Canvas getCanvasObject() {
		return canvasObject;
	}
	
	public int setShape(int index) {
		shape = index;
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(turtleImages.get(index)));
		myImageView.setImage(image);
		return index;
	}
}