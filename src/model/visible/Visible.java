package model.visible;

import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public abstract class Visible {
	protected int show(Turtle t, boolean isVisible) {
		t.setShowing(isVisible);
		t.getImageView().setVisible(isVisible);
		return isVisible ? 1 : 0;
	}
}