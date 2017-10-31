package gui.popups;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.turtle.Pen;

/**
 * 
 * @author nathanlewis
 *
 */

public class PenColorPopUp extends PopUpScene{
	
	private ColorPicker colorPicker;
	private Slider widthSlider;
	private CheckBox upDownCheck;
	private Pen p;

	@Override
	protected Pane setUpPane() {
		Label colorLabel = createLabel("Change the color of the Pen using\nthe color picker below:");
		widthSlider = new Slider(1,10,p.getPenSize());
		widthSlider.prefWidth(200);
		widthSlider.setShowTickLabels(true);
		widthSlider.setShowTickMarks(true);
		widthSlider.setMajorTickUnit(5);
		widthSlider.setMinorTickCount(1);
		widthSlider.setSnapToTicks(true);
		Label sliderCaption = new Label(Double.toString(widthSlider.getValue()));
		widthSlider.valueProperty().addListener((obs,oldVal,newVal) -> {
			widthSlider.setValue(((int) Math.round(newVal.doubleValue())));
			sliderCaption.setText(Double.toString(widthSlider.getValue()));
			p.setPenSize((int) widthSlider.getValue());
		});
		HBox sliderBox = new HBox();
		sliderBox.getChildren().addAll(widthSlider,sliderCaption);
		
		Label widthLabel = createLabel("Change the width of the Pen using\nthe slider below:");
		colorPicker = new ColorPicker();
		colorPicker.setMinSize(100, 50);
		upDownCheck = new CheckBox("Pen Up/Pen Down\n(Selected/Deselected)");
		upDownCheck.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(colorLabel,colorPicker,widthLabel,sliderBox,upDownCheck);
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
