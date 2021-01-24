@Login
Feature: Login page feature
@Sanity
Scenario Outline: Log In with username and password
Given User has launched the application
And User is on the home page
When User enters his username "<username>" and password "<password>"
Then Verify if the home page displays message Welcome "<username>"
Examples:
|username|password|
|indrajannaik@gmail.com|inaik2295|
|indrajannaik@gmail.com|iiiii|