package model.turtle;

import java.util.Map;
import gui.Canvas;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ObjectObservable;
import model.variables.Variables;

/**
 * @author richardtseng, nathanlewis
 *
 */
public class Turtle extends TurtleProperties{
	
	private Group group;
	private ImageView myImageView;
	private final int myID;
	private Point2D home;
	private Point2D oldPos;
	private ObjectObservable myPos;
	private ObjectObservable heading = new ObjectObservable(90.0);
	private ObjectObservable showing = new ObjectObservable(true);
	private int shape;
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
		myImageView = createImageView(IMAGE1, home.getX(), home.getY(), 0);
		shape = 1;
		myPen = new Pen();
		group = new Group();
		canvasObject.getPane().getChildren().add(group);
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
	
	//returns the location of home as a Point2D
	public Point2D getHome() {
		return home;
	}
	
	//returns the current turtle's ID
	public int getID() {
		return myID;
	}
	
	//returns the map of turtle images
	public Map<Integer, String> getImageMap(){
		return turtleImages;
	}
	
	//returns this turtle's ImageView
	public ImageView getImageView() {
		return myImageView;
	}
	
	//returns this turtle's Pen object
	public Pen getPen(){
		return myPen;
	}
	
	//returns the position that the turtle was in before the last command
	public Point2D getOldPos(){
		return oldPos;
	}
	
	//returns the observable heading
	public ObjectObservable getHeadingObservable() {
		return heading;
	}
	
	//returns the observable position
	public ObjectObservable getPositionObservable() {
		return myPos;
	}
	
	//returns the current position of the turtle
	public Point2D getPos() {
		return (Point2D) myPos.getValue();
	}	
	
	//returns the turtle's shape index
	public int getShape(){
		return shape;
	}
	
	//set the observable heading to double degrees direction, any observers will be notified
	public void setHeading(double degrees){
	    heading.setValue(degrees);
	}
	
	//set the observable showing to boolean bool (false = hidden, true = showing), any observers will be notified
	public void setShowing(boolean bool) {
		showing.setValue(bool);
	}
	
	//initializes the observable position to home, sets oldPos to home as well
	private void setHome() {
		home = new Point2D(canvasDimension.getWidth()/2 - TURTLE_SIZE/2, canvasDimension.getHeight()/2 - TURTLE_SIZE/2);
		oldPos = home;
		myPos = new ObjectObservable(home);
	}
	
	//initializes the turtle's ImageView
	public ImageView createImageView(String imageName, double initX, double initY, double initAngle) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(imageName));
		ImageView myImageView = new ImageView(image);
		myImageView.setFitHeight(TURTLE_SIZE);
		myImageView.setFitWidth(TURTLE_SIZE);
		myImageView.setX(initX);
		myImageView.setY(initY);
		myImageView.setRotate(initAngle);
		return myImageView;
	}
	
	//updates oldPos to the current position, sets the observable position to Point2D newPos, any observers will be notified
	public void setPos(Point2D newPos) {
		oldPos = (Point2D) myPos.getValue();
		myPos.setValue(newPos);
	}

	//return the variables map
	public Variables getVariablesMap() {
		return variablesMap;
	}
	
	//returns the canvas object
	public Canvas getCanvasObject() {
		return canvasObject;
	}
	
	//set the shape of the turtle according to the index
	public int setShape(int index) {
		shape = index;
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(turtleImages.get(index)));
		myImageView.setImage(image);
		return index;
	}
	
	public Group getGroup() {
			return group;
	}
}