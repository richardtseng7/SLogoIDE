package gui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.turtle.Turtle;

public class TurtleImagePopUp extends PopUpScene{
	UIController ui = new UIController();
	
	private static final String DEFAULT_IMAGE = "Turtle_Slogo.png"; 
	private static final String IMAGE2 = "Turtle 2.png";
	private static final String IMAGE3 = "Turtle 3.png";
	
	@Override
	protected Pane setUpPane() {
		Pane PopUpPane = new Pane();
		HBox box = new HBox(10);
		Button turtle1 = new Button("Turtle 1");
		turtle1.setGraphic(createImageView(DEFAULT_IMAGE));
		Button turtle2 = new Button("Turtle 2");
		turtle2.setGraphic(createImageView(IMAGE2));
		Button turtle3 = new Button("Turtle 3");
		turtle3.setGraphic(createImageView(IMAGE3));
		box.getChildren().add(turtle1);
		box.getChildren().add(turtle2);
		box.getChildren().add(turtle3);
		turtle1.setOnAction((event) -> {
			ui.updateImage(DEFAULT_IMAGE);
		});
		turtle2.setOnAction((event) -> {
			ui.updateImage(IMAGE2);
		});
		turtle3.setOnAction((event) -> {
			ui.updateImage(IMAGE3);
		});
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
