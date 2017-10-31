package gui;

import java.util.Map;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorPalette {
	
	protected StackPane pane;
	private Map<Integer,Rectangle> rectangleMap;
	
	public ColorPalette(Map<Integer,Color> colorMap) {
		pane = new StackPane();
		Label turtleTitle = new Label("Turtle Image Index");
		HBox imageBox = new HBox();
		Label colorTitle = new Label("Color Palette Index");
		pane.getChildren().addAll(turtleTitle,colorTitle);
		for(Map.Entry<Integer,Color> entry : colorMap.entrySet()) {
			HBox colorBox = new HBox();
			Rectangle color = new Rectangle(20,10);
			color.setFill(entry.getValue());
			colorBox.getChildren().addAll(new Label(entry.getKey().toString()), color);
			pane.getChildren().add(colorBox);
		}
	}

}
