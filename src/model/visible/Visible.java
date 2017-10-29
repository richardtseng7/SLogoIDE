package model.visible;

import expression.Node;
import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public abstract class Visible extends Node {
	protected double show(Turtle t, boolean isVisible) {
		t.setShowing(isVisible);
		t.getImageView().setVisible(isVisible);
		return isVisible ? 1 : 0;
	}
}