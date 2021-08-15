Feature: To validate signup process

Background: To Launch Browser
Given User launches browser and navigate to signup page

@signup
Scenario: Sign up process
Given user is on the signup page and enter all details
When registrion process is completed without any error
Then user is succesufully registered