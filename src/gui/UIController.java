package gui;
import logic.LogicCenter;
import model.turtle.Turtle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class UIController {
	
	public double FRAMES_PER_SECOND = 1;
	public double MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public double SECOND_DELAY = 100.0/ FRAMES_PER_SECOND;
	
	private Scene Scene;
	private Group root = new Group();
	private GUI gui;
	private LogicCenter lc;
	private Timeline animation = new Timeline();
	private KeyFrame frame;
	private int turtleID = 0;
	
	public UIController (int width, int height, Paint background) {
		frame  = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> this.step(SECOND_DELAY));
		
	    animation.setCycleCount(Timeline.INDEFINITE);
	    animation.getKeyFrames().add(frame);
	     
		Scene = new Scene(root, width, height, background);
		gui = new GUI();
		Turtle t = new Turtle(turtleID++, gui.canvasDimension);
		gui.canvasPane.getChildren().add(t.getImageView());
		
		lc = new LogicCenter();
		root.getChildren().addAll(gui.mainPane);
		
		initRunButton();
	}
	
	public void step(double elapsedTime) {
		
	}
	
	private void initRunButton() {
		gui.runButton.setOnAction((event) -> {
			String input  = gui.textInput.getText();
			lc.doInstructions(input);
			gui.inputHistory.appendText(input + "\n");
			//Send string input to Parser
			gui.textInput.clear();
		});
	}

	public javafx.scene.Scene getScene() {
		return Scene;
	}
}
