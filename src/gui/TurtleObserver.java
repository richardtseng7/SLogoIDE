package gui;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import model.Model;
import model.turtle.Pen;
import model.turtle.Turtle;

/**
 * @author richardtseng, Nathan
 *
 */
public class TurtleObserver implements Observer {
	
	private Model turtleModel;
	private Pane canvasPane;
	
	public TurtleObserver(Model m, Pane p) {
		turtleModel = m;
		canvasPane = p;
	}

	@Override
	public void update(Observable o, Object arg) {
			Turtle t = turtleModel.getTurtle(1);
			Pen p = t.getPen();
			if (p.getPenDown()) {
				Line l = new Line(t.getOldPos().getX(), t.getOldPos().getY(), ((Point2D) arg).getX(), ((Point2D) arg).getY());
				l.setStrokeWidth(p.getPenSize());
				l.setFill(p.getColor());
				canvasPane.getChildren().add(l);
				p.addLine(l);
			}
			t.getImageView().setX(((Point2D) arg).getX());
			t.getImageView().setY(((Point2D) arg).getY());
	}
}