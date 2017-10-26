REFACTORING DISCUSSION
================================

We decided to implement Observable and Observer for the Turtle and the UIController classes. We agreed that we needed to refactor the Pen object and have it contain an List of Line objects. Each turtle will have its own instance of the Pen object. 