package gui.popups;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 * 
 * @author nathanlewis
 *
 */

public class ErrorPopUp extends PopUpScene{
	
	private String errorMessage;
	
	public ErrorPopUp(String error) {
		super();
		errorMessage = error;
	}

	@Override
	protected Pane setUpPane() {
		Label errorTitle = new Label("ERROR");
		errorTitle.setFont(Font.font("verdana", FontWeight.BOLD, 20));
		Label message = new Label(errorMessage);
		message.setTextAlignment(TextAlignment.CENTER);
		Pane popUpPane = new StackPane();
		popUpPane.getChildren().add(errorTitle);
		StackPane.setMargin(errorTitle, new Insets(10,0,0,0));
		StackPane.setAlignment(errorTitle, Pos.TOP_CENTER);
		popUpPane.getChildren().add(message);
		StackPane.setAlignment(message, Pos.CENTER);
		
		return popUpPane;
	}

	@Override
	protected String stageTitle() {
		return "Error Message";
	}
	
}
