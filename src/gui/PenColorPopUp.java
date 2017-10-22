package gui;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;

public class PenColorPopUp extends PopUpScene{

	@Override
	protected Pane setUpPane() {
		ColorPicker colorPickerPen = new ColorPicker();
		Pane popUpPane = new Pane();
		popUpPane.getChildren().add(colorPickerPen);
		return popUpPane;
	}

	@Override
	protected String stageTitle() {
		return new String("Choose Pen Color");
	}
	
}
