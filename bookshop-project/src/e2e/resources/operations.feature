Feature: Operations inside the bookshop site
		Specifications of operations with the database
		
	Scenario: Initially empty book list in the Home Page
		Given I am on the Registration page
  	When I insert "my_email@gmail" into email field, "my_username" into username field and "my_password" into password field
  	And I click the "Register" button
  	Then I am on the "Result" page
  	And "You have successfully registered!" message is shown
  	When I click on "Login Page" link
  	And I insert "my_email@gmail" into email field and "my_password" into password field
  	And I click the "Sign in" button
  	Then I am on the "Home" page
  	And "There are no books" message is shown
  	
  Scenario: Add a book and delete it
		Given I am on the Registration page
  	When I insert "my_email@gmail" into email field, "my_username" into username field and "my_password" into password field
  	And I click the "Register" button
  	Then I am on the "Result" page
  	And "You have successfully registered!" message is shown
  	When I click on "Login Page" link
  	And I insert "my_email@gmail" into email field and "my_password" into password field
  	And I click the "Sign in" button
  	Then I am on the "Home" page
		When I click the "Insert" button
		And I insert "TestTitleToDelete" in title field, "TestTypeToDelete" in type field and "30" in price field 
		And I click the "Save" button
		Then the "Book Table" is shown and it contains a book with "TestTitleToDelete", "TestTypeToDelete", and price "30"
		When I click the "Delete" button
		Then "There are no books" message is shown
	
	Scenario: Add a book and edit it
		Given I am on the Registration page
  	When I insert "my_email@gmail" into email field, "my_username" into username field and "my_password" into password field
  	And I click the "Register" button
  	Then I am on the "Result" page
  	And "You have successfully registered!" message is shown
  	When I click on "Login Page" link
  	And I insert "my_email@gmail" into email field and "my_password" into password field
  	And I click the "Sign in" button
  	Then I am on the "Home" page
		When I click the "Insert" button
		And I insert "TestTitleToEdit" in title field, "TestTypeToEdit" in type field and "30" in price field 
		And I click the "Save" button
		Then the "Book Table" is shown and it contains a book with "TestTitleToEdit", "TestTypeToEdit", and price "30"
		When I click the "Edit" button
		And I update the type field with "UpdatedType" and the price field with "20"
		And I click the "Save" button
		Then the "Book Table" is shown and it contains a book with "TestTitleToEdit", "UpdatedType", and price "20"
		#Then the book table now contains a book with "TestTitleForEdit" in the title field, "UpdatedType" in the type field and "20" in the price field	
		