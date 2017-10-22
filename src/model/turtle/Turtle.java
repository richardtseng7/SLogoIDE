package model.turtle;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

/**
 * @author richardtseng
 *
 */
public class Turtle {
	
	private ImageView myImageView;
	private static final String TURTLE_IMAGE = "Turtle_Slogo.png";
	private Point2D myPos;
	private Point2D home;
	
	public Turtle() {
		
		myPos = home;
	}
	

	public Point2D getPos() {
		return this.myPos;
	}	
	
	public int show() {
		
		return 1;
	}
	
	public int hide() {
		
		return 0;
	}
}