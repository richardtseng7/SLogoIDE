package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import model.Model;

/**
 * 
 * @author nathanlewis
 *
 */

public class TurtleInfoTabs {
	
	protected List<Tab> tabList;
	private ListView<String> infoList;
	
	public TurtleInfoTabs(Model m) {
		tabList = new ArrayList<Tab>();
		for(int i=1; i < (m.getTurtles().size()+1); i++) {
			Tab tab = new Tab();
			tab.setText("Turtle "+i);
			infoList = new ListView<String>();
			infoList.setPrefSize(GUI.TURTLELIST_WIDTH, 120);
			infoList.getItems().add("ID: " + i);
			infoList.getItems().add("Position:");
			infoList.getItems().add("x - " + m.getTurtle(i).getXCor());
			infoList.getItems().add("y - " + (-m.getTurtle(i).getYCor()));
			infoList.getItems().add("Heading: " + m.getTurtle(i).getHeading());
			tab.setContent(infoList);
			tabList.add(tab);
		}
	}
	
}
