package gui;

import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PenColorPopUp extends PopUpScene{

	@Override
	protected Pane setUpPane() {
		ColorPicker colorPickerPen = new ColorPicker();
		Pane popUpPane = new StackPane();
		popUpPane.getChildren().add(colorPickerPen);
		StackPane.setAlignment(colorPickerPen,Pos.TOP_CENTER);
		return popUpPane;
	}

	@Override
	protected String stageTitle() {
		return new String("Choose Pen Color");
	}
	
}
