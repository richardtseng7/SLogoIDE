package gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.scene.control.window.MinimizeIcon;
import jfxtras.scene.control.window.Window;

import javax.swing.*;

/**
 * 
 * @author nathanlewis
 *
 */

public class GUI {
	
	private static final int CANVAS_HEIGHT = 500;
	private static final int CANVAS_WIDTH = 500;
	private static final int RIGHTPANE_WIDTH = 700;
	private static final int INPUT_WIDTH = 240;
	private static final int INPUT_HEIGHT = 310;
	private static final int LISTS_WIDTH = 240;
	private static final int LISTS_HEIGHT = 210;
	private static final int TURTLELIST_HEIGHT = 250;
	protected static final int TURTLELIST_WIDTH = 240;
			
	protected Dimension2D canvasDimension;
	protected BorderPane mainPane;
	
	//Canvas and turtle
	protected Pane canvasPane;
	protected Node canvas;
	protected TabPane turtleInfo;
	protected Button addTurtle;
	private VBox leftBox;
	
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
	protected Window paletteWindow;
	
	private Pane windowCanvas;
	
	//Active Variables and Methods
	private ListView<String> variablesText;
	private ListView<String> methodsText;
	
	//Toolbar Buttons
	protected ToolBar toolbar;
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
		
		canvasPane.getChildren().addAll(canvas);
		leftBox = new VBox(5);
		addTurtle = new Button("Add Turtle");
		leftBox.getChildren().addAll(canvasPane,addTurtle);

		mainPane.setLeft(leftBox);
		BorderPane.setMargin(leftBox, new Insets(20,0,0,10));
		
		turtleInfo = new TabPane();
		turtleInfo.setPrefSize(TURTLELIST_WIDTH, TURTLELIST_HEIGHT);
						
		textInput = new TextArea();
		textInput.setPrefSize(INPUT_WIDTH, 95);
		textInput.setWrapText(true);
		inputScroll = new ScrollPane();
		inputScroll.hbarPolicyProperty().set(ScrollPane.ScrollBarPolicy.NEVER);
		inputScroll.setPrefSize(INPUT_WIDTH,95);
		inputScroll.setContent(textInput);
		inputHistory = new TextArea();
		inputHistory.setPrefSize(INPUT_WIDTH, 205);
		inputHistory.setWrapText(true);
		inputHistory.setEditable(false);
		historyScroll = new ScrollPane();
		historyScroll.hbarPolicyProperty().set(ScrollPane.ScrollBarPolicy.NEVER);
		historyScroll.setPrefSize(INPUT_WIDTH, 205);
		historyScroll.setContent(inputHistory);
		runButton = new Button("Run");
		
		inputVBox = new VBox(5);
		((VBox) inputVBox).getChildren().addAll(historyScroll,inputScroll,runButton);
		inputWindow = new Window("Input Your Code");
		setWindow(inputWindow,INPUT_WIDTH,INPUT_HEIGHT,5,0).getContentPane().getChildren().add(inputVBox);
		turtleInfoWindow = new Window("Turtle Information");
		setWindow(turtleInfoWindow,TURTLELIST_WIDTH,TURTLELIST_HEIGHT,INPUT_WIDTH+10,0).getContentPane().getChildren().add(turtleInfo);
			
		variablesText = new ListView<String>();
		variablesText.setPrefSize(LISTS_WIDTH, LISTS_HEIGHT);
		methodsText = new ListView<String>();
		methodsText.getItems().add("test method");
		methodsText.setPrefSize(LISTS_WIDTH, LISTS_HEIGHT);
		
		variablesWindow = new Window("Active Variables");
		setWindow(variablesWindow,LISTS_WIDTH,LISTS_HEIGHT,5,INPUT_HEIGHT+5).getContentPane().getChildren().add(variablesText);
		
		methodsWindow = new Window("User Defined Methods");
		setWindow(methodsWindow,LISTS_WIDTH,LISTS_HEIGHT,INPUT_WIDTH+10,INPUT_HEIGHT+5).getContentPane().getChildren().add(methodsText);
		
		paletteWindow = new Window("Palette");
		setWindow(paletteWindow,190,400,2*INPUT_WIDTH+15,0);
		
		windowCanvas = new Pane();
		windowCanvas.setPrefSize(RIGHTPANE_WIDTH, 600);
		windowCanvas.getChildren().addAll(inputWindow,turtleInfoWindow,variablesWindow,methodsWindow,paletteWindow);
				
		mainPane.setRight(windowCanvas);
		BorderPane.setMargin(windowCanvas, new Insets(20,10,0,0));
	}
	
	private Window setWindow(Window window,int width,int height,int startX,int startY) {
		window.setPrefSize(width, height);
		window.setLayoutX(startX);
		window.setLayoutY(startY);
		window.getLeftIcons().add(new MinimizeIcon(window));
		return window;
	}	
}