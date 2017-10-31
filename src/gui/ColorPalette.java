package gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.turtle.TurtleProperties;

/**
 * 
 * @author nathanlewis
 *
 */

public class ColorPalette implements Observer{
	
	protected StackPane pane;
	private Map<Integer,Rectangle> rectangleMap;
	private Map<Integer,Color> colorIndex;
	
	public ColorPalette(Map<Integer,Color> colorMap) {
		colorIndex = colorMap;
		pane = new StackPane();
		VBox mainBox = new VBox(5);
		Label turtleTitle = new Label("Turtle Image Index");
		TurtleProperties tp = new TurtleProperties();
		HBox imageBox = new HBox(10);
		imageBox.getChildren().addAll(new Label("1"), createImageView(tp.getImage(1)),new Label("2"),createImageView(tp.getImage(2)),new Label("3"), createImageView(tp.getImage(3)));
		Label colorTitle = new Label("Color Palette Index");
		rectangleMap = new HashMap<Integer,Rectangle>();
		for(Map.Entry<Integer,Color> entry : colorMap.entrySet()) {
			Rectangle color = new Rectangle(30,20);
			color.setFill(entry.getValue());
			rectangleMap.put(entry.getKey(), color);
		}
		mainBox.getChildren().addAll(turtleTitle,imageBox,colorTitle);
		for(Map.Entry<Integer, Rectangle> entry : rectangleMap.entrySet()) {
			HBox colorBox = new HBox(15);
			Label tag = new Label(entry.getKey().toString());
			tag.setMinSize(15, 20);
			colorBox.getChildren().addAll(tag, entry.getValue());
			mainBox.getChildren().add(colorBox);
		}
		pane.getChildren().add(mainBox);
		StackPane.setMargin(mainBox, new Insets(20,0,0,10));
	}
	
	private ImageView createImageView(Image image) {
		ImageView graphic = new ImageView(image);
		graphic.setFitHeight(15);
		graphic.setFitWidth(15);
		return graphic;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Update Runs");
		for(Map.Entry<Integer, Color> entry : ((HashMap<Integer, Color>) arg).entrySet()) {
			if(entry.getValue() != colorIndex.get(entry.getKey())) {
				rectangleMap.get(entry.getKey()).setFill(entry.getValue());
			}
		}
		
	}

}
