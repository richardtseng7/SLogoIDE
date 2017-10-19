import java.util.ArrayList;

import parsing.InputReader;
import parsing.SlogoParser;

public class LogicCenter {	
	private SlogoParser lang;
	private InputReader reader;
	private ArrayList<String> inputParsed;
	private ArrayList<String> inputParsedSymbols;
	
	public LogicCenter(String input) {
		lang = new SlogoParser();
		reader = new InputReader(lang, input);
		inputParsed = reader.getInputParsed();
		inputParsedSymbols = reader.getInputParsedSymbols();
		
		doLogic(inputParsed, inputParsedSymbols);
	}

	private void doLogic(ArrayList<String> inputParsed2, ArrayList<String> inputParsedSymbols2) {
		
	}
}
