package gui;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Point2D;
import javafx.scene.paint.Paint;
import model.Model;

public class TurtleObserver implements Observer {
	
	private Model turtleModel;
	
	public TurtleObserver(Model m) {
		turtleModel = m;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Point2D) {
			turtleModel.getTurtle(1).getImageView().setX(((Point2D) arg).getX());
			turtleModel.getTurtle(1).getImageView().setY(((Point2D) arg).getY());
		}
	}

}
