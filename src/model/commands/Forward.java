package model.commands;

import java.util.Queue;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Forward extends Movement{
	
	@Override
	public double execute(Turtle t) {
		addmyParamType();
		return move(t, 1);
	}
}