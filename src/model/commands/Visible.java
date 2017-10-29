package model.commands;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public abstract class Visible extends Command{
	protected double show(Turtle t, boolean isVisible) {
		t.setShowing(isVisible);
		t.getImageView().setVisible(isVisible);
		return isVisible ? 1 : 0;
	}
}