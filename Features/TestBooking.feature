Feature: TestBooking

  Background:
  Given "https://qa.testbookingapp.com/#/?test_code=123S&source=ZKAI" is loaded
  
  @ST01 @TC_I_06 @TestBooking @Smoke @Regression
  Scenario: Validate the New Booking flow for Free User (3000 Yen flow)
  And I enter userid as "gaurang.rathod@scispl.com" and password as "SMTtest12345"
  And I click on Submit button
  Then I see Step1 page is loaded successfully
  And I select subject as "Science"
  And I click on Next button
  And I check the checkboxes of Terms and conditions
  And I click on Next button
  And I enter EmergencyContact as "987654321" and ZKAIid as "12345678" and SelectedGroupName and ActiveDutystudent
 	And I click on Next button
 	And I click on pcCheckDevice button
 	And I click on Next button
 	And I click on Confirm & Pay button
 	And I re-login before payment
 	And I enter userid as "gaurang.rathod@scispl.com" and password as "SMTtest12345"
 	And I click on Submit button
 	And I complete payment details for booking
 	And I perfrom cancel booking from view reservation list
	And I close the browser
 	

	@ST02 @EM_01 @TestBooking @Smoke @Regression
  Scenario: Validate the Edit Booking flow for Free User (3000 Yen flow)
  And I enter userid as "gaurang.rathod@scispl.com" and password as "SMTtest12345"
  And I click on Submit button
  Then I see Step1 page is loaded successfully
  And I select subject as "Science"
  And I click on Next button
  And I check the checkboxes of Terms and conditions
  And I click on Next button
  And I enter EmergencyContact as "987654321" and ZKAIid as "12345678" and SelectedGroupName and ActiveDutystudent
 	And I click on Next button
 	And I click on pcCheckDevice button
 	And I click on Next button
 	And I click on Confirm & Pay button
 	And I re-login before payment
 	And I enter userid as "gaurang.rathod@scispl.com" and password as "SMTtest12345"
 	And I click on Submit button
 	And I complete payment details for booking
 	And I perform edit booking
 	And I perfrom cancel booking from view reservation list
 	And I close the browser
 	
 	@ST03 @TestBooking @Smoke
  Scenario: Validate the Cancel Booking flow for Free User (3000 Yen flow)
  And I enter userid as "gaurang.rathod@scispl.com" and password as "SMTtest12345"
  And I click on Submit button
  Then I see Step1 page is loaded successfully
  And I select subject as "Science"
  And I click on Next button
  And I check the checkboxes of Terms and conditions
  And I click on Next button
  And I enter EmergencyContact as "987654321" and ZKAIid as "12345678" and SelectedGroupName and ActiveDutystudent
 	And I click on Next button
 	And I click on pcCheckDevice button
 	And I click on Next button
 	And I click on Confirm & Pay button
 	And I re-login before payment
 	And I enter userid as "gaurang.rathod@scispl.com" and password as "SMTtest12345"
 	And I click on Submit button
 	And I complete payment details for booking
	And I perfrom cancel booking from view reservation list
	And I close the browser
	
	
	@ST04 @TestBooking @Smoke
  Scenario: Validate the New Booking flow for Prime User (500 Yen flow)
  And I enter userid as "grv07893@gmail.com" and password as "SMTtest12345"
  And I click on Submit button
  Then I see Step1 page is loaded successfully
  And I select subject as "Science"
  And I click on Next button
  And I check the checkboxes of Terms and conditions
  And I click on Next button
  And I enter EmergencyContact as "987654321" and ZKAIid as "12345678" and SelectedGroupName and ActiveDutystudent
 	And I click on Next button
 	And I click on pcCheckDevice button
 	And I click on Next button
 	And I click on Confirm & Pay button
 	And I re-login before payment
 	And I enter userid as "grv07893@gmail.com" and password as "SMTtest12345"
 	And I click on Submit button
 	And I complete payment details for booking
	And I perfrom cancel booking from view reservation list
	And I close the browser
	
	
	@ST05 @TestBooking @Smoke
  Scenario: Validate the Edit Booking flow for Prime User (500 Yen flow)
 	And I enter userid as "grv07893@gmail.com" and password as "SMTtest12345"
  And I click on Submit button
  Then I see Step1 page is loaded successfully
  And I select subject as "Science"
  And I click on Next button
  And I check the checkboxes of Terms and conditions
  And I click on Next button
  And I enter EmergencyContact as "987654321" and ZKAIid as "12345678" and SelectedGroupName and ActiveDutystudent
 	And I click on Next button
 	And I click on pcCheckDevice button
 	And I click on Next button
 	And I click on Confirm & Pay button
 	And I re-login before payment
 	And I enter userid as "grv07893@gmail.com" and password as "SMTtest12345"
 	And I click on Submit button
 	And I complete payment details for booking
 	And I perform edit booking
 	And I perfrom cancel booking from view reservation list
 	And I close the browser
	
	