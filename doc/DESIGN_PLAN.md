External: between the two sub-groups
How you plan to separate the graphical interface from the interpreter and how you plan to let them communicate when necessary.
What objects will be used for communication: making it clear how needed information will get where it is needed, what will be available and what will be encapsulated, what things will be immutable, and what errors may be thrown.
Note, all of these methods will need to be public.

Canvas (GUI)



Turtle




Internal: between each sub-group and its future programmers (maintainers)
How you plan to provide paths for extension through interfaces, inheritance, and design patterns for new features you might reasonably expect to be added to the program.
What subclasses or implementing classes will be used to extend your part to add new features: making it clear what kind of code someone will be expected to write, what parts of your code you expect to be closed to modification, and what errors may be thrown.
Note, while some of these methods may be public, many may be protected or package friendly.

Commands



Parser
The parser will have a file that contains different type of input that it can recognize. For potential extension that requires taking a different type of input (for example,  mathematical notations like “pi”, we can simply add to that file.) 
The part of parsing the input string of command into individual commands should be closed to modification. If additional commands that should be recognized by the program are added later, we should add respective calls of those new commands in the parser.


Introduction
This section describes the problem your team is trying to solve by writing this program, the primary design goals of the project (i.e., where is it most flexible), and the primary architecture of the design (i.e., what is closed and what is open). Discuss the program at a high-level (i.e., without referencing specific classes, data structures, or code).

The SLogo project is attempting to create a GUI based interactive program where the form of interaction is the SLogo language, which drives a “turtle” around the screen using commands. New commands for the turtle can be added by altering classes that are extended by lower classes that contain the logic, which would both be protected to restrict access to said lower level classes. There will be a class for the turtle, as well as multiple classes to handle drawing out the buttons, textbox, or the visual representation of the turtle. These will also handle the end user text input and and are responsible for iterating and stepping through any SLogo commands that the user gives the program.

Design Overview
This section serves as a map of your design for other programmers to gain a general understanding of how and why the program was divided up, and how the individual parts work together to provide the desired functionality. Describe the four APIs you intend to create (their purpose with regards to the program's functionality, and how they collaborate with each other) focusing specifically on the behavior, not the internal state. Include a picture of how the components are related (these pictures can be hand drawn and scanned in, created with a standard drawing program, or screen shots from a UML design program). Discuss specific classes, methods, and data structures, but not individual lines of code.

We are dividing the program by the model view controller pattern. The model will have an abstract Commands class, which will be extended by a Math class and a Boolean class. These classes will be public and serve as libraries. The view will have the private Canvas (GUI) class and the private Turtle class, which extends the protected Movement class (forward, backward, left, right, etc.). The controller will have a protected Variable/Control Structures class (for, Repeat, etc.), which is extended by a private Parser class. The controller will create an instance of the Canvas and an instance of the Turtle, passing the Turtle object to the Parser to handle the input, whenever the user has entered a new command.

[Include picture of whiteboard]

User Interface
This section describes how the user will interact with your program (keep it simple to start). Describe the overall appearance of program's user interface components and how users interact with these components (especially those specific to your program, i.e., means of input other than menus or toolbars). Include one or more pictures of the user interface (these pictures can be hand drawn and scanned in, created with a standard drawing program, or screen shots from a dummy program that serves as a exemplar). Describe any erroneous situations that are reported to the user (i.e., bad input data, empty data, etc.).



API Details 
This section describes each API introduced in the Overview in detail. Describe how each API supports specific features given in the assignment specification, what resources it might use, how it is intended to be used, and how it could be extended to include additional requirements (from the assignment specification or discussed by your team). Finally, justify the decision to create each class introduced with respect to the design's key goals, principles, and abstractions. Your APIs should be written as Java interfaces, types that cannot contain instance variables or private methods, in appropriate packages. These should be Java code files that compile and contain extensive comments to explain the purpose of each interface and each method within the interface (note this code can be generated directly from a UML diagram). Include any Exceptions you plan to throw because of errors that might occur within your methods. Note, this does not require that all of these types will remain as interfaces in the final implementation, just that the goal is for you to focus on each type's behavior and purpose.



API Example Code
It is especially important in helping others understand how to use your APIs to provide example code. It should be clear from this code which objects are responsible for completing each part of the task, but you do not have to implement the called functions.
Show an actual "sequence of code" that implements the following use case using only methods described in your APIs: 
The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.
Note, clearly show the flow of calls to public methods needed to complete this example, indicating which class contains each method called. It is not necessary to understand exactly how parsing works in order to complete this example, just what the result of parsing the command will be.
Additionally, each member of the team should create two use cases of their own (and example code) for the part of the project for which they intend to take responsibility. These can still be done as a group, but should represent a variety of areas of the overall project.

‘fd 50’ is read in from the terminal in the Canvas
the Parser object is passed this command, along with the Turtle object
the Parser interprets the command and calls the forward method in the Movement class, which the Turtle object extends
the forward Method updates the position of the Turtle using its getters and setters and notifies the appropriate Property Change Listener that the position of the Turtle needs to be updated on the Canvas 
the Property Change Listener updates the position of the Turtle on the Canvas




Design Considerations 
This section describes any issues which need to be addressed or resolved before attempting to devise a complete design solution. Include any design decisions that the group discussed at length (include pros and cons from all sides of the discussion) as well as any ambiguities, assumptions, or dependencies regarding the program that impact the overall design.

The first ambiguity is where to execute the Control commands, like for loops. Initially for our structure, Math Operations, Boolean, and Control/Variable were all parallel subclasses that extended an abstract command class, and these commands would be called in the Parser class. However, then we ran into the issue of how to pass a list of commands into the Control class. So later we decided to make the Parser an extension of the Control/Variable class.

In order to make fewer methods public, instead of having the turtle movement commands a subclass of Command which would be parallel 

There also needs to be a way for the program to check for syntax errors in the SLogo code without crashing. A try catch block would returns a specific value through catch upon failing to execute the code in the try block could be a solution.


Team Responsibilities
Paul  will do Boolean and Control variable classes, as well as the overarching abstract commands class. Parser class will extend the control variable class.

Peilin Lai: Peilin will do the parsing part. The Parse class will extend the control/variable class (for/repeat etc). It will take in a Turtle object and a string of commands. It will parse the string of command, and decide the logic and order of executing these commands. And it will call the commands.

Richard: Math operations class which extends the abstract Commands class, Movement class (forward, back, left, right, etc.), Turtle class (position of the turtle) which extends the Movement class

R
Last modified 05 O

ct 2017











