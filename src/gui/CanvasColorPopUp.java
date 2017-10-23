package gui;

import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class CanvasColorPopUp extends PopUpScene {
	
	GUI gui = new GUI();

	@Override
	protected Pane setUpPane() {
		ColorPicker colorPickerCanvas = new ColorPicker();
		Pane popUpPane = new StackPane();
		popUpPane.getChildren().add(colorPickerCanvas);
		StackPane.setAlignment(colorPickerCanvas,Pos.TOP_CENTER);
		colorPickerCanvas.setOnAction((event) -> {
			System.out.println("Color Changed");
			System.out.println(colorPickerCanvas.getValue().toString());
			((Rectangle) gui.canvas).setFill(colorPickerCanvas.getValue());
			System.out.println(((Rectangle) gui.canvas).getFill().toString());
		});
		return popUpPane;
	}

	@Override
	protected String stageTitle() {
		return new String("Choose Canvas Color");
	}
	
	
}
