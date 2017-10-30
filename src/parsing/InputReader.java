package parsing;
import java.util.ArrayList;

/**
 * @author Peilin Lai
 * Paul Lee
 */

// With a trained SlogoParser and user input, an InputReader gives an ArrayList of input strings in standardized slogo language
public class InputReader {
	private ArrayList<String> inputParsed = new ArrayList<String>();
	//inputParsedSymbols translates all constants in inputParsed into "Constant" symbols
	private ArrayList<String> inputParsedSymbols = new ArrayList<String>();
	private ArrayList<Integer> bracketOrder = new ArrayList<Integer>();
	private ArrayList<Integer> brackets = new ArrayList<Integer>();
	private ArrayList<Boolean> indexWarning = new ArrayList<Boolean>();
	
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
            		//System.out.println(translation);
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
    
}
