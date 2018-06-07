Feature: Pega UI Application Login Features

@LoginTests
Scenario: Pega Login Test scenario for Admin
Given user is on Login Page
When title of login page is Pega Platform
Then user enters username and password for Admin
And user clicks on login button
Then user is on home page
Then close the browser