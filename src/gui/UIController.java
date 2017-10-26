package gui;
import logic.LogicCenter;
import model.Model;
import model.turtle.Turtle;
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
	
	public double FRAMES_PER_SECOND = 1;
	public double MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public double SECOND_DELAY = 100.0/ FRAMES_PER_SECOND;
	
	private Scene Scene;
	private Group root = new Group();
	private GUI gui;
	private CanvasColorPopUp canvasPop;
	private TurtleImagePopUp turtlePop;
	private PenColorPopUp penPop;
	private TurtleInfoTabs turtleTab;
	private LogicCenter lc;
	private Timeline animation = new Timeline();
	private KeyFrame frame;
	private int turtleID = 0;
	private Model m;
	private Point2D originalPos;
	
	public UIController() {
		
	}
	
	public UIController (int width, int height, Paint background) {
		frame  = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> this.step(SECOND_DELAY));
		
	    animation.setCycleCount(Timeline.INDEFINITE);
	    animation.getKeyFrames().add(frame);
	     
		Scene = new Scene(root, width, height, background);
		gui = new GUI();
		
		m = new Model(gui.canvasDimension);
		for (int i = 0; i < 1; i++) {
			m.addTurtle();
			gui.canvasPane.getChildren().add(m.getTurtle(i).getImageView());
			System.out.println(m.getTurtle(0).getID());
		}
		
		lc = new LogicCenter();
		root.getChildren().addAll(gui.mainPane);
		
		initRunButton();
		
		turtleTab = new TurtleInfoTabs(m);
		for(Tab tab:turtleTab.tabList) {
			gui.turtleInfo.getTabs().add(tab);
		}
			
		gui.canvasColor.setOnAction((event) -> {
			canvasPop = new CanvasColorPopUp();
			canvasPop.showPopUp();
			initCanvasColorPicker();
		});
		gui.turtleImage.setOnAction((event) -> {
			turtlePop = new TurtleImagePopUp();
			turtlePop.setTurtleSelection(m);
			turtlePop.showPopUp();
			initTurtleImagePick();
		});
		gui.penColor.setOnAction((event) -> {
			penPop = new PenColorPopUp();
			penPop.showPopUp();
		});
	}
	
	public void step(double elapsedTime) {
		
	}
	
	private void initCanvasColorPicker() {
		canvasPop.colorPicker.setOnAction((event) ->{
			((Rectangle) gui.canvas).setFill(canvasPop.colorPicker.getValue());
		});
	}
	
	private void initPenColorPicker() {
		penPop.colorPicker.setOnAction((event) ->{
			
		});
	}
	
	private void initTurtleImagePick() {
		turtlePop.turtle1.setOnAction((event) -> {
			m.getTurtle(0).getImageView().setImage(new Image(getClass().getClassLoader().getResourceAsStream(TurtleImagePopUp.DEFAULT_IMAGE)));
		});
		turtlePop.turtle2.setOnAction((event) -> {
			m.getTurtle(0).getImageView().setImage(new Image(getClass().getClassLoader().getResourceAsStream(TurtleImagePopUp.IMAGE2)));
		});
		turtlePop.turtle3.setOnAction((event) -> {
			m.getTurtle(0).getImageView().setImage(new Image(getClass().getClassLoader().getResourceAsStream(TurtleImagePopUp.IMAGE3)));
		});
	}
	
	private void initRunButton() {
		gui.runButton.setOnAction((event) -> {
			String input  = gui.textInput.getText();
			//lc.doInstructions(input);
			gui.inputHistory.appendText(">"+input + "\n");
			//Send string input to Parser
			gui.textInput.clear();
		});
	}
	
	public void storeOriginalPos(Turtle t) {
		originalPos = t.getPos();
	}
	
	public void updateScene(Turtle t) {
		Line penLine = new Line(t.getPos().getX(),t.getPos().getY(), originalPos.getX(), originalPos.getY());
		t.getImageView().setX(t.getPos().getX());
		t.getImageView().setY(t.getPos().getY());
		gui.canvasPane.getChildren().add(penLine);
		
	}
	
	protected void updateImage(String fileName) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(fileName));
		m.getTurtle(0).getImageView().setImage(image);
		//Will need to change iterate over all turtles
	}

	public javafx.scene.Scene getScene() {
		return Scene;
	}
}
