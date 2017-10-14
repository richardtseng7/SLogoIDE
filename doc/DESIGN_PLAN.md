# External: between the two sub-groups

* Canvas/GUI

The GUI will contain classes and methods responsible for displaying and drawing everything on the screen and accquiring appropriate user inputs. There a few key components within this group which require information to be retrieved in order to update the display appropriately. This includes retrieving information about the turtle's position so it can be drawn in the correct space on the canvas and the path it took so that can be correctly drawn. Additionally the history of the user's commands will need to be displayed which will be sourced from the user's text input. This leads to the additional requirement of this group which is, having the text input space and sending the inputted text to the Parser API, which will appropriately handled the entered information.


* Movement/Turtle

We plan to separate the graphical interface for the Turtle class from the interpreter by having the Turtle class handle the graphical interface, while the parser will interpret the commands and use the Turtle class’ public getters and setters to carry out the commands. The Turtle will encapsulate the image of the turtle, the x and y coordinates of the turtle, and the pen color. The turtle will communicate with the Canvas object to set its ImageView and penColor. The turtle may throw errors of the selected image is invalid or if the command would move the turtle out of bounds.


# Internal: between each sub-group and its future programmers (maintainers)

* Parser

The parser will have a file that contains different type of input that it can recognize. For potential extension that requires taking a different type of input (for example,  mathematical notations like “pi”, we can simply add to that file).
The main role of 
The part of parsing the input string of command into individual commands should be closed to modification. If additional commands that should be recognized by the program are added later, we should add respective calls of those new commands in the parser.

* Commands

This group will act more as a library containing many classes/methods that correspond to commands that we have within the sLogo langauge. They will execute the necessary actions/functions when called upon to do so and provided with the appropriate arguments. There will be a class hierarchy present where each command belonging to a specific group (e.g. boolean) may have their own class/method and a parent class which they inherit from. These commands should not be able to be modified elsewhere in the program.


# Introduction

The SLogo project is attempting to create a GUI based interactive program where the form of interaction is the SLogo language, which drives a “turtle” around the screen using commands. New commands for the turtle can be added by altering classes that are extended by lower classes that contain the logic, which would both be protected to restrict access to said lower level classes. There will be a class for the turtle, as well as multiple classes to handle drawing out the buttons, textbox, or the visual representation of the turtle. These will also handle the end user text input and and are responsible for iterating and stepping through any SLogo commands that the user gives the program.

# Design Overview

We are dividing the program by the model view controller pattern. The model will have an abstract Commands class, which will be extended by a Math class and a Boolean class. These classes will be public and serve as libraries. The view will have the private Canvas (GUI) class and the private Turtle class, which extends the protected Movement class (forward, backward, left, right, etc.). The controller will have a protected Variable/Control Structures class (for, Repeat, etc.), which is extended by a private Parser class. The controller will create an instance of the Canvas and an instance of the Turtle, passing the Turtle object to the Parser to handle the input, whenever the user has entered a new command.

[Include picture of whiteboard]

# User Interface

Along the top of the display in the User Interface I will have specific toolbar options which the user can utilize. These include an 'Edit' toolbar option which will drop-down to allow you to change the image of the turtle, the background color, the pen color and any additional aestethic changes, where each option will produce a pop-up in which the user can actively edit the chosen option. Other options in the toolbar will include 'New' which acts as a reset for the canvas/turtle, 'Language' which will allow you to choose your own language and 'Help' which will create a pop up containing all the information necessary to run the program. There will then be the main canvas with the turtle initially in the center to the left of the screen, but will update as commands are entered accordingly. Then to the right will be a text input box where the user can type their entry and above it will be a space where the history of the users input will be stored and displayed. Beyond this will be two boxes displaying the current active variables and current user defined commands.

![Image of UI]
(/images/UIDesign.jpg)


# API Details
 
GUI:
This API is used to display all appropriate objects and information on the screen for the user to see. The API will intialize all the JavaFX code such as the scene and group and most some methods will run once to simply set up the display. There won't be too many classes in this API but classes will be introduced to handle the updating of each bit of information displayed to the user e.g. the turtle or active variables. These will be called upon the completion of the back-end's processing of the user input text. It should be able to be easily extended to add further features to the User Interface simply by adding to the initialization method and creating a  new class for the new specific function.

```java
public interface GUI{


    private void initalizeView();
    //Used to initialize placement and specifics of the user interface so everything appears appropriately on screen.
    
    private void drawTurtlePath();
    //When called this method will update the display of the turtle and it's path after the user has entered their commands and they have been processed by the back end and the Turtle object has been updated.
        
    public String userInputText();
    //This method will take the user's text input from the displayed text box and send it to the Parser for interpretation upon submission.
    
    private void toolbarOptions();
    //This method will contain the set up for each of the available toolbar options and the pop ups upon the clicking of each option.
    
    public String displayError();
    //Used to display a pop-up error to the screen when received from the back end.
    
    //Each of the following is used to occupy the appropriate boxes on the display with the correct data.
    protected void displayHistory();
    
    public String displayVariables();
    
    public String displayUserMethods();
    
    protected ImageView changeTurtleImage();
    
    protected Color changeBackgroundColor();
    
    protected Color changePenColor();
}
```


Movement/Turtle:

```java
public interface Movement {

    public Point2D getPos();
    //Get the current position of the object.
    
    public Point2D setPos(Point2D newPos);
    //Set the position of the object to newPos. Returns distance the object moved. Throws out of bounds exception if newPos is invalid.
    
    public int forward(int pixels);
    //Move the object forward by pixels distance. Returns the value of pixels. Throws out of bounds exception if the new position is invalid.
    
    public int back(int pixels);
    //Move the object back by pixels distance. Returns the value of pixels. Throws out of bounds exception if the new position is invalid.

    public int left(int degrees);
    //Turn the object counterclockwise by degrees angle. Returns the value of degrees. Throws out of bounds exception if the new position is invalid.

    public int right(int degrees);
    //Turn the object clockwise by degrees angle. Returns the value of degrees. Throws out of bounds exception if the new position is invalid.

    public int setHeading(int degrees);
    //Turn object to an absolute heading. Returns number of degrees moved.

    public int penDown();
    //Puts pen down such that when the object moves, it leaves a trail. Returns 1.
    
    public int penUp();
    //Puts pen up such that when the object moves, it does not leave a trail. Returns 0.
    
    public int show();
    //Makes object visible. Returns 1.
    
    public int hide();
    //Makes object invisible. Returns 0.

    public int home();
    //Moves object to the center of the screen (0, 0). Returns the distance object moved.
    
    public int clearScreen();
    //Erases object's trails and sends it to the home position. Returns the distance object moved.
}
```


Parser:

```java
public interface Parser{

    private ArrayList<Object> content();
    //Used to parse the input String into an ArrayList of strings, integers and symbols, using Object[] content = str.split(" ");
    
    private void callCommand();
// Used to execute a list of command according to the orders，which should be the most important/core method of this Parser

	private boolean readyCommand();
	// Used to check whether a specific command has enough/correct parameters to be executed, takes in the ArrayList of parsed user input, as well as the command index

}
```


Commands:
```java
public abstract class Commands {
  private int myin1;
  private int myin2;
  protected Commands(int input1, int input2){
      myin1 = input1;
      myin2 = input2;
  }
  //this is the main commands class
  protected int getIn1(){   return myin1;  }
  protected int getIn2(){   return myin2;  }
  //getters
}
public class mathFunc extends Commands {
   public mathFunc(int input1, int input2) {Commands(input1, input2);  }
   //All math functions go here, getting inputs from commands
}
public class mathBool extends Commands {
   public mathBool(int input1, int input2) { Commands(input1, input2);  }
   //All boolean ops go here, getting inputs from commands
}
```


# API Example Code

The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.

* ‘fd 50’ is read in from the terminal by the Canvas object

* the Parser object is passed this command, along with the Turtle object

* the Parser interprets the command and calls the protected forward method in the Movement class, which the Turtle object extends

* the protected forward Method updates the position of the Turtle using the Turtle class’ public getters and setters and notifies the appropriate Property Change Listener that the position of the Turtle needs to be updated on the Canvas

* the Property Change Listener updates the position of the Turtle on the Canvas

Richard’s Use Cases

1. The user types ‘fd sum 10 sum 10 sum 10 sum 20 20’ in the command window and sees the turtle move in the display window leaving a trail, and the command is added to the environment’s history
    * ‘fd sum 10 sum 10 sum 10 sum 20 20’ is read in from the terminal by the Canvas object
    * the Parser object is passed this command, along with the Turtle object
    * the Parser interprets the command and calls the protected sum method in the Movement class four times and then the protected forward method in the Movement class, which the Turtle object extends
the protected forward Method updates the position of the Turtle using the Turtle class’ public getters and setters and notifies the appropriate Property Change Listener that the position of the Turtle needs to be updated on the Canvas
    * the Property Change Listener updates the position of the Turtle on the Canvas
2. The user sets a background color for the turtle's display area, an image to use for the turtle, and a color to use for the pen
    * The public setters of the Turtle object are called and the appropriate Property Change Listeners updates these properties of the Turtle on the Canvas

Peilin’s Use Cases

* The user types ‘fd sum 10 sum 10 sum 10 sum 20 20’ in the command window and sees the turtle move in the display window leaving a trail, and the command is added to the environment’s history

* The string of command with a Turtle object are passed into the Parser.

* The parser will parse the string into individual commands, and decided on the order that they will be executed, and return an error when there's a wrong number of parameters for certain commands or invalid command names.

* After deciding on which order the commands will be executed, the parser will call on those commands. In this case, the algebraic method "sum" will be executed 4 times first, then the a movement method will be called on the Turtle.

Nathan's Use Cases

* User enters 'for [ fd sum 10 20 ]', this clearly lacks the appropriate syntax required for the 'for' loop.

* This user entered text is passed to the Parser which interprets this text and acknowledges the syntax error in the 'for' command.

* This error is sent to the GUI which displays it as a pop-up error on the display.

* User enters 'fd 10 rt 50'.

* This entered text is passed to the Parser which interprets these commands and calls the appropriate commands 'forward' and 'right' in the correct order which the correct arguments. 

* These commands call updates on the turtle's position and its path which is passed to the GUI and subsequently drawn onto the display.

Paul's Use Cases

* User enters and 123 0

* Parser calls and within the boolFunc class with input arguments 10, 10

* and(123, 0) returns 1 to Parser



* User enters 'fd (sum 10 sum 10 10) or (sum 10 sum 20 20)', this is first passed to the parser.

* Parser calls sum within the mathFunc class with input arguments 10 and 10.

* Parser then calls sum with returned value and 10.

* Parser calls sum(20, 20), then sum(10, 40)

* Parser then calls or within the mathBool as or(30, 40).

* Parser then calls fd function in turtle, which is not in commands.

* For any command using math or bool operations this continues until all relevant functions are calculated.

# Design Considerations

The first ambiguity is where to execute the Control commands, like for loops. Initially for our structure, Math Operations, Boolean, and Control/Variable were all parallel subclasses that extended an abstract command class, and these commands would be called in the Parser class. However, then we ran into the issue of how to pass a list of commands into the Control class. So later we decided to make the Parser an extension of the Control/Variable class.

In order to make fewer methods public, instead of having the turtle movement commands a subclass of Command.

There also needs to be a way for the program to check for syntax errors in the SLogo code without crashing. A try catch block would returns a specific value through catch upon failing to execute the code in the try block could be a solution.


# Team Responsibilities

Paul will do Boolean and Control variable classes, as well as the overarching abstract commands class. Parser class will extend the control variable class.

Peilin Lai: Peilin will do the parsing part. The Parse class will extend the control/variable class (for/repeat etc). It will take in a Turtle object and a string of commands. It will parse the string of command, and decide the logic and order of executing these commands. And it will call the commands.

Richard: Math operations class which extends the abstract Commands class, Movement class (forward, back, left, right, etc.), Turtle class (position of the turtle) which extends the Movement class.

Nathan: Nathan will initially create the User Interface and handle the creation of the GUI api. This includes displaying the turtle and its path correctly on the canvas sourcing the correct information, as well as handling the user input and sending it to the parser. As this role may require less time and work than the others, when finished I will continue to work on the parser, so we correctly handle the user input.