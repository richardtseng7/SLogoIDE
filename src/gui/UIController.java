package gui;
import logic.LogicCenter;
import model.Model;
import model.turtle.Turtle;

import java.awt.Desktop;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import gui.popups.CanvasColorPopUp;
import gui.popups.PenColorPopUp;
import gui.popups.TurtleImagePopUp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class UIController {
	
	private static final String url = "https://www.cs.duke.edu/courses/compsci308/fall17/assign/03_slogo/commands.php";
	public double FRAMES_PER_SECOND = 1;
	public double MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public double SECOND_DELAY = 100.0/ FRAMES_PER_SECOND;
	private Scene Scene;
	private Group root = new Group();
	private GUI gui;
	private List<GUI> guiManager;
	private CanvasColorPopUp canvasPop;
	private TurtleImagePopUp turtlePop;
	private PenColorPopUp penPop;
	private TurtleInfoTabs turtleTab;
	private LogicCenter lc;
	private Timeline animation = new Timeline();
	private KeyFrame frame;
	private Model m;
	private Point2D originalPos;
	private TurtleObserver turtleObs;
	private Canvas c;
	
	public UIController (int width, int height, Paint background) {
		frame  = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> this.step(SECOND_DELAY));
		
	    animation.setCycleCount(Timeline.INDEFINITE);
	    animation.getKeyFrames().add(frame);    
		Scene = new Scene(root, width, height, background);
		gui = new GUI();
		m = new Model(gui.canvasDimension);
		c = new Canvas(m, gui.canvasPane, gui.canvas);	
		m.addTurtle();
		gui.canvasPane.getChildren().add(m.getTurtle(1).getImageView());		
		lc = new LogicCenter();
		turtleObs = new TurtleObserver(m, c);		
		m.getTurtle(1).getPosObservable().addObserver(turtleObs);
		m.getTurtle(1).getPen().getColorObservable().addObserver(c);

		//root.getChildren().add(gui.toolbar);
		root.getChildren().addAll(gui.mainPane);
		initRunButton();
		
		initHelpButton();
		
		initAddTurtleButton();
		updateTurtleTabs();

		gui.canvasColor.setOnAction((event) -> {
			canvasPop = new CanvasColorPopUp();
			canvasPop.showPopUp();
			canvasPop.setPickerEvent((Rectangle) gui.canvas);
		});
		
		gui.turtleImage.setOnAction((event) -> {
			turtlePop = new TurtleImagePopUp();
			turtlePop.setTurtlePopUp(m);
			turtlePop.showPopUp();
		});
		
		gui.penColor.setOnAction((event) -> {
			penPop = new PenColorPopUp();
			penPop.showPopUp();
		});
	}

	private void initAddTurtleButton() {
		gui.addTurtle.setOnAction((event) -> {
			m.addTurtle();
			gui.canvasPane.getChildren().add(m.getTurtle(m.getTurtles().size()).getImageView());
			updateTurtleTabs();
		});
	}

	private void updateTurtleTabs() {
		turtleTab = new TurtleInfoTabs(m);
		gui.turtleInfo.getTabs().clear();
		for(Tab tab:turtleTab.tabList) {
			gui.turtleInfo.getTabs().add(tab);
		}
	}
	
	public void step(double elapsedTime) {
		
	}
	
	private void initRunButton() {
		gui.runButton.setOnAction((event) -> {
			String input  = gui.textInput.getText();
			lc.doInstructions(input,m);
			gui.inputHistory.appendText(">"+input + "\n");
			//Send string input to Parser
			gui.textInput.clear();
			updateTurtleTabs();
		});
	}
	
	private void initHelpButton() {
		gui.helpButton.setOnAction((event) -> {
			try {
			    Desktop.getDesktop().browse(new URL(url).toURI());
			} catch (Exception e) {}
		});
	}
	
	public void storeOriginalPos(Turtle t) {
		originalPos = t.getPos();
	}

	public javafx.scene.Scene getScene() {
		return Scene;
	}
	
	public Model getModel() {
		return m;
	}
	
	public Canvas getCanvas() {
		return c;
	}
}
