package logic;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import parsing.InputReader;
import parsing.SlogoParser;
import expression.Executor;
import expression.ExpressionTree;

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
			ArrayList<Integer> inputParsedType = reader.getInputParsedType();
			ArrayList<Boolean> inputParsedBounds = reader.getInputParsedBounds();
			System.out.println(inputParsedSymbols.toString());
			doLogic(inputParsed, inputParsedSymbols, inputParsedType, inputParsedBounds);
		}
	}

	private void doLogic(ArrayList<String> inputParsed, ArrayList<String> inputParsedSymbols, ArrayList<Integer> inputParsedType, ArrayList<Boolean> inputParsedBounds) {
		Executor tree = new Executor(inputParsed, inputParsedSymbols, inputParsedType, inputParsedBounds);
	}
}
