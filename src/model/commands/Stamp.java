package model.commands;

import javafx.scene.image.ImageView;
import model.turtle.Turtle;

public class Stamp extends Command{
	public double execute(Turtle t) {		
		ImageView i = t.createImageView(	t.getImageMap().get(t.getShape()),
										t.getPos().getX(), 
										t.getPos().getY(),
										t.getHeading() - 90.0);
		t.getGroup().getChildren().add(i);
		return t.getShape();
	}
	
	@Override
	public int getNumParam() {
		return 0;
	}
}