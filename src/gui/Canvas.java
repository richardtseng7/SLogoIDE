package gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Model;
import model.ObjectObservable;
import model.turtle.Turtle;

/**
 * @author richardtseng
 *
 */
public class Canvas implements Observer{
	
	private int background = 0;
	private ObjectObservable myPen;
	private Map<Integer, Color> palette;
	private Pane canvasPane;
	private Rectangle myCanvas;
	private Model turtleModel;

	public Canvas(Model m, Pane p, Node r) {
		turtleModel = m;
		canvasPane = p;
		myCanvas = (Rectangle) r;
		initializePalette();
	}
	
	private void initializePalette() {
		palette = new HashMap<>();
		palette.put(0, Color.BLACK);
		palette.put(1, Color.RED);
		palette.put(2, Color.ORANGE);
		palette.put(3, Color.YELLOW);
		palette.put(4, Color.GREEN);
		palette.put(5, Color.BLUE);
		palette.put(6, Color.INDIGO);
		palette.put(7, Color.VIOLET);
	}
	
	public int getBackground(){
		return background;
	}
	
	public Map<Integer, Color> getPalette(){
		return palette;
	}
	
	public Pane getPane() {
		return canvasPane;
	}
	
	public void setBackground(int index){
		background = index;
		myCanvas.setFill(palette.get(index));
	}
	
	public void setPalette(int index, int r, int g, int b) {
		palette.put(index, Color.rgb(r, g, b));
	}

	@Override
	public void update(Observable o, Object arg) {
		for (Turtle t : turtleModel.getActiveTurtles()) {
			t.getPen().setColor(palette.get((int) arg)); 
		}
	}
}