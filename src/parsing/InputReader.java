package parsing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Peilin Lai
 * Paul Lee
 */

// With a trained SlogoParser and user input, an InputReader gives an ArrayList of input strings in standardized slogo language
public class InputReader {
	private ArrayList<String> inputParsed = new ArrayList<String>();
	//inputParsedSymbols translates all constants in inputParsed into "Constant" symbols
	private ArrayList<String> inputParsedSymbols = new ArrayList<String>();
	//private ArrayList<Integer> bracketOrder;// = new ArrayList<Integer>();
	private ArrayList<Integer> brackets = new ArrayList<Integer>();
	private ArrayList<Integer> layers = new ArrayList<Integer>();
	
	public InputReader (SlogoParser lang, String input) {
		String WHITESPACE = "\\s+";
		parseText(lang, input.toLowerCase().split(WHITESPACE));
		for(int i = 0; i<inputParsed.size()-countnonBracket(); i++){
			brackets.add(0);
			layers.add(0);
		}
		calcBracketOrder(0);
		createLayers();
    }
	
	private void createLayers(){
		int counter = 0;
		for(int i = 0; i<brackets.size(); i++){
			layers.set(i, counter);
			counter += brackets.get(i);
		}
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
    
    private void calcBracketOrder(int index) {
    		int order = 0;
    		int countafterbrackets = countnonBracket();
    		int limit =inputParsed.size()- countafterbrackets;
    		if(inputParsed.get(index).equals("[")){
    			inputParsed.remove(index);
    			inputParsedSymbols.remove(index);
    			brackets.set(index - 1, 1);
    			if(index == limit) {return;}
    			calcBracketOrder(index);
    		}
    		else if(inputParsed.get(index).equals("]")){
    			inputParsed.remove(index);
    			inputParsedSymbols.remove(index);
    			brackets.set(index - 1, -1);
    			if(index == limit) {return;}
    			calcBracketOrder(index);
    		}
    		else{
    			if(index < limit && inputParsed.size() > limit) calcBracketOrder(index+1);
    		}
    }
    
    
    private int countnonBracket(){
    	int count = 0;
    	for(String s: inputParsed){
    		if(s.equals("[") || s.equalsIgnoreCase("]")){
    			count++;
    		}
    	}
    	return count;
    }
    

	public ArrayList<String> getInputParsed() {
		return this.inputParsed;
	}

	public ArrayList<String> getInputParsedSymbols() {
		return this.inputParsedSymbols;
	}
	
	public ArrayList<Integer> getInputParsedType() {
		return this.layers;
	}
	
	
	//the special case where a ending bracket touches a starting bracket
	public ArrayList<Integer> getInputParsedBounds() {
		return this.brackets;
	}
    
}
