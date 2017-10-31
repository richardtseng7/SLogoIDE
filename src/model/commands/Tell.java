package model.commands;

import java.util.ArrayList;
import java.util.List;

import expression.Node;
import model.Model;
import model.turtle.Turtle;

public class Tell extends Node{
	public double execute(Turtle t, ArrayList<Integer> turtleIDs, Model m){
		List<Turtle> newActiveTurtles = new ArrayList<>();
		for (int i = 0; i<turtleIDs.size(); i++) {
			newActiveTurtles.add(m.getTurtle(turtleIDs.get(i)));
		}
		m.replaceActiveTurtles(newActiveTurtles);
		return turtleIDs.get((turtleIDs.size()-1));
	}
	
	public int getNumParam() {
		return 2;
	}
}