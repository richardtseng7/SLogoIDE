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
	
	public InputReader (SlogoParser lang, String input) {
		String WHITESPACE = "\\s+";
		parseText(lang, input.split(WHITESPACE));
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

	public ArrayList<String> getInputParsed() {
		return this.inputParsed;
	}

	public ArrayList<String> getInputParsedSymbols() {
		return this.inputParsedSymbols;
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
