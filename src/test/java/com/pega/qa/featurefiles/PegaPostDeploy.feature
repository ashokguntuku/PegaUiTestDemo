Feature: Pega UI Login, Enable Help & SysAdmin apps

@ModifyURLsTests
Scenario: Pega Login, Enable Help and Sysadmin applications Test 
Given user is on Pega Login Page
When title of Pega login page is Pega Platform
Then Pega user enters username and password for Admin
And user clicks on the login button
Then user is on Pega home page
Then user navigates to URL Settings screen
Then user enters the URLs and click Save
Then user logs out
Then Pega user enters username and password for Admin
And user clicks on the login button
Then user is on Pega home page
Then user navigates to URL Settings screen
Then user logs out
Then system closes the browser
