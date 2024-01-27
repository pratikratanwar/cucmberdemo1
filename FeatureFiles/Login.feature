Feature: Login with Valid credentials
@sanity
	 Scenario: Successful login with Valid Credentials
	 	 Given the user is navigates to login page
	 	 When user enters email as "ratanwarpratik@gmail.com" and password as "test@123"
	 	 And the user clicks on the Login button
	 	 Then the user should be redirected to the My Account page
	 	 
	 	 @regression
	 	 Scenario Outline : Login Data Driven
	 	 
	 	 Given the user navigates to login page
	 	 When user enters email as "<email>" and password as "<password>"
	 	 And tje user clicks on the Login button
	 	 Then the user should be redirected to the MyAccount Page
	 	 
	 	 Examples:
	 	 |email                     |password|
	 	 |ratanwarpratik96@gmail.com|test123|
	 	 |ratanwarpratik963@gmail.com|test@123|