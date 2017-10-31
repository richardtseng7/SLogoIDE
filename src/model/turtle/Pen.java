package model.turtle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public void addLine(Line l){
		myTrail.add(l);
	}
	
	public void clearScreen(){
		myTrail.clear();
	}
	
	
	public Color getColor() {
		return myColor;
	}
	
	public int getPenColorIndex() {
		return (int) colorIndex.getValue();
	}

	//returns 1 if turtle's pen is down, 0 if it is up
	public boolean getPenDown(){
		return penDown;
	}
	
	public int getPenSize(){
		return thickness;
	}
	
	public ObjectObservable getColorObservable() {
		return colorIndex;
	}
	
	public void setColor(Color c) {
		myColor = c;
	}
	
	public void setPenColorIndex(int index) {
		colorIndex.setValue(index);
	}
	
	public void setPenDown(boolean bool) {
		penDown = bool;
	}
	
	public void setPenSize(int size) {
		thickness = size;
	}
}