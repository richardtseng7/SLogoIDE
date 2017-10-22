package parsing;

import java.lang.reflect.Constructor;

public class Factory {
	private Object theCommand;
	
	public Factory(String type) {
		theCommand = makeClass(type);
	}
	
	private static Object makeClass(String type) {
        try {
        		//Class<?> clazz = Class.forName("java.lang.String");
        		//Constructor<?> ctor = clazz.getDeclaredConstructor(String.class);
            //Object o = ctor.newInstance(type);
        		Object o = Class.forName(type).newInstance();
        		return o;
        } catch (Exception e) {
            e.printStackTrace();
            // return some sort of error
        }
		return null;
	}

	public Object getCommand() {
		return theCommand;
	}
}
