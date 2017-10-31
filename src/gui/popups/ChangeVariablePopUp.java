package gui.popups;

import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.variables.Variables;

public class ChangeVariablePopUp extends PopUpScene{
	
	String variable;
	String value;
	TextField changeValue;
	Variables variablesMap;
	Button enter;
	
	public ChangeVariablePopUp(String s,Variables map){
		super();
		variable = s;
		String[] arr = variable.split(":");
		variable = ":" + arr[0];
		value = arr[1];
		variablesMap = map;
	}
	
	@Override
	protected Pane setUpPane() {
		StackPane pane = new StackPane();
		VBox box = new VBox(10);
		Label title = new Label("Change the value of the variable " + variable );
		title.setAlignment(Pos.CENTER);
		changeValue = new TextField();
		changeValue.setText(value);
		enter = new Button("Enter");
		box.getChildren().addAll(title,changeValue,enter);
		enter.setOnAction((event) -> {
			variablesMap.setVariables(variable, Double.parseDouble(changeValue.getText()));
			for(Map.Entry<String, Double> entry: variablesMap.map().entrySet()) {
				System.out.println(entry.getKey());
			}
			this.closePopUp();
		});
		pane.getChildren().add(box);
		StackPane.setMargin(box, new Insets(30,0,0,20));
		return pane;
	}

	@Override
	protected String stageTitle() {
		return "Change your variable value";
	}

}
