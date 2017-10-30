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
	
	//private static Method method;
	//for all commands, should take in 2 integers as parameters, okay not to use them
	//private int[] parameter = new int[2];
	//private static int numofpm = 0;
	public Factory(String type) {
		myType = type;

	}
	
	public void setArgs(Object[] args){
		theCommand = makeClass(myType, args);
	}
	
	private static Command makeClass(String type, Object[] args) {
		//Class<?>[] paramInt = new Class[2];
		//paramInt[0] = Integer.TYPE;
		//paramInt[1] = Integer.TYPE;
		//Class<?> noparams[] = {};
        try {
            // Step 1) Make an object array and store the parameters that you wish
            // to pass it.
            //Object[] obj = {};// for method1()
            // Object[] obj={"hello"}; for method1(String str)
            // Object[] obj={"hello",1}; for method1(String str,int number)
            // Step 2) Create a class array which will hold the signature of the
            // method being called.
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
                // you can do additional checks for other data types if you want.
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
	
	/*public void setParameter(int[] para) {
		parameter = para;
	}
	
	public int getParameter(){
		return numofpm;
	}
	
	public void doExecution() {
		try {
			method.invoke(theCommand, parameter);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// return error
			e.printStackTrace();
		}
	}*/
}
