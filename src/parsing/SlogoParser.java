package parsing;

import java.util.regex.Pattern;
import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Enumeration;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;

/**
 * @author Peilin Lai
 *          Paul Lee
 */

public class SlogoParser {
	private List<Entry<String, Pattern>> mySymbols;
	private List<Entry<String, Pattern>> myCommands;
	private static final String[] conditional = new String[] { "Repeat", "DoTimes", "For", "If", "IfElse", "MakeUserInstruction"};
	private static final HashSet<String> cond = new HashSet<String>(Arrays.asList(conditional));
	//private HashSet<String> otherSymbols;
	
	/*private ArrayList<String> comms = new ArrayList<String>(Arrays.asList(
			"FORWARD", "FD", "BACK", "BK", "LEFT", "LT", "RIGHT", "RT",
			"SETHEADING", "SETH", "TOWARDS", "SETXY", "GOTO", "PENDOWN", "PD",
			"PENUP", "PU", "SHOWTURTLE", "ST", "HIDETURTLE", "HT", "HOME", "CLEARSCREEN",
			"CS", "XCOR", "YCOR", "HEADING", "PENDOWN?", "PENDOWNP", "SHOWING?", "SHOWINGP",
			"SUM", "DIFFERENCE", "PRODUCT", "QUOTIENT", "REMAINDER", "MINUS", "RANDOM",
			"SIN", "COS", "TAN", "ATAN", "LOG", "POW", "PI", "LESS?", "LESSP","GREATER?","GREATERP",
			"EQUAL?","EQUALP","NOTEQUAL?","NOTEQUALP", "AND", "OR", "NOT","MAKE","SET",
			"REPEAT", "DOTIMES","FOR", "FOR", "IF", "IFELSE", "TO"
			));*/

	
	public SlogoParser (){
        mySymbols = new ArrayList<>();
        this.addPatterns(myCommands, "resources/languages/English");
        this.addPatterns(mySymbols, "resources/languages/Syntax");
        //this.addOtherSyntax("Symbol.txt");
        //add as many Patterns as needed/exist
    }
	
	
	/*// add other syntax like "(" and ")"
	private void addOtherSyntax(String fileName) {
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while((line = bufferedReader.readLine()) != null) {
				otherSymbols.add(line);
			}
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("error in Slogo Parser"); 
        }
		catch(IOException ex) {
			System.out.println("error in Slogo Parser"); 
		}
	}*/

	public void addPatterns (List<Entry<String, Pattern>> myList, String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            myList.add(new SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
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
		else if (match(text, variables)) {
			return "Variable";
		}
		else if (match(text, commands)) {
			if (cond.contains(text)) {
				return "Conditional";
			}
			else return "Command";
		}
		else return text;
    }
	
	private boolean match (String text, Pattern regex) {
        return regex.matcher(text).matches();
    }

	public String getTranslation(String text) {
		for (Entry<String, Pattern> e : mySymbols) {
            if (match(text, e.getValue())) {
            		if (!(e.getKey().equalsIgnoreCase("Constant") || e.getKey().equalsIgnoreCase("Command") || e.getKey().equalsIgnoreCase("Variable")))
            			e.getKey();
            		else return text;
            }
        }
		return "error message";
	}
}
