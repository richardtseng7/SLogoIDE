CompSci 308: SLogo Addition
===================


Back-End Extension
=======

Add two of the following commands to the SLogo language:
* STAMP	draw the image of the turtle in its current settings on the workspace display
returns the index of the turtle's image used for the stamp
* CLEARSTAMPS	remove all stamps that have been made
returns 1 if there were any stamps cleared, 0 otherwise

### Estimation

* I think it will take me 30 minutes to an hour to complete this new feature.

* I need to add two classes, one for each command. I also need to update the turtle class to hold a group containing the stamps.

### Review

* It took me about 45 minutes to complete this new feature.

* I needed to add two new files, one for the STAMP command and one for the CLEARSTAMPS command, because our parser requires a Java class for each command. I had to update Turtle.java to hold a group containing the stamps, so that I could simply clear the group later when CLEARSTAMPS gets called. I also had to update the UIController.java and Canvas.java classes to fix an existing issue in which the Model and the Canvas depended on one another in each of their respective constructors.

* After I finished fixing the existing bug with Canvas.java and Model.java, it took me one or two to get it right.

### Analysis

* The project's design and documentation was a bit worse than what I remembered. After looking back through some of the classes, I noticed that there are so many classes that are all so long, some with lines and lines of getters and setters.

* The code could be a bit better documented, especially the front-end and the expression tree/parser. Also, many of the classes have long methods with functionality that can be extracted into their own separate methods (e.g. constructor of UIController.java). The dependencies between the front-end (Canvas, palette, turtle images) and the back-end (model, turtle, commands) could also be handled in a more centralized way, such as by adding a class in the front-end that holds all of the observable properties that the back-end commands modify and need reflected on the front-end side.

* It would have been difficult to complete this feature had I not been familiar with the code at all. The dependencies make it hard to follow or trace through.