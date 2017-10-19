package parsing;

import java.util.regex.Pattern;
import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Enumeration;
import java.util.AbstractMap.SimpleEntry;

public class SlogoParser {
	private List<Entry<String, Pattern>> mySymbols;

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
		if (match(text, constants)) {
                return "Constant";
		}
		else return text;
    }
	
	private boolean match (String text, Pattern regex) {
        return regex.matcher(text).matches();
    }

	public String getTranslation(String text) {
		final String ERROR = "NO MATCH";
		for (Entry<String, Pattern> e : mySymbols) {
            if (match(text, e.getValue())) {
            		if (e.getKey().equalsIgnoreCase("Constant"))
            			return text;
            		else return e.getKey();
            }
        }
		return ERROR;
	}
}
