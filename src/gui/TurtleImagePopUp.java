package gui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TurtleImagePopUp extends PopUpScene{

	@Override
	protected Pane setUpPane() {
		Pane PopUpPane = new Pane();
		HBox box = new HBox(10);
		Button turtle1 = new Button("Turtle 1");
		turtle1.setGraphic(createImageView("Turtle_Slogo.png"));
		Button turtle2 = new Button("Turtle 2");
		turtle2.setGraphic(createImageView("Turtle 2.png"));
		Button turtle3 = new Button("Turtle 3");
		turtle3.setGraphic(createImageView("Turtle 3.png"));
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
	
	private ImageView createImageView(String filename) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(filename));
		ImageView graphic = new ImageView(image);
		graphic.setFitHeight(15);
		graphic.setFitWidth(15);
		return graphic;
	}
	
	
	
}
