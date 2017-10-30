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
	private ObjectObservable thickness = new ObjectObservable(10);
	private ObjectObservable color = new ObjectObservable(0);
	private Map<Integer, Color> colorMap;
	//int thickness = 10;
	//int color = 0;
	
	public Pen() {
		myTrail = new ArrayList<>();
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
	
	public int getPenColor(){
		return (int) color.getValue();
	}

	//returns 1 if turtle's pen is down, 0 if it is up
	public int getPenDown(){
		return (boolean) penDown.getValue() ? 1 : 0;
	}
	
	public int getPenSize(){
		return (int) thickness.getValue();
	}

	public void setColorMap(int index, int r, int g, int b) {
		colorMap.put(index, Color.rgb(r, g, b));
	}
	
	public void setPenColor(int index){
		color.setValue(index);
	}
	
	public void setPenDown(boolean bool) {
		penDown.setValue(bool);
	}
	
	public void setPenSize(int size) {
		thickness.setValue(size);
	}
}