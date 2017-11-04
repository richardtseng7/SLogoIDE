package parsing;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import expression.Executor;
import model.commands.Command;
import model.turtle.Turtle;

/**
 * @author Paul Lee
 */

public class Factory {
	private static Command theCommand;
	private String myType;
	public Factory(String type) {
		myType = type;

	}
	
	public Object setArgs(Object[] args){
		return doClass(myType, args);
	}
	
	private Object doClass(String type, Object[] args) {
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
                    params[i] = Double.TYPE;
                } else if (args[i] instanceof Boolean) {
                    params[i] = Boolean.TYPE;
                } else if (args[i] instanceof ArrayList){
                	params[i] = ArrayList.class;
                } else if (args[i] instanceof Executor){
                	params[i] = Executor.class;
                }
            }
            Class<?> cls = Class.forName("model.commands." + type);
            Object _instance = cls.newInstance(); 
            Method myMethod = cls.getDeclaredMethod("execute", params);
            Object val = myMethod.invoke(_instance, args);
            
        	return val;
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
