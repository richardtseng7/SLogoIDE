package model.turtle;

/**
 * @author richardtseng
 *
 */
public class Canvas {
	int background = 0;
	int palette = 0;
	
	public Canvas() {
		
	}
	
	public int getBackground(){
		return background;
	}
	
	public int getPalette(){
		return palette;
	}
	
	public void setBackground(int index){
		background = index;
	}
	
	public void setPalette(int index){
		palette = index;
	}
}