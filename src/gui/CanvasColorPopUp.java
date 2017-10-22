package gui;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class CanvasColorPopUp extends PopUpScene {
	
	GUI gui = new GUI();

	@Override
	protected Pane setUpPane() {
		ColorPicker colorPickerCanvas = new ColorPicker();
		Pane popUpPane = new Pane();
		popUpPane.getChildren().add(colorPickerCanvas);
		colorPickerCanvas.setOnAction((event) -> {
			System.out.println("Color Changed");
			System.out.println(colorPickerCanvas.getValue().toString());
			((Rectangle) gui.canvas).setFill(colorPickerCanvas.getValue());
		});
		return popUpPane;
	}

	@Override
	protected String stageTitle() {
		return new String("Choose Canvas Color");
	}
	
	
}
