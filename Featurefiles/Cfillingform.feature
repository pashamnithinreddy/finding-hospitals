Feature: fillingform
 Scenario: verify_page
  Given user clicks on For Corporates
  Then user is navigated to form page
  
  Scenario:verify_invalid_contactno
   Given user is on form page
   When user gives all valid details except phone number
   Then Schedule a demo button has to be disabled
   
  Scenario:verify_invalid_emailId
   Given user should refresh the page
   When user gives all valid details except emailId
   Then Schedule a demo button should be disabled
   
   Scenario:verify_valid_details
   Given user should refresh the page to enter details
   When user gives all valid details 
   Then Schedule a demo button should be enabled
   And ThankYou message is displayed