package model.commands;

import expression.Node;
import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public abstract class PenProperties extends Node {
	protected double putPen(Turtle t, boolean penDown){
		t.getPen().setPen(penDown);
		return penDown ? 1 : 0;
	}
}