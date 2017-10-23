package model;

import java.util.HashMap;
import java.util.Map;

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
	
	
	public Model(Dimension2D canvas) {
		turtleID = 0;
		canvasDimension = canvas;
		turtles = new HashMap<>();
	}
	
	public void addTurtle() {
		Turtle t = new Turtle(turtleID, canvasDimension);
		turtles.put(turtleID, t);
		turtleID++;
	}
	
	public Turtle getTurtle(int ID) {
		return turtles.get(ID);
	}
	
}