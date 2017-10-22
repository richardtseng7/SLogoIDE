package gui;

import javafx.scene.layout.Pane;

public class HelpPopUpMenu extends PopUpScene {

	@Override
	protected Pane setUpPane() {
		Pane popUp = new Pane();
		return popUp;
	}

	@Override
	protected String stageTitle() {
		return new String("Help Menu");
	}

}
