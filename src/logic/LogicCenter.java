package logic;
import java.util.ArrayList;

import parsing.InputReader;
import parsing.SlogoParser;

public class LogicCenter {	
	private SlogoParser lang;
	
	public LogicCenter() {
		lang = new SlogoParser();
	}

	public void doInstructions(String input) {
		//first parse instructions
		InputReader reader = new InputReader(lang, input);
		ArrayList<String> inputParsed = reader.getInputParsed();
		System.out.println(inputParsed.toString());
		ArrayList<String> inputParsedSymbols = reader.getInputParsedSymbols();
		System.out.println(inputParsedSymbols.toString());
		doLogic(inputParsed, inputParsedSymbols);
	}

	private void doLogic(ArrayList<String> inputParsed, ArrayList<String> inputParsedSymbols) {
		int index = 0; //used to keep track of the current reading from both ArrayLists
		// loop through inputParsedSymbols, if .equals("Command"), build a Factory object
	}
}