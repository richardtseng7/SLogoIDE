# API SLogo

Team 7:
Peilin Lai (pl111)
Richard Tseng (rt120)
Paul Lee (cl270)
Nathan Lewis (nbl7)

### SLogo Architecture Design

1. We have to parse in all text commands that the user inputs into the program and handle errors that arise from this. We will also need to parse information from a default configuration file that will contain parameters required to begin, such as the background color, image for the turtle etc. The user could also have the ability to change this information which would need to be parsed in correctly as well.
2. In context of user commands being parsed, we have to link the entered information to the appropriate Class(es) in order for the correct action to occur. The GUI Class/Subclasses may also need to access this parsed information to set up the correct display.
3. Errors can be checked in real time, through a syntax checker when the user enters their information, checking perhaps every keystroke or after each entered word. If there is an error in the function of the user's desired input, an error could also be raised when they choose to run their input. The errors will be handled via pop up windows to the user or via other methods to show an error graphically, without the program crashing.
4. The text commands entered by the user won't know what their role is until the commands are compiled by the user. At this point they retrieve their information/actions from the appropriate Class hierarchies we have developed.
5. When the commands have been executed the turtle should begin to move accordingly and create the correct path with the pen. Upon completion of the turtle's movement, the previous commands should move to a visible location in the window - so they can be referenced -, and a new, clear text entry should appear where further/new commands can be entered. Also if any errors occur in the command executions, they should be displayed to the GUI.

### Create Your APIs

External:
* Command Parsing Class:
    public method to take an String input, and return specific command types as well as command parameters

Internal:
* Canvas Drawing Class:
    public Canvas constructor
    
* Turtle Class:
    public constuctor with an image parameter
    .getX() - get the X coordinate
    .getY() - get the Y coordinate
    .updateX - update the X coordinate
    .updateY - update the Y coordinate
    .updateOrientation - update where the turtle is facing towards

* abstract superclass for EXECUTION
    one public class for each general type of execution, which extends EXECUTION
    .execute(int...) - take parameters and perform instruction
