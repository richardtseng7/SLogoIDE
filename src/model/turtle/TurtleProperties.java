package model.turtle;

import java.util.HashMap;
import java.util.Map;

public class TurtleProperties {
	
	protected static final int TURTLE_SIZE = 30;
	protected Map<Integer, String> turtleImages;
	protected static final String IMAGE1 = "Turtle_Slogo.png";
	protected static final String IMAGE2 = "Turtle 2.png";
	protected static final String IMAGE3 = "Turtle 3.png";
	
	public TurtleProperties(){
		initializeImageMap();
	}
	
	public void initializeImageMap() {
		turtleImages = new HashMap<>();
		turtleImages.put(1, IMAGE1);
		turtleImages.put(2, IMAGE2);
		turtleImages.put(3, IMAGE3);
	}
}