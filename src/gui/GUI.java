package gui;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javax.swing.*;

public class GUI {
	
	protected BorderPane mainPane;
	
	//Canvas and turtle
	private Pane canvasPane;
	private Node canvas;
	private ImageView turtleImage;
	private static final String TURTLE_IMAGE = "Turtle_Slogo.png";
	private static final int TURTLE_SIZE = 30;
	
	//Input and Input History
	private Node inputVBox;
	private TextArea textInput;
	private TextArea inputHistory;
	private Button runButton;
	
	//Active Variables and Methods
	private Node variableVBox;
	private Label variablesLabel;
	private Label methodsLabel;
	private TextArea variablesText;
	private TextArea methodsText;
	
	//Toolbar Buttons
	private ToolBar toolbar;
	private Button newButton;
	private Button editButton;
	private Button languageButton;
	private Button helpButton;
	
	public GUI() {
		init();
	}
	
	protected void init() {
		mainPane = new BorderPane();
		
		newButton = new Button("New");
		editButton = new Button("Edit...");
		languageButton = new Button("Languages");
		helpButton = new Button("Help");
		toolbar = new ToolBar(newButton, editButton, languageButton, helpButton);
		mainPane.setTop(toolbar);
		
		canvasPane = new Pane();
		canvasPane.setPrefSize(500, 500);
		canvas = new Rectangle(500,500);
		((Rectangle) canvas).setFill(Color.WHITE);
		canvasPane.getChildren().add(canvas);
		mainPane.setLeft(canvasPane);
		mainPane.setMargin(canvasPane, new Insets(20,0,0,10));
		
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
		turtleImage = new ImageView(image);
		turtleImage.setFitHeight(TURTLE_SIZE);
		turtleImage.setFitWidth(TURTLE_SIZE);
		turtleImage.setX(canvas.getLayoutBounds().getMaxX()/2);
		turtleImage.setY(canvas.getLayoutBounds().getMaxY()/2);
		canvasPane.getChildren().add(turtleImage);
		
		textInput = new TextArea();
		setTextArea(textInput,true,175,270);
		inputHistory = new TextArea();
		setTextArea(inputHistory,false,290,270);
		runButton = new Button("Run");
		runButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				//System.out.println("ABC");
				
			}
		});
		
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
