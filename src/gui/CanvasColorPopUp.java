package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


public class CanvasColorPopUp extends PopUpScene {
	
	protected ColorPicker colorPicker;

	@Override
	protected Pane setUpPane() {
		Label title = new Label("Select the canvas color using\nthe color picker below:");
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		colorPicker = new ColorPicker();
		colorPicker.setMinSize(100, 50);
		Pane popUpPane = new StackPane();
		popUpPane.getChildren().add(colorPicker);
		popUpPane.getChildren().add(title);
		StackPane.setMargin(title, new Insets(10,0,0,0));
		StackPane.setAlignment(title, Pos.TOP_CENTER);
		StackPane.setAlignment(colorPicker,Pos.CENTER);
		return popUpPane;
	}

	@Override
	protected String stageTitle() {
		return new String("Choose Canvas Color");
	}
	
	
	
}
