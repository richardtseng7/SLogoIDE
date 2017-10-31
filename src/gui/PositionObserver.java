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
 * @author richardtseng, nathanlewis
 *
 */
public class PositionObserver implements Observer {
	
	private Model turtleModel;
	private Pane canvasPane;
	
	public PositionObserver(Model m, Canvas c) {
		turtleModel = m;
		canvasPane = c.getPane();
	}

	@Override
	public void update(Observable o, Object arg) {
			for (Turtle t : turtleModel.getActiveTurtles()) {
				Pen p = t.getPen();
				if (p.getPenDown()) {
					double offsetX = t.getImageView().getLayoutBounds().getWidth()/2;
					double offsetY = t.getImageView().getLayoutBounds().getHeight()/2;
					double oldPosX = t.getOldPos().getX() + offsetX;
					double oldPosY = t.getOldPos().getY() + offsetY;
					Line l = new Line(oldPosX, oldPosY, ((Point2D) arg).getX() + offsetX, ((Point2D) arg).getY() + offsetY);
					l.setStrokeWidth(p.getPenSize());
					l.setFill(p.getColor());
					canvasPane.getChildren().add(l);
					p.addLine(l);
				}
				t.getImageView().toFront();
				t.getImageView().setX(((Point2D) arg).getX());
				t.getImageView().setY(((Point2D) arg).getY());
			}
	}
}