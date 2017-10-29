package model.turtle;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Line;

/**
 * @author richardtseng
 *
 */
public class Pen {

	private List<Line> myTrail;
	private boolean penDown;
	int thickness = 0;
	
	public Pen() {
		myTrail = new ArrayList<>();
		penDown = true;
	}
	
	public void addLine(Line l) {
		myTrail.add(l);
	}
	
	public void clearScreen() {
		myTrail.clear();
	}

	public void setPen(boolean bool) {
		penDown = bool;
	}
}