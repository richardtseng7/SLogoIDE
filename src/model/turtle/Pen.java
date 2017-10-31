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

	private List<Line> myTrail;
	//private boolean penDown = true;
	private ObjectObservable penDown = new ObjectObservable(true);
	private int thickness = 4;
	private ObjectObservable color = new ObjectObservable(0);
	private Color myColor;
	private Map<Integer, Color> colorMap;
	//int thickness = 10;
	//int color = 0;
	
	public Pen() {
		myTrail = new ArrayList<>();
		myColor = new Color(0, 0, 0, 0);
		myColor = Color.BLACK;
		initializeColorMap();
	}
	
	private void initializeColorMap() {
		colorMap = new HashMap<>();
		colorMap.put(0, Color.BLACK);
		colorMap.put(1, Color.RED);
		colorMap.put(2, Color.ORANGE);
		colorMap.put(3, Color.YELLOW);
		colorMap.put(4, Color.GREEN);
		colorMap.put(5, Color.BLUE);
		colorMap.put(6, Color.INDIGO);
		colorMap.put(7, Color.VIOLET);
	}
	
	public void addLine(Line l){
		myTrail.add(l);
	}
	
	public void clearScreen(){
		myTrail.clear();
	}
	
	public Map<Integer, Color> getColorMap() {
		return colorMap;
	}
	
	public int getPenColorIndex(){
		return (int) color.getValue();
	}
	
	public Color getColor() {
		return myColor;
	}

	//returns 1 if turtle's pen is down, 0 if it is up
	public boolean getPenDown(){
		return (boolean) penDown.getValue();
	}
	
	public int getPenSize(){
		return thickness;
	}

	public void setColorMap(int index, int r, int g, int b) {
		colorMap.put(index, Color.rgb(r, g, b));
	}
	
	public void setColor(Color c) {
		myColor = c;
	}
	
	public void setPenColorIndex(int index){
		color.setValue(index);
		setColor(colorMap.get(index));
	}
	
	public void setPenDown(boolean bool) {
		penDown.setValue(bool);
	}
	
	public void setPenSize(int size) {
		thickness = size;
	}
}