# External: between the two sub-groups

* Canvas/GUI

The GUI will contain classes and methods responsible for displaying and drawing everything on the screen and accquiring appropriate user inputs. There a few key components within this group which require information to be retrieved in order to update the display appropriately. This includes retrieving information about the turtle's position so it can be drawn in the correct space on the canvas and the path it took so that can be correctly drawn. Additionally the history of the user's commands will need to be displayed which will be sourced from the user's text input. This leads to the additional requirement of this group which is, having the text input space and sending the inputted text to the Parser API, which will appropriately handled the entered information.


* Turtle

We plan to separate the graphical interface for the Turtle class from the interpreter by having the Turtle class handle the graphical interface, while the parser will interpret the commands and use the Turtle class’ public getters and setters to carry out the commands. The Turtle will encapsulate the image of the turtle, the x and y coordinates of the turtle, and the pen color. The turtle will communicate with the Canvas object to set its ImageView and penColor. The turtle may throw errors of the selected image is invalid or if the command would move the turtle out of bounds.


# Internal: between each sub-group and its future programmers (maintainers)

How you plan to provide paths for extension through interfaces, inheritance, and design patterns for new features you might reasonably expect to be added to the program.
What subclasses or implementing classes will be used to extend your part to add new features: making it clear what kind of code someone will be expected to write, what parts of your code you expect to be closed to modification, and what errors may be thrown.
Note, while some of these methods may be public, many may be protected or package friendly.


* Parser

The parser will have a file that contains different type of input that it can recognize. For potential extension that requires taking a different type of input (for example,  mathematical notations like “pi”, we can simply add to that file).
The main role of 
The part of parsing the input string of command into individual commands should be closed to modification. If additional commands that should be recognized by the program are added later, we should add respective calls of those new commands in the parser.

* Commands

This group will act more as a library containing many classes/methods that correspond to commands that we have within the sLogo langauge. They will execute the necessary actions/functions when called upon to do so and provided with the appropriate arguments. There will be a class hierarchy present where each command belonging to a specific group (e.g. boolean) may have their own class/method and a parent class which they inherit from. These commands should not be able to be modified elsewhere in the program.


# Introduction

This section describes the problem your team is trying to solve by writing this program, the primary design goals of the project (i.e., where is it most flexible), and the primary architecture of the design (i.e., what is closed and what is open). Discuss the program at a high-level (i.e., without referencing specific classes, data structures, or code).

The SLogo project is attempting to create a GUI based interactive program where the form of interaction is the SLogo language, which drives a “turtle” around the screen using commands. New commands for the turtle can be added by altering classes that are extended by lower classes that contain the logic, which would both be protected to restrict access to said lower level classes. There will be a class for the turtle, as well as multiple classes to handle drawing out the buttons, textbox, or the visual representation of the turtle. These will also handle the end user text input and and are responsible for iterating and stepping through any SLogo commands that the user gives the program.

# Design Overview

This section serves as a map of your design for other programmers to gain a general understanding of how and why the program was divided up, and how the individual parts work together to provide the desired functionality. Describe the four APIs you intend to create (their purpose with regards to the program's functionality, and how they collaborate with each other) focusing specifically on the behavior, not the internal state. Include a picture of how the components are related (these pictures can be hand drawn and scanned in, created with a standard drawing program, or screen shots from a UML design program). Discuss specific classes, methods, and data structures, but not individual lines of code.

We are dividing the program by the model view controller pattern. The model will have an abstract Commands class, which will be extended by a Math class and a Boolean class. These classes will be public and serve as libraries. The view will have the private Canvas (GUI) class and the private Turtle class, which extends the protected Movement class (forward, backward, left, right, etc.). The controller will have a protected Variable/Control Structures class (for, Repeat, etc.), which is extended by a private Parser class. The controller will create an instance of the Canvas and an instance of the Turtle, passing the Turtle object to the Parser to handle the input, whenever the user has entered a new command.

[Include picture of whiteboard]

# User Interface

This section describes how the user will interact with your program (keep it simple to start). Describe the overall appearance of program's user interface components and how users interact with these components (especially those specific to your program, i.e., means of input other than menus or toolbars). Include one or more pictures of the user interface (these pictures can be hand drawn and scanned in, created with a standard drawing program, or screen shots from a dummy program that serves as a exemplar). Describe any erroneous situations that are reported to the user (i.e., bad input data, empty data, etc.).

Along the top of the display in the User Interface I will have specific toolbar options which the user can utilize. These include an 'Edit' toolbar option which will drop-down to allow you to change the image of the turtle, the background color, the pen color and any additional aestethic changes, where each option will produce a pop-up in which the user can actively edit the chosen option. Other options in the toolbar will include 'New' which acts as a reset for the canvas/turtle, 'Language' which will allow you to choose your own language and 'Help' which will create a pop up containing all the information necessary to run the program. There will then be the main canvas with the turtle initially in the center to the left of the screen, but will update as commands are entered accordingly. Then to the right will be a text input box where the user can type their entry and above it will be a space where the history of the users input will be stored and displayed. Beyond this will be two boxes displaying the current active variables and current user defined commands.

![Image of UI]
(/images/UIDesign.jpg)


# API Details
 
This section describes each API introduced in the Overview in detail. Describe how each API supports specific features given in the assignment specification, what resources it might use, how it is intended to be used, and how it could be extended to include additional requirements (from the assignment specification or discussed by your team). Finally, justify the decision to create each class introduced with respect to the design's key goals, principles, and abstractions. Your APIs should be written as Java interfaces, types that cannot contain instance variables or private methods, in appropriate packages. These should be Java code files that compile and contain extensive comments to explain the purpose of each interface and each method within the interface (note this code can be generated directly from a UML diagram). Include any Exceptions you plan to throw because of errors that might occur within your methods. Note, this does not require that all of these types will remain as interfaces in the final implementation, just that the goal is for you to focus on each type's behavior and purpose.

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

Turtle:

Parser:

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

It is especially important in helping others understand how to use your APIs to provide example code. It should be clear from this code which objects are responsible for completing each part of the task, but you do not have to implement the called functions.

Show an actual "sequence of code" that implements the following use case using only methods described in your APIs: 

The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.

Note, clearly show the flow of calls to public methods needed to complete this example, indicating which class contains each method called. It is not necessary to understand exactly how parsing works in order to complete this example, just what the result of parsing the command will be.

Additionally, each member of the team should create two use cases of their own (and example code) for the part of the project for which they intend to take responsibility. These can still be done as a group, but should represent a variety of areas of the overall project.

* The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.

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



# Design Considerations

This section describes any issues which need to be addressed or resolved before attempting to devise a complete design solution. Include any design decisions that the group discussed at length (include pros and cons from all sides of the discussion) as well as any ambiguities, assumptions, or dependencies regarding the program that impact the overall design.

The first ambiguity is where to execute the Control commands, like for loops. Initially for our structure, Math Operations, Boolean, and Control/Variable were all parallel subclasses that extended an abstract command class, and these commands would be called in the Parser class. However, then we ran into the issue of how to pass a list of commands into the Control class. So later we decided to make the Parser an extension of the Control/Variable class.

In order to make fewer methods public, instead of having the turtle movement commands a subclass of Command.

There also needs to be a way for the program to check for syntax errors in the SLogo code without crashing. A try catch block would returns a specific value through catch upon failing to execute the code in the try block could be a solution.


# Team Responsibilities

Paul will do Boolean and Control variable classes, as well as the overarching abstract commands class. Parser class will extend the control variable class.

Peilin Lai: Peilin will do the parsing part. The Parse class will extend the control/variable class (for/repeat etc). It will take in a Turtle object and a string of commands. It will parse the string of command, and decide the logic and order of executing these commands. And it will call the commands.

Richard: Math operations class which extends the abstract Commands class, Movement class (forward, back, left, right, etc.), Turtle class (position of the turtle) which extends the Movement class.

Nathan: Nathan will initially create the User Interface and handle the creation of the GUI api. This includes displaying the turtle and its path correctly on the canvas sourcing the correct information, as well as handling the user input and sending it to the parser. As this role may require less time and work than the others, when finished I will continue to work on the parser, so we correctly handle the user input.