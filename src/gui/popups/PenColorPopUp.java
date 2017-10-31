package gui.popups;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Model;
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
	private ComboBox<String> selectTurtle;
	private Model model;
	private Label sliderCaption;
	
	@Override
	protected Pane setUpPane() {
		Label turtleSelect = createLabel("Choose which turtle to change the pen for:");
		selectTurtle = new ComboBox<String>();
		Label colorLabel = createLabel("Change the color of the Pen using\nthe color picker below:");
		widthSlider = new Slider(1,10,1);
		widthSlider.prefWidth(250);
		widthSlider.setShowTickMarks(true);
		widthSlider.setMajorTickUnit(5);
		widthSlider.setMinorTickCount(1);
		widthSlider.setSnapToTicks(true);
		sliderCaption = new Label(Double.toString(widthSlider.getValue()));
		HBox sliderBox = new HBox();
		sliderBox.getChildren().addAll(widthSlider,sliderCaption);
		
		Label widthLabel = createLabel("Change the width of the Pen using\nthe slider below:");
		colorPicker = new ColorPicker();
		colorPicker.setMinSize(100, 30);
		upDownCheck = new CheckBox("Pen Up/Pen Down\n(Selected/Deselected)");
		upDownCheck.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(turtleSelect,selectTurtle,colorLabel,colorPicker,widthLabel,sliderBox,upDownCheck);
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
	
	public void setTurtlePopUp(Model m) {
		model = m;
		setTurtleSelect();
		setColorEvent();
		setSliderListener();
		setCheckEvent();
	}
	
	private void setTurtleSelect() {
		for(int i=1; i<model.getTurtles().size()+1; i++) { //To change to no. of turtles
			selectTurtle.getItems().add("Turtle " + (i));
		}
		selectTurtle.getSelectionModel().selectFirst();
		selectTurtle.setOnAction((event) -> {
			widthSlider.setValue(model.getTurtle(parseComboValue(selectTurtle.getValue())).getPen().getPenSize());
			upDownCheck.setSelected(model.getTurtle(parseComboValue(selectTurtle.getValue())).getPen().getPenDown());
		});
	}
	
	private void setSliderListener() {
		widthSlider.setValue(model.getTurtle(parseComboValue(selectTurtle.getValue())).getPen().getPenSize());
		sliderCaption.setText(Double.toString(widthSlider.getValue()));
		widthSlider.valueProperty().addListener((obs,oldVal,newVal) -> {
			widthSlider.setValue(((int) Math.round(newVal.doubleValue())));
			sliderCaption.setText(Double.toString(widthSlider.getValue()));
			model.getTurtle(parseComboValue(selectTurtle.getValue())).getPen().setPenSize((int) widthSlider.getValue());
		});
	}
	
	private void setColorEvent() {
		colorPicker.setOnAction((event) -> {
			System.out.println("Color Changed");
			model.getTurtle(parseComboValue(selectTurtle.getValue())).getPen().setColor(colorPicker.getValue());
		});
	}
	
	private void setCheckEvent() {
		upDownCheck.setSelected(model.getTurtle(parseComboValue(selectTurtle.getValue())).getPen().getPenDown());
		upDownCheck.setOnAction((event) -> {
			model.getTurtle(parseComboValue(selectTurtle.getValue())).getPen().setPenDown(upDownCheck.isSelected());
		});
	}
	
	private int parseComboValue(String s) {
		String[] arr = s.split(" ");
		return Integer.parseInt(arr[1]);
	}
	
	private Label createLabel(String message) {
		Label label = new Label(message);
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		return label;
	}
	
	public void setPickerEvent() {
		
	}
	
}
