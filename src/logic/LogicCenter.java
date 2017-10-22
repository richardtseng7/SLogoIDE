package logic;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import parsing.InputReader;
import parsing.SlogoParser;

/**
 * @author Peilin Lai
 *          Paul Lee
 */

public class LogicCenter {	
	private SlogoParser lang;
	
	public LogicCenter() {
		lang = new SlogoParser();
	}

	public void doInstructions(String input) {
		//first parse instructions
		InputReader reader = new InputReader(lang, input);
		ArrayList<String> inputParsed = reader.getInputParsed();
		if(inputParsed!= null && inputParsed.size()!=0){ //Prevent crash from no commands typed.
			System.out.println(inputParsed.toString());
			ArrayList<String> inputParsedSymbols = reader.getInputParsedSymbols();
			System.out.println(inputParsedSymbols.toString());
			doLogic(inputParsed, inputParsedSymbols);
		}
	}

	private void doLogic(ArrayList<String> inputParsed, ArrayList<String> inputParsedSymbols) {
		int index = 0; //used to keep track of the current reading from both ArrayLists
		// loop through inputParsedSymbols, if .equals("Command"), build a Factory object
		String errorMessage = checkSyntax(inputParsedSymbols);
		if(errorMessage == ""){
			for(int i = 0; i < inputParsed.size(); i++){
				//Dologic body
			}
		}
		else{
			//Popup with error message
			JOptionPane.showMessageDialog(null, errorMessage, "Syntax Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	
	private String checkSyntax(ArrayList<String> inputParsedSymbols){
		for(String s : inputParsedSymbols){
			if(s == "Syntax Error - Command Not Found" || s == "Syntax Error - Missing Space"){
				return s;
			}
			
		}
		return "";
	}
}
