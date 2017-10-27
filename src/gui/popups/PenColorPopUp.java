package gui.popups;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PenColorPopUp extends PopUpScene{
	
	private ColorPicker colorPicker;
	private Slider widthSlider;
	private CheckBox upDownCheck;

	@Override
	protected Pane setUpPane() {
		Label colorLabel = createLabel("Change the color of the Pen using\nthe color picker below:");
		widthSlider = new Slider(1,10,1);
		Label widthLabel = createLabel("Change the width of the Pen using\nthe slider below:");
		colorPicker = new ColorPicker();
		colorPicker.setMinSize(100, 50);
		upDownCheck = new CheckBox("Pen Up/Pen Down\n(Selected/Deselected)");
		upDownCheck.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(colorLabel,colorPicker,widthLabel,widthSlider,upDownCheck);
		Pane popUpPane = new StackPane();
		popUpPane.getChildren().add(vbox);
		StackPane.setMargin(vbox, new Insets(30,0,0,10));
		StackPane.setAlignment(colorPicker,Pos.CENTER);
		return popUpPane;
	}

	@Override
	protected String stageTitle() {
		return "Choose Pen Color";
	}
	
	private Label createLabel(String message) {
		Label label = new Label(message);
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		return label;
	}
	
	public void setPickerEvent() {
		
	}
	
}
