###API Changes
####Turtle/Movement
This API has changed the most in terms of our design. We initially had it so that there were many public methods that could be utilized by our controller in order to create the movement and handle the displaying of the turtle in the view. We have since changed this to encapsulate more of the functionality so that the turtle object will update its appropriate values when necessary and create an ObservableObject that will trigger the update method within our controller which will appropriately update the the view of the turtle. 
This didn't change our code too much overall as it mostly involved moving functionality elsewhere, but made our design much more secure and less accessible by other parts of the program, overall making it better.
This update should not change but some additions and changes may be made to our design as we implement multiple turtles being in our program. This will require some changes, and potentially a new interface and class to handle management of the multiple turtles but the movement functionality should remain within the turtle.

#### GUI
There were not too many changes to the View aspect of the program and the API. The most noticeable change is that for most functionality where we previously imagined public methods called in other parts of the program and providing the appropriate information to the View; we instead call functions within instances of instantiated objects to push encapsulation.
This has helped reduce the number of public methods within the View which in hindsight were mostly unnecessary and make the design more secure.

#### Parser
Parser hasn't changed significantly from our initial design however we have implemented reflection and the factory design pattern into it.

#### Commands
Our commands API hasn't changed too significantly from what we proposed. It will changed a fair amount in the coming days in terms of design however.