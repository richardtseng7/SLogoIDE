package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Model;

/*
 * @author nathan.lewis
 */

public class TurtleImagePopUp extends PopUpScene{
	
	protected static final String DEFAULT_IMAGE = "Turtle_Slogo.png"; 
	protected static final String IMAGE2 = "Turtle 2.png";
	protected static final String IMAGE3 = "Turtle 3.png";
	
	protected Button turtle1;
	protected Button turtle2;
	protected Button turtle3;
	protected ComboBox<String> selectTurtle;
	
	@Override
	protected Pane setUpPane() {
		Pane popUpPane = new StackPane();
		VBox vbox = new VBox(20);
		HBox hbox = new HBox(10);
		Label title = new Label("Choose the turtle you want to\nchange the image for:");
		title.setAlignment(Pos.CENTER);
		title.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		selectTurtle = new ComboBox<String>();
		turtle1 = new Button("Turtle 1");
		turtle1.setGraphic(createImageView(DEFAULT_IMAGE));
		turtle2 = new Button("Turtle 2");
		turtle2.setGraphic(createImageView(IMAGE2));
		turtle3 = new Button("Turtle 3");
		turtle3.setGraphic(createImageView(IMAGE3));
		hbox.getChildren().addAll(turtle1,turtle2,turtle3);
		StackPane.setAlignment(title, Pos.TOP_CENTER);
		StackPane.setMargin(title, new Insets(40,0,0,0));
		StackPane.setAlignment(selectTurtle, Pos.CENTER);
		StackPane.setMargin(selectTurtle, new Insets(0,0,90,0));
		StackPane.setMargin(hbox, new Insets(150,0,0,10));
		popUpPane.getChildren().addAll(title,selectTurtle,hbox);
		return popUpPane;
	}

	@Override
	protected String stageTitle() {
		return new String("Choose Turtle Image");
	}
	
	protected void setTurtleSelection(Model m) {
		for(int i=0; i<1; i++) { //To change to no. of turtles
			selectTurtle.getItems().add("Turtle " + (i+1));
		}
	}
	
	private ImageView createImageView(String filename) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(filename));
		ImageView graphic = new ImageView(image);
		graphic.setFitHeight(15);
		graphic.setFitWidth(15);
		return graphic;
	}
	
	
	
}
