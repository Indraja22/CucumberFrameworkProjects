@Home
Feature: Home page feature

Background:
Given User logins to the PRODUCT STORE
|username|password|
|indrajannaik@gmail.com|inaik2295|
@Smoke
Scenario: Product Categories on Home Page
Given User is on the home page
Then Product categories section is visible to the user
And The product categories count should be 3
