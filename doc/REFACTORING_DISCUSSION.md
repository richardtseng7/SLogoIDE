Cell Society Team 7 API Critique
================================

### Methods that should not be part of the API

We said that helper methods should not be part of the API. We didn't find any specific cases of that in this
team's public methods.

### Methods that should be part of the external API

We decided that all of the constructors, getters and setters should be part of the external API, because
other components will need to use them in their code. Also, the XML methods should be part of the external API, since the back-end/front-end both need to access its data.

### Methods that should be part of the internal API

We think that for the back-end, the methods to determine neighbors should be part of the internal API, since the back-end handles the game logic. Similarly, for the front-end, the update and reset methods should be
part of the internal API.