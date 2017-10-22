package parsing;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Peilin Lai
 */

public class Factory {
	private Object theCommand;
	private static Method method;
	// for all commands, should take in 2 integers as parameters, okay not to use them
	private int[] parameter = new int[2];
	
	public Factory(String type) {
		theCommand = makeClass(type);
	}
	
	private static Object makeClass(String type) {
		Class<?>[] paramInt = new Class[2];
		paramInt[0] = Integer.TYPE;
		paramInt[1] = Integer.TYPE;
		
        try {
        		Class<?> clazz = Class.forName("parsing.ExpressiontTree");
        		Constructor<?> ctor = clazz.getDeclaredConstructor(String.class);
            Object o = ctor.newInstance(type);
            method = clazz.getDeclaredMethod("execute", paramInt);
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
	
	public void setParameter(int[] para) {
		parameter = para;
	}
	
	public void doExecution() {
		try {
			method.invoke(theCommand, parameter);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// return error
			e.printStackTrace();
		}
	}
}
