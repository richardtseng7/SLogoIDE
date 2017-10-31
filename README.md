# slogo

A development environment that helps users write SLogo programs.

It allows users to execute simple commands in multiple different languages.

<br/>


# User Interface

<br/>


#  Input Specifications

Each element of the command must be separated by space, otherwise it will be uncognizable and will pop up an error message window.

For example, "forward20" will be an invaid input, and the correct way to do it is "forward 20".

Each command can be written in different ways and in different languages. For example, both "fd" and "forward" will be recognized as the Forward command.

Moreover, "devant" and "dev" which mean Forward in French, will also trigger the Forward command.

Please refer to the resources.languages package for dictionaries for commands.

<br/>


# Example Input

1. When user types "fd 200", the turtle on the screen will move forward by 200 pixels, leaving a line on the path of movement.

2. When user types "right 90", the turtle will turn right by 90 degrees.

3. When user types "penup", the turtle will leave no trace on the screen.

<br/>