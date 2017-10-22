package parsing;

import java.util.regex.Pattern;
import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Enumeration;
import java.util.AbstractMap.SimpleEntry;

/**
 * @author Peilin Lai
 *          Paul Lee
 */

public class SlogoParser {
	private List<Entry<String, Pattern>> mySymbols;
	private ArrayList<String> comms = new ArrayList<String>(Arrays.asList(
			"FORWARD", "FD", "BACK", "BK", "LEFT", "LT", "RIGHT", "RT",
			"SETHEADING", "SETH", "TOWARDS", "SETXY", "GOTO", "PENDOWN", "PD",
			"PENUP", "PU", "SHOWTURTLE", "ST", "HIDETURTLE", "HT", "HOME", "CLEARSCREEN",
			"CS", "XCOR", "YCOR", "HEADING", "PENDOWN?", "PENDOWNP", "SHOWING?", "SHOWINGP",
			"SUM", "DIFFERENCE", "PRODUCT", "QUOTIENT", "REMAINDER", "MINUS", "RANDOM",
			"SIN", "COS", "TAN", "ATAN", "LOG", "POW", "PI", "LESS?", "LESSP","GREATER?","GREATERP",
			"EQUAL?","EQUALP","NOTEQUAL?","NOTEQUALP", "AND", "OR", "NOT","MAKE","SET",
			"REPEAT", "DOTIMES","FOR", "FOR", "IF", "IFELSE", "TO"
			));

	
	public SlogoParser () {
        mySymbols = new ArrayList<>();
        this.addPatterns("resources/languages/English");
        this.addPatterns("resources/languages/Syntax");
        //add as many Patterns as needed/exist
    }
	
	public void addPatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            mySymbols.add(new SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }
	
	public String getSymbol (String text) {
        //for (Entry<String, Pattern> e : mySymbols) {
		
		Pattern constants = Pattern.compile("-?[0-9]+\\\\.?[0-9]*");
		Pattern commands = Pattern.compile("[a-zA-Z_]+(\\\\?)?|[*+-/%~]");
		Pattern variables = Pattern.compile(":[a-zA-Z]+");
		if (match(text, constants)) {
			return "Constant";
		}
		else if (match(text, commands)) {
			if(comms.contains(text)){
				return "Command";
			}
			else { return "Syntax Error - Command Not Found";}
		}
		else if (match(text, variables)) {
			return "Variable";
		}
		else return "Syntax Error - Missing Space";
    }
	
	private boolean match (String text, Pattern regex) {
        return regex.matcher(text).matches();
    }

	public String getTranslation(String text) {
		final String ERROR = "NO MATCH";
		for (Entry<String, Pattern> e : mySymbols) {
            if (match(text, e.getValue())) {
            		if (e.getKey().equalsIgnoreCase("Constant") || e.getKey().equalsIgnoreCase("Command") || e.getKey().equalsIgnoreCase("Variable"))
            			return text;
            		else return e.getKey();
            }
        }
		return ERROR;
	}
}
