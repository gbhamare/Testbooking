Feature: TestBooking

  Background:
  Given "https://qa.testbookingapp.com/?test_code=ZKAI02&source=ZKAI" is loaded
  
  @ST07 @TestBooking @Smoke
  Scenario: Validate the New Booking flow for ZKAI User (No payment required)
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
 	And I perfrom cancel booking from view reservation list
	And I close the browser
 	

	@ST08 @TestBooking @Smoke
  Scenario: Validate the Edit Booking flow for ZKAI User (No payment required)
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
 	And I perform edit booking
 	And I perfrom cancel booking from view reservation list
 	And I close the browser
 	
 	@ST09 @TestBooking @Smoke
  Scenario: Validate the Cancel Booking flow for ZKAI User (No payment required)
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
  And I perfrom cancel booking from view reservation list
	And I close the browser
	
	@TS52 @TS60 @TS59
	Scenario: Validate user is able to enter all the information in step3
	And I enter userid as "automation1" and password as "automation1"
	And I click on Submit button
  Then I see Step1 page is loaded successfully
  And I select subject as "Science"
  And I click on Next button
  And I check the checkboxes of Terms and conditions
  And I click on Next button
	And I clear existing text
	And I enter Firstaname as "GIRISH" and Lastname as "BHAMARE" and FirstanameKana as "カナ" and LastnameKana as "メイ"
	And I enter Phonenumber as "9028144139" and PinocodeZone as "120" and PincodeSubzone "0000"
	And I enter streetno as "住所住所" and buildingno as "住所住所"
	And I enter EmergencyContact as "987654321" and ZKAIid as "12345678" and SelectedGroupName and ActiveDutystudent
	And I click on Next button
	And I click on pcCheckDevice button
 	And I click on Next button
 	And I verify examinfo on step5
 	And I verify name namekana username birthdate gender email address postalcode phonenumber on step5
	And I click on Confirm & Pay button
  And I perfrom cancel booking from view reservation list
	And I close the browser
	