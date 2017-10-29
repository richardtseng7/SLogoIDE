package gui;



import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.scene.control.window.Window;

import javax.swing.*;

public class GUI {
	
	private static final int CANVAS_HEIGHT = 500;
	private static final int CANVAS_WIDTH = 500;
	protected static final int CENTER_WIDTH = 270;
	private static final int RIGHT_WIDTH = 190;
	
	protected Dimension2D canvasDimension;
	
	protected BorderPane mainPane;
	
	//Canvas and turtle
	protected Pane canvasPane;
	protected Node canvas;
	protected TabPane turtleInfo;

	//Input and Input History
	private Node inputVBox;
	protected TextArea textInput;
	protected TextArea inputHistory;
	private ScrollPane inputScroll;
	private ScrollPane historyScroll;
	protected Button runButton;
	
	//Windows
	private Window inputWindow;
	private Window turtleInfoWindow;
	private Window variablesWindow;
	private Window methodsWindow;
	private VBox centerBox;
	private VBox rightBox;
	
	//Active Variables and Methods
	private Node variableVBox;
	private Label variablesLabel;
	private Label methodsLabel;
	private ListView<String> variablesText;
	private ListView<String> methodsText;
	
	//Toolbar Buttons
	private ToolBar toolbar;
	private Button newButton;
	private MenuButton editButton;
	protected MenuItem canvasColor;
	protected MenuItem penColor;
	protected MenuItem turtleImage;
	protected ChoiceBox<String> languageChoice;
	protected Button helpButton;
	
	public GUI() {
		init();
	}
	
	protected void init() {
		mainPane = new BorderPane();
		
		
		newButton = new Button("New");
		editButton = new MenuButton("Edit...");
		canvasColor = new MenuItem("Canvas Settings");
		penColor = new MenuItem("Pen Settings");
		turtleImage = new MenuItem("Turtle Image");
		
		editButton.getItems().addAll(canvasColor,penColor,turtleImage);
		languageChoice = new ChoiceBox<String>();
		languageChoice.setItems(FXCollections.observableArrayList("English","French","Chinese","German","Italian","Portugese","Russian","Spanish"));
		languageChoice.setTooltip(new Tooltip("Select language"));
		languageChoice.getSelectionModel().selectFirst();
		helpButton = new Button("Help");
		toolbar = new ToolBar(newButton, editButton, languageChoice, helpButton);
		mainPane.setTop(toolbar);
		
		canvasPane = new Pane();
		canvasDimension = new Dimension2D(CANVAS_HEIGHT, CANVAS_WIDTH);
		canvasPane.setPrefSize(canvasDimension.getHeight(), canvasDimension.getWidth());
		canvas = new Rectangle(canvasDimension.getHeight(), canvasDimension.getWidth());
		((Rectangle) canvas).setFill(Color.WHITE);
		((Rectangle) canvas).setStroke(Color.BLACK);
		((Rectangle) canvas).setStrokeWidth(5);
		canvasPane.getChildren().add(canvas);
		mainPane.setLeft(canvasPane);
		BorderPane.setMargin(canvasPane, new Insets(20,0,0,10));
		
		turtleInfo = new TabPane();
		turtleInfo.setPrefSize(CENTER_WIDTH, 170);
						
		textInput = new TextArea();
		textInput.setPrefSize(CENTER_WIDTH, 85);
		textInput.setWrapText(true);
		inputScroll = new ScrollPane();
		inputScroll.hbarPolicyProperty().set(ScrollPane.ScrollBarPolicy.NEVER);
		inputScroll.setPrefSize(CENTER_WIDTH,85);
		inputScroll.setContent(textInput);
		inputHistory = new TextArea();
		inputHistory.setPrefSize(CENTER_WIDTH, 195);
		inputHistory.setWrapText(true);
		inputHistory.setEditable(false);
		historyScroll = new ScrollPane();
		historyScroll.hbarPolicyProperty().set(ScrollPane.ScrollBarPolicy.NEVER);
		historyScroll.setPrefSize(CENTER_WIDTH, 195);
		historyScroll.setContent(inputHistory);
		runButton = new Button("Run");
		
		
		inputVBox = new VBox(5);
		((VBox) inputVBox).getChildren().addAll(historyScroll,inputScroll,runButton);
		inputWindow = new Window();
		inputWindow.setPrefSize(CENTER_WIDTH, 285);
		inputWindow.setResizableWindow(false);
		inputWindow.getContentPane().getChildren().add(inputVBox);
		turtleInfoWindow = new Window();
		turtleInfoWindow.setResizableWindow(false);
		turtleInfoWindow.setPrefSize(CENTER_WIDTH, 170);
		turtleInfoWindow.getContentPane().getChildren().add(turtleInfo);
		
		centerBox = new VBox(5);
		centerBox.getChildren().addAll(inputWindow,turtleInfoWindow);
		
		mainPane.setCenter(centerBox);
		BorderPane.setMargin(inputVBox, new Insets(20,10,0,10));
		
		variablesLabel = new Label("Active Variables:");
		variablesLabel.setTextFill(Color.WHITE);
		methodsLabel = new Label("User Defined Methods:");
		methodsLabel.setTextFill(Color.WHITE);
		variablesText = new ListView<String>();
		variablesText.getItems().add("test:10");
		variablesText.setPrefSize(RIGHT_WIDTH, 210);
		methodsText = new ListView<String>();
		methodsText.getItems().add("test method");
		methodsText.setPrefSize(RIGHT_WIDTH, 210);
		
		variableVBox = new VBox(5);
		((VBox) variableVBox).getChildren().addAll(variablesLabel,variablesText,methodsLabel,methodsText);
		
		mainPane.setRight(variableVBox);
		BorderPane.setMargin(variableVBox, new Insets(20,10,0,0));
	}
	
}
