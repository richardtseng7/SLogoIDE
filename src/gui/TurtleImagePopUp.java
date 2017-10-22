package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TurtleImagePopUp extends PopUpScene{

	@Override
	protected Pane setUpPane() {
		Pane PopUpPane = new Pane();
		HBox box = new HBox(10);
		Button turtle1 = new Button("Turtle 1");
		Button turtle2 = new Button("Turtle 2");
		Button turtle3 = new Button("Turtle 3");
		box.getChildren().add(turtle1);
		box.getChildren().add(turtle2);
		box.getChildren().add(turtle3);
		PopUpPane.getChildren().add(box);
		return PopUpPane;
	}

	@Override
	protected String stageTitle() {
		return new String("Choose Turtle Image");
	}
	
	
	
}
