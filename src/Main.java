import gui.UIController;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application{
	public static final String TITLE = "SLogo";
	public static final int HEIGHT = 600;
	public static final int WIDTH = 1000;
	public static final Paint BACKGROUND = Color.CADETBLUE;
	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	
	@Override
	public void start (Stage s) {
		UIController myScene = new UIController(WIDTH,HEIGHT,BACKGROUND);
		s.setScene(myScene.getScene());
		s.setTitle(TITLE);
		s.show();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
}