package model.turtle;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.ObjectObservable;

/**
 * @author richardtseng
 *
 */
public class Pen {

	private ObjectObservable colorIndex = new ObjectObservable(0);
	private List<Line> myTrail;
	private boolean penDown = true;
	private int thickness = 5;
	private Color myColor;
	
	public Pen() {
		myTrail = new ArrayList<>();
		myColor = new Color(0, 0, 0, 0);
		myColor = Color.BLACK;
	}
	
	//add a line to the turtle's trail
	public void addLine(Line l){
		myTrail.add(l);
	}
	
	//clear the list of line objects representing the turtle's trail
	public void clearScreen(){
		myTrail.clear();
	}
	
	
	//get the actual color of the pen
	public Color getColor() {
		return myColor;
	}
	
	//get the value of the observable pen color index
	public int getPenColorIndex() {
		return (int) colorIndex.getValue();
	}

	//returns 1 if turtle's pen is down, 0 if it is up
	public boolean getPenDown(){
		return penDown;
	}
	
	//returns the pen's size in int pixels
	public int getPenSize(){
		return thickness;
	}
	
	//returns the observable color index
	public ObjectObservable getColorObservable() {
		return colorIndex;
	}
	
	//set the color of the pen to a Color
	public void setColor(Color c) {
		myColor = c;
	}
	
	//set the observable pen color index, any observers will be notified
	public void setPenColorIndex(int index) {
		colorIndex.setValue(index);
	}
	
	//set the pen to bool state (false = up, true = down)
	public void setPenDown(boolean bool) {
		penDown = bool;
	}
	
	//set the pen size to int size
	public void setPenSize(int size) {
		thickness = size;
	}
}