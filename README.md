# slogo

A development environment that helps users write SLogo programs.

It allows users to execute simple commands in multiple different languages.

<br/>

## Contribution

Nathan Lewis (nbl7), Richard Tseng (rt120), Paul Lee (cl270), Peilin Lai (pl111)

Date Started: 10/14/17  Date Finished: 10/31/17

Estimated combined hours: 140 - 160 hours

Nathan's Role: Nathan worked on developing the front-end of the project - the 'view' - as well as contributing to parts of the back-end where necessary such as instances where Observers in the front end needed to be linked to their Observable classes within the back end or GUI components edited specific values within the back-end of the program. He also completed a couple other miscellaneous tasks in the back-end when workload needed to be spreaded to achieve a specific goal.

Richard's Role:

Peilin's Role:

Paul's Role: Paul worked on the back end, the majority of the slogo parsing logic, expressiontree, executor of the expression tree which calls factory, factory which uses reflection to call commands, and also the math and booleean command classes.

## Resources

To complete the project we used a variety of online resources when necessary:
* Java Official Documentation
* Java2S JavaFX How To - http://www.java2s.com/Tutorials/Java/JavaFX_How_to/index.htm
* JavaWorld Observer Observable article - https://www.javaworld.com/article/2077258/learn-java/observer-and-observable.html
* Many specific StackOverflow question answers

To start the project run the class Main which can be found in the default package of the Java project.

In order for the program to run there is a .jar file in the lib folder of the project used to draw the resizable and moveable windows. This must be added with a custom build path to the Referenced Libraries of the project.

## About the Program

###  Input Specifications

#### Key Input

You may use the arrow keys on your keyboard to move the turtle forward by 10 and rotate by 90 degrees.

#### Text Entry

Each element of the command must be separated by space, otherwise it will be uncognizable and will pop up an error message window.

For example, "forward20" will be an invaid input, and the correct way to do it is "forward 20".

Each command can be written in different ways and in different languages. For example, both "fd" and "forward" will be recognized as the Forward command.

Moreover, "devant" and "dev" which mean Forward in French, will also trigger the Forward command.

Please refer to the resources.languages package for dictionaries for commands.

<br/>


#### Example Input

1. When user types "fd 200", the turtle on the screen will move forward by 200 pixels, leaving a line on the path of movement.

2. When user types "right 90", the turtle will turn right by 90 degrees.

3. When user types "penup", the turtle will leave no trace on the screen.

4. When user types "make :abc 1", "make :bcd 2 ", and then  "for [ :abc 2 6 :bcd ] [ fd :abc ] ", the turtle will move forward 2, then 4, then 6 pixels forward.


### Assumptions

* When changing properties of the pen it will change them for all future pen lines not existing.

* Loops and Conditionals that rely on variables (such as for) need said variables to be declared beforehand. 


#### Front End - Known Errors

* The 'New' button is not able to effectively clear the canvas.
* The methods do not display as there is no way to store new methods in the back end.
* Selecting active turtles graphically method didn't work, now not implemented.

#### Back End - Known Errors

* The "To" command is not completely implemented.