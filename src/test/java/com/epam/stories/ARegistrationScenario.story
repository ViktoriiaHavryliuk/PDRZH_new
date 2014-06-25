Narrative:
In order to register into PDRZH
As a unregister user
I want to register in system to use the advanced features of the system

Scenario: Valid registration into system
Given home page http://evbyminsd7238.minsk.epam.com:8080/pdrzh/main
When the user click on registration page
And the user has entered login password, confirmed password, phone and check that all fields and email are editable
And check-box button has been pressed
And submit button has been pressed
Then the user should see logout button and his log above img


Scenario: InValid registration into system
Given home page http://evbyminsd7238.minsk.epam.com:8080/pdrzh/main
When the user click on registration page
And the user has entered invalid login, invalid password, unconfirmed password, invalid phone and check that all fields and email are editable
And check-box button has been pressed
And submit button has been pressed
Then the user should see corresponding message:
|message|
|Sorry, but client with this login is already in use|
And delete this new user from DB