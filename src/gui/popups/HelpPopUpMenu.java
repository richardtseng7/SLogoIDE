package gui.popups;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JTextArea;
import javafx.scene.layout.Pane;

/**
 * 
 * @author nathanlewis
 *
 */

public class HelpPopUpMenu extends PopUpScene {

	@Override
	protected Pane setUpPane() {
		Pane popUp = new Pane();
		JTextArea textInput = new JTextArea();
		try{
			FileReader reader = new FileReader("textHelp.txt");
			BufferedReader br = new BufferedReader(reader);
			textInput.read(br, null);
			br.close();
			textInput.requestFocus();
		}
		catch(Exception ex) { }
		return popUp;
	}

	@Override
	protected String stageTitle() {
		return new String("Help Menu");
	}

}
