package gui;

import java.util.Observable;
import java.util.Observer;
import model.Model;
import model.turtle.Turtle;

public class HeadingObserver implements Observer{
	
	private static final double OFFSET = 90.0;
	private Model turtleModel;
	
	public HeadingObserver(Model m) {
		turtleModel = m;	}

	@Override
	public void update(Observable o, Object arg) {
			for (Turtle t : turtleModel.getActiveTurtles()) {
				t.getImageView().setRotate((double) arg - OFFSET);
			}
	}
}