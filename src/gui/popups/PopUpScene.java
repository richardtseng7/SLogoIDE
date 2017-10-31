package gui.popups;

import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * @author nathanlewis
 *
 */

public abstract class PopUpScene {
	
	protected Stage popUpStage;
	private static final int POPUP_SIZE = 300;
	
	public PopUpScene() {
		popUpStage = new Stage();
		Pane popUpPane = setUpPane();
		Scene popUpScene = new Scene(popUpPane,POPUP_SIZE,POPUP_SIZE);
		popUpStage.setScene(popUpScene);
		popUpStage.initModality(Modality.APPLICATION_MODAL);
		popUpStage.setTitle(stageTitle());
	}
	
	public void showPopUp() {
		popUpStage.show();
	}

	protected abstract Pane setUpPane();
	
	protected abstract String stageTitle();
	
}
