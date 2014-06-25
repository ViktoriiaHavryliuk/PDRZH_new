Narrative:
In order to register into PDRZH
As a unregister user
I want to register in system to use the advanced features of the system

Scenario: Valid log into system
Given home page http://evbyminsd7238.minsk.epam.com:8080/pdrzh/main
When the user has entered login, password
Then the user should see logout button and his log above img

Scenario: InValid log into system
Given home page http://evbyminsd7238.minsk.epam.com:8080/pdrzh/main
When the user has entered login, invalid password
Then the user should see message:
|message|
|Bad credentials|