package reflection;

import java.lang.reflect.Constructor;

public class Factory {
	private Object theCommand;
	
	public Factory(String type) {
		theCommand = makeClass(type);
	}

	private Object makeClass(String type) {
		try {
        		Class<?> clazz = Class.forName("Command");
        		Constructor<?> ctor = clazz.getDeclaredConstructor(String.class);
            Object o = ctor.newInstance(type);
            return o;
        } catch (Exception e) {
            // print error message saying command is invalid
        		return null; 
        }
	}
	
	public Object getCommand() {
		return theCommand;
	}
}