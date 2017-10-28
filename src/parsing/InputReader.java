package parsing;
import java.util.ArrayList;

/**
 * @author Peilin Lai
 */

// With a trained SlogoParser and user input, an InputReader gives an ArrayList of input strings in standardized slogo language
public class InputReader {
	private ArrayList<String> inputParsed;
	//inputParsedSymbols translates all constants in inputParsed into "Constant" symbols
	private ArrayList<String> inputParsedSymbols;
	private ArrayList<Integer> bracketOrder;
	private ArrayList<Integer> brackets;
	private ArrayList<Boolean> indexWarning;
	
	public InputReader (SlogoParser lang, String input) {
		String WHITESPACE = "\\s+";
		parseText(lang, input.split(WHITESPACE));
		calcBracketOrder();
		checkWarning();
		//cleanParsing will shorten the ArrayLists
		cleanParsing();
        //String userInput = "fd 50 rt 90 BACK :distance Left :angle";
        //String fileInput = readFileToString("/square.logo");
        //parseText(lang, fileInput.split(WHITESPACE));
    }

	// given some text, prints results of parsing it using the given language
    private void parseText (SlogoParser lang, String[] text) {
        for (String s : text) {
            if (s.trim().length() > 0) {
            		//translate user input to standardized language for slogo and store in an arraylist
            		String translation = lang.getTranslation(s);
            		inputParsed.add(translation);
            		inputParsedSymbols.add(lang.getSymbol(translation));
            }
        }
    }
    
    private void calcBracketOrder() {
    		int order = 0;
    		for (int i = 0; i<inputParsed.size(); i++) {
    			if (inputParsed.get(i).equals("ListStart")) {
    				order ++;
    				brackets.add(i);
    			}
    			else if (inputParsed.get(i).equals("ListEnd")) {
    				order--;
    				brackets.add(i);
    			}
    			if (order<0) {
    				//call error message: "error: unmatching brackets";
    			}
    			bracketOrder.add(order);
    			indexWarning.add(false);
    		}
    		if (order != 0) {
    			//call error message: "error: unmatching brackets";
    		}
    }
    
    private void checkWarning() {
    		for (int i = 0; i<brackets.size(); i++) {
    			if (brackets.get(i) == brackets.get(i+1)-1) {
    				indexWarning.set(brackets.get(i)-1, true);
    			}
    		}
    }
    
    private void cleanParsing() {
		for (int i = brackets.size()-1; i>= 0; i--) {
			int index = brackets.get(i);
			inputParsed.remove(index);
			inputParsedSymbols.remove(index);
			bracketOrder.remove(index);
			indexWarning.remove(index);
		}
	}

	public ArrayList<String> getInputParsed() {
		return this.inputParsed;
	}

	public ArrayList<String> getInputParsedSymbols() {
		return this.inputParsedSymbols;
	}
	
	public ArrayList<Integer> getInputParsedType() {
		return this.bracketOrder;
	}
	
	
	//the special case where a ending bracket touches a starting bracket
	public ArrayList<Boolean> getInputParsedBounds() {
		return this.indexWarning;
	}
    
    // utility function that reads given file and returns its entire contents as a single string
    /*private String readFileToString (String filename) {
        final String END_OF_FILE = "\\z";
        Scanner input = new Scanner(getClass().getResourceAsStream(filename));
        input.useDelimiter(END_OF_FILE);
        String result = input.next();
        input.close();
        return result;
    }*/
}
