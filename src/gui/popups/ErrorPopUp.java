package gui.popups;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ErrorPopUp extends PopUpScene{
	
	private String errorMessage;
	
	public ErrorPopUp(String error) {
		super();
		errorMessage = error;
	}

	@Override
	protected Pane setUpPane() {
		Label message = new Label(errorMessage);
		return null;
	}

	@Override
	protected String stageTitle() {
		return "Error Message";
	}
	
}
