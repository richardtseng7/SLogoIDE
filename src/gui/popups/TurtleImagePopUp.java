package gui.popups;

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
	
	private static final String DEFAULT_IMAGE = "Turtle_Slogo.png"; 
	private static final String IMAGE2 = "Turtle 2.png";
	private static final String IMAGE3 = "Turtle 3.png";
	
	private Button turtle1;
	private Button turtle2;
	private Button turtle3;
	private ComboBox<String> selectTurtle;
	private Model model;
	
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
		return "Choose Turtle Image";
	}
	
	
	public void setTurtlePopUp(Model m) {
		model = m;
		setTurtleSelect();
		setTurtleButtonEvent();
	}

	private void setTurtleSelect() {
		for(int i=1; i<model.getTurtles().size()+1; i++) { //To change to no. of turtles
			selectTurtle.getItems().add("Turtle " + (i));
		}
		selectTurtle.getSelectionModel().selectFirst();
	}
	
	private ImageView createImageView(String filename) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(filename));
		ImageView graphic = new ImageView(image);
		graphic.setFitHeight(15);
		graphic.setFitWidth(15);
		return graphic;
	}
	
	private void setTurtleButtonEvent() {
		turtle1.setOnAction((event) -> {
			model.getTurtle(0).getImageView().setImage(new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE)));
		});
		turtle2.setOnAction((event) -> {
			model.getTurtle(0).getImageView().setImage(new Image(getClass().getClassLoader().getResourceAsStream(IMAGE2)));
		});
		turtle3.setOnAction((event) -> {
			model.getTurtle(0).getImageView().setImage(new Image(getClass().getClassLoader().getResourceAsStream(IMAGE3)));
		});
	}
	
	
	
}
