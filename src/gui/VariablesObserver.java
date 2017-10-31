package gui;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.ListView;

/**
 * 
 * @author nathanlewis
 *
 */

public class VariablesObserver implements Observer {
	
	private ListView<String> variablesList;
	
	public VariablesObserver(ListView<String> list) {
		variablesList = list;
	}

	@Override
	public void update(Observable o, Object arg) {
		variablesList.getItems().clear();
		for(Entry<String, Double> entry : ((HashMap<String,Double>) arg).entrySet()) {
			variablesList.getItems().add(entry.getKey().replaceAll(":", "") + ":" + entry.getValue());
		}
	}

}
