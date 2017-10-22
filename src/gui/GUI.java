package gui;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

public class GUI {
	
	private static final double CANVAS_HEIGHT = 500;
	private static final double CANVAS_WIDTH = 500;
	protected Dimension2D canvasDimension;
	
	protected BorderPane mainPane;
	
	//Canvas and turtle
	protected Pane canvasPane;
	protected Node canvas;

	//Input and Input History
	private Node inputVBox;
	protected TextArea textInput;
	protected TextArea inputHistory;
	protected Button runButton;
	
	//Active Variables and Methods
	private Node variableVBox;
	private Label variablesLabel;
	private Label methodsLabel;
	private TextArea variablesText;
	private TextArea methodsText;
	
	//Toolbar Buttons
	private ToolBar toolbar;
	private Button newButton;
	private MenuButton editButton;
	private MenuItem canvasColor;
	private MenuItem penColor;
	private MenuItem turtleImage;
	private Button languageButton;
	private Button helpButton;
	
	public GUI() {
		init();
	}
	
	protected void init() {
		mainPane = new BorderPane();
		
		
		newButton = new Button("New");
		editButton = new MenuButton("Edit...");
		canvasColor = new MenuItem("Canvas Color");
		canvasColor.setOnAction((event) -> {
			CanvasColorPopUp popup = new CanvasColorPopUp();
			popup.showPopUp();
		});
		penColor = new MenuItem("Pen Color");
		penColor.setOnAction((event) -> {
			PenColorPopUp popup = new PenColorPopUp();
			popup.showPopUp();
		});
		turtleImage = new MenuItem("Turtle Image");
		turtleImage.setOnAction((event) -> {
			TurtleImagePopUp popup = new TurtleImagePopUp();
			popup.showPopUp();
		});
		editButton.getItems().addAll(canvasColor,penColor,turtleImage);
		languageButton = new Button("Languages");
		helpButton = new Button("Help");
		toolbar = new ToolBar(newButton, editButton, languageButton, helpButton);
		mainPane.setTop(toolbar);
		
		canvasPane = new Pane();
		canvasDimension = new Dimension2D(CANVAS_HEIGHT, CANVAS_WIDTH);
		canvasPane.setPrefSize(canvasDimension.getHeight(), canvasDimension.getWidth());
		canvas = new Rectangle(canvasDimension.getHeight(), canvasDimension.getWidth());
		((Rectangle) canvas).setFill(Color.WHITE);
		canvasPane.getChildren().add(canvas);
		mainPane.setLeft(canvasPane);
		mainPane.setMargin(canvasPane, new Insets(20,0,0,10));
						
		textInput = new TextArea();
		setTextArea(textInput,true,175,270);
		inputHistory = new TextArea();
		setTextArea(inputHistory,false,290,270);
		runButton = new Button("Run");
		
		inputVBox = new VBox(5);
		((VBox) inputVBox).getChildren().add(inputHistory);
		((VBox) inputVBox).getChildren().add(textInput);
		((VBox) inputVBox).getChildren().add(runButton);
		
		
		mainPane.setCenter(inputVBox);
		mainPane.setMargin(inputVBox, new Insets(20,10,0,10));
		
		variablesLabel = new Label("Active Variables:");
		variablesLabel.setTextFill(Color.WHITE);
		methodsLabel = new Label("User Defined Methods:");
		methodsLabel.setTextFill(Color.WHITE);
		variablesText = new TextArea();
		setTextArea(variablesText,false,210,190);
		methodsText = new TextArea();
		setTextArea(methodsText,false,210,190);
		
		variableVBox = new VBox(5);
		((VBox) variableVBox).getChildren().add(variablesLabel);
		((VBox) variableVBox).getChildren().add(variablesText);
		((VBox) variableVBox).getChildren().add(methodsLabel);
		((VBox) variableVBox).getChildren().add(methodsText);
		
		mainPane.setRight(variableVBox);
		mainPane.setMargin(variableVBox, new Insets(20,10,0,0));
	}

	private void setTextArea(TextArea text, Boolean editable, int height, int width) {
		text.setMinHeight(height);
		text.setMaxHeight(height);
		text.setMinWidth(width);
		text.setMaxWidth(width);
		text.setEditable(editable);
	}
	
	
	
}
