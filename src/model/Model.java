package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;

import javafx.geometry.Dimension2D;
import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Model {
	
	private int turtleID;
	private Dimension2D canvasDimension;
	private Map<Integer, Turtle> turtles;
	private List<Turtle> activeTurtles;
	
	public Model(Dimension2D canvas) {
		turtleID = 1;
		canvasDimension = canvas;
		turtles = new HashMap<>();
		activeTurtles = new ArrayList<>();
	}

	public void addTurtle() {
		Turtle t = new Turtle(turtleID, canvasDimension);
		turtles.put(turtleID, t);
		turtleID++;
		makeActive(t);
	}
	
	public Turtle getTurtle(int myID) {
		return turtles.get(myID);
	}
	
	public Map<Integer, Turtle> getTurtles(){
		return turtles;
	}
	
	public List<Turtle> getActiveTurtles(){
		return activeTurtles;
	}
	
	public void makeActive(Turtle t) {
		activeTurtles.add(t);
	}
	
	public void replaceActiveTurtles(Collection<Turtle> turtles) {
		activeTurtles.clear();
		activeTurtles.addAll(turtles);
	}
	
	public double executeOnAllActive(ToDoubleFunction<Turtle> command) throws Exception{
		double returnVal = 0;
		for (int i = 0; i < activeTurtles.size(); i++) {
			returnVal = command.applyAsDouble(activeTurtles.get(i));
		}
		return returnVal;
	}
}