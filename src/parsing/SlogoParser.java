package parsing;

import gui.popups.ErrorPopUp;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
	private List<Entry<String, Pattern>> mySymbols = new ArrayList<Entry<String, Pattern>>();
	private Map<String, String> myCommands = new TreeMap<String, String>();
	private static final String[] conditional = new String[] { "Repeat", "DoTimes", "For", "If", "IfElse", "MakeUserInstruction"};
	private static final HashSet<String> cond = new HashSet<String>(Arrays.asList(conditional));
	public SlogoParser (){
        mySymbols = new ArrayList<>();
        myCommands.putAll(createLanguageMap("resources/languages/English"));
        //System.out.println(myCommands.toString());
    }
	
	
	private Map<String, String> createLanguageMap(String string) {
		
		HashMap<String, String> langMap = new HashMap<String, String>();
		ResourceBundle resources = ResourceBundle.getBundle(string);
		//System.out.println(resources.keySet().toString());
		for (String key : resources.keySet()) {
			if (resources.getString(key).contains("|")) {
				String[] allTrans = resources.getString(key).split("\\|");
				for (String indiTrans : allTrans) {
					//System.out.println(indiTrans);
					String s = indiTrans.trim();
					s = s.replaceAll("\\\\", "");
					s = s.replaceAll("\\?", "");
					langMap.put(s, key);
				}
			}
			else langMap.put(resources.getString(key).trim(), key);
		}
		return langMap;
	}
	
	public String getSymbol (String text) {
        //for (Entry<String, Pattern> e : mySymbols) {
		
		Pattern constants = Pattern.compile("[-+]?\\d*\\.?\\d+");
		Pattern commands = Pattern.compile("[a-zA-Z_]+(\\\\?)?|[*+-/%~]");
		Pattern variables = Pattern.compile(":[a-zA-Z]+");
		if (match(text, commands)) {
			if (containCond(cond, text)) {
				return "Conditional";
			}
			else return "Command";
		}
		else if (match(text, constants)) {
			return "Constant";
		}
		else if (match(text, variables)) {
			return "Variable";
		}

		else return text;
    }
	
	private boolean containCond(HashSet<String> cond2, String text) {
		Iterator<String> it = cond2.iterator();
	    while(it.hasNext()) {
	    		if (it.next().equalsIgnoreCase(text))
	    			return true;
	    }
		return false;
	}

	private boolean match (String text, Pattern regex) {
        return regex.matcher(text).matches();
    }

	public String getTranslation(String text) {
		text = text.toLowerCase();
		ArrayList<Entry<String, String>> commandList = new ArrayList<Entry<String,String>>();
		for(String s: myCommands.keySet()){
			commandList.add(new SimpleEntry<String, String>(s, myCommands.get(s)));
		}
		
		for (Entry<String, String> e : commandList) {
			if(e.getKey().equals(text)){
				return e.getValue();
			}
			else if(text.matches("[-+]?\\d*\\.?\\d+") || text.equals("[") || text.equals("]")){
				return text;
			}
        }
        ErrorPopUp error = new ErrorPopUp("Input Unrecognizable");
		error.showPopUp();
		return "error";
	}
}
