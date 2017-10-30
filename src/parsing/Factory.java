package parsing;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import model.commands.Command;
import model.turtle.Turtle;

/**
 * @author Peilin Lai
 */

public class Factory {
	private static Command theCommand;
	private String myType;
	public Factory(String type) {
		myType = type;

	}
	
	public void setArgs(Object[] args){
		theCommand = makeClass(myType, args);
	}
	
	private static Command makeClass(String type, Object[] args) {
        try {
            Class<?> params[] = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Integer) {
                    params[i] = Integer.TYPE;
                } else if (args[i] instanceof String) {
                    params[i] = String.class;
                } else if (args[i] instanceof Turtle) {
                    params[i] = Turtle.class;
                } else if (args[i] instanceof Double) {
                    params[i] = Double.class;
                } else if (args[i] instanceof Boolean) {
                    params[i] = Boolean.class;
                }
            }
            Class<?> cls = Class.forName("model.commands." + type);
            Object _instance = cls.newInstance();
            Method myMethod = cls.getDeclaredMethod("execute", params);
            myMethod.invoke(_instance, args);
            
        	return null;
        } catch (Exception e) {
            e.printStackTrace();
            // return some sort of error
        }
		return null;
	}

	public Command getCommand() {
		return theCommand;
	}
	
	public int numComs(){
		try{
			//System.out.println("model.commands." + myType);
	        Class<?> cls = Class.forName("model.commands." + myType);
	        Object _instance = cls.newInstance();
	        Method myMethod = cls.getDeclaredMethod("getNumParam");
	        Object val = myMethod.invoke(_instance);
	        return (int) val;
		}
		catch(Exception ex){ 
			ex.printStackTrace();
			return -1;
		}
	}
}
