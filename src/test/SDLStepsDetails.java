package test;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import io.restassured.specification.RequestSpecification;

import junit.framework.Assert;
import pages.LoginPage;
import pages.StepDetailsPage;
import utils.DriverUtils;
import utils.TestDataUtils;

public class SDLStepsDetails {
	WebDriver driver;

	
	public SDLStepsDetails(DriverUtils utils) {
		this.driver = utils.getdriver();
	}
	
	@Given("^\"([^\"]*)\" is loaded$")
	public void is_loaded(String strURL) throws Throwable {
		LoginPage lwp = new LoginPage(driver);
		lwp.loadURL(strURL);
	}  

	@And("^I enter userid as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void entrUserPassword(String User, String Password){
		LoginPage lwp = new LoginPage(driver);
		lwp.UserPassword(User, Password);	
	}
	
	@When("^I click on Submit button$")
	public void submit(){
		LoginPage lwp = new LoginPage(driver);
		lwp.submitBtn();
	}	

	@Then("^I see Step1 page is loaded successfully$")
	public void step1(){
		LoginPage lwp = new LoginPage(driver);
		Assert.assertTrue("Verified Test Selection title on Step 1",lwp.verifyTestSelectionTitle());
		
	}
	
	@And("^I select subject as \"([^\"]*)\"$")
	public void selectSubject(String subject) throws Throwable {
		
		StepDetailsPage lwp = new StepDetailsPage(driver);
		Thread.sleep(3000);
		lwp.subjectRadioButton(subject); /*Selects Radio Button Science */
		lwp.selectSociety(subject); /*Selects Radio Button Japanese History B*/
		lwp.selectScience(); /*Selects Radio Button Chemistry, Biological*/
	}
	
	@And("^I click on Next button$")
	public void i_click_on_Next_button_on_Step() throws Throwable {
		StepDetailsPage lwp = new StepDetailsPage(driver);
		Thread.sleep(3000);
		lwp.nextButton();
	}
	
	@And("^I check the checkboxes of Terms and conditions$")
	public void entrUserPassword() throws InterruptedException{
		StepDetailsPage lwp = new StepDetailsPage(driver);
		Thread.sleep(3000);
		lwp.selectCheckBoxOnStep2();
		
	}	
	
	@And("^I enter EmergencyContact as \"([^\"]*)\" and ZKAIid as \"([^\"]*)\" and SelectedGroupName and ActiveDutystudent$")
	public void i_enter_EmergencyContact_as_and_ZKAIid_as_and_SelectedGroupName_as_and_ActiveDutystudent_as(String EmgContact, String ZKAI_id) throws Throwable {
		StepDetailsPage lwp = new StepDetailsPage(driver);
		lwp.emergencyContact(EmgContact);
		lwp.ZKAImemberIDdetails(ZKAI_id);
		lwp.selectGroupNameDropdown();
		lwp.selectOpt1FromDropdownGroupName();
		lwp.actDutyStudDropdown();
		lwp.selectOpt1FromDropdownActDutyStud();
	}
	
	@And("^I click on pcCheckDevice button$")
	public void pcDeviceChkBtnClick() throws Throwable {
		StepDetailsPage lwp = new StepDetailsPage(driver);
		Thread.sleep(5000);
		lwp.pcDeviceChkBtn();
		Thread.sleep(3000);
		lwp.pcDeviceChkNextBtn();
		Thread.sleep(4000);
		lwp.pcDeviceChkNextBtn();
		Thread.sleep(3000);
		lwp.pcDeviceChkBackBtn();
	}
	
	@And("^I click on Confirm & Pay button$")
	public void clkConfirmPayBtn() throws InterruptedException{
		StepDetailsPage lwp = new StepDetailsPage(driver);
		Thread.sleep(3000);
		lwp.verifyExamFeesOnStep5();
		lwp.clkConfirmPay();	
	}
	
	
	@And("^I re-login before payment$")
	public void reloginAfterBooking() throws InterruptedException{
		LoginPage lwp = new LoginPage(driver);
		Thread.sleep(3000);
		lwp.reloginAfterBooking();
	}
	
	@And("^I complete payment details for booking$")
	public void completePayment() throws InterruptedException{
		StepDetailsPage lwp = new StepDetailsPage(driver);
		Thread.sleep(3000);
		lwp.clckRadioBtnRegistCard();
		lwp.addCardNumber("4111111111111111");
		lwp.monthExpiry();
		lwp.yearExpiry();
		lwp.cardHolder("Test");
		lwp.securityCode("123");
		lwp.finalPayBtn();
		Thread.sleep(3000);
		lwp.finalPayBtn();
		lwp.verifyExamFeesOnThanksPage();
	}

	@And("^I perfrom cancel booking from view reservation list$")
	public void viewResrvationList() throws InterruptedException{
		StepDetailsPage lwp = new StepDetailsPage(driver);
		Thread.sleep(2000);
		lwp.clkViewResrvationLstBtn();
		lwp.clkViewDetailBtn();
		Thread.sleep(2000);
		lwp.clkCancelReservationBtn();
		Thread.sleep(2000);
		lwp.clkCancelReservationBtn2();
		Thread.sleep(2000);
		lwp.clkCancelReservationBtn();	//locator is same for 'cancel your reservation' button and 'yes, cancel reservation' button	
	}
	
//	@And("^I click on logout button$")
//	public void logout() throws InterruptedException{
//		StepDetailsPage lwp = new StepDetailsPage(driver);
//		Thread.sleep(3000);
//		lwp.clkAccInfo();
//		Thread.sleep(4000);
//		lwp.clkLogOut();
//	}

	@And("^I perform edit booking$")
	public void editBooking() throws InterruptedException{
	StepDetailsPage lwp = new StepDetailsPage(driver);
	Thread.sleep(2000);
	lwp.clkViewResrvationLstBtn();
	Thread.sleep(2000);
	lwp.clkViewDetailBtn();
	Thread.sleep(2000);
	
	lwp.clkEditReservationBtn();
	
	Thread.sleep(3000);
	lwp.chksubjectRadioBtnHumanities();
	Thread.sleep(3000);
	lwp.clkWorldHistoryBChkBox();
	lwp.clkJapanesehistoryBChkBox();
	
	
	Thread.sleep(1000);
	lwp.selectScience();
	lwp.nextButton(); //next button clickedfor step 2
	Thread.sleep(3000);
	lwp.nextButton(); //next button clicked for step 3
	Thread.sleep(3000);
	lwp.nextButton(); //next button clicked for step 4
	
	Thread.sleep(5000);
	lwp.pcDeviceChkBtn();
	Thread.sleep(3000);
	lwp.pcDeviceChkNextBtn();
	Thread.sleep(4000);
	lwp.pcDeviceChkNextBtn();
	Thread.sleep(3000);
	lwp.pcDeviceChkBackBtn();
	lwp.nextButton();
	Thread.sleep(3000);
	lwp.clkEditReservationOKBtn();
	Thread.sleep(3000);
	lwp.clkConfirmPay();
	
	
	}
	@And ("^I close the browser$")
	public void closebrowser() throws Exception{
		Thread.sleep(5000);
		driver.close();
	
	}
	
	@And ("^I clear existing text$")
	public void clearExistingText() throws InterruptedException {
		StepDetailsPage lwp = new StepDetailsPage(driver);
		Thread.sleep(2000);
		lwp.clearExistingText();
		
	  }
	/**
	 * This method is used to enter firstname and lastname on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	@And("^I enter Firstaname as \"([^\"]*)\" and Lastname as \"([^\"]*)\" and FirstanameKana as \"([^\"]*)\" and LastnameKana as \"([^\"]*)\"$")
	public void i_enter_Firstaname_as_and_Lastname_as_and_FirstanameKana_as_and_LastnameKana_as(String fname, String lname, String fnamekana, String lnamekana) throws Throwable {
		StepDetailsPage lwp = new StepDetailsPage(driver);
		lwp.firstname(fname);
		lwp.lastname(lname);
		lwp.firstnamekana(fnamekana);
		lwp.lastnamekana(lnamekana);
		
	}
	/**
	 * This method is used to enter phoneno and pincode on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	@And("^I enter Phonenumber as \"([^\"]*)\" and PinocodeZone as \"([^\"]*)\" and PincodeSubzone \"([^\"]*)\"$")
	public void i_enter_Phonenumber_as_and_Pinocode_as_and_PinocodeZone_as_and_PincodeSubzone_as(String phnumber, String pcode1, String pcode2) throws Throwable {
		StepDetailsPage lwp = new StepDetailsPage(driver);
		lwp.phonenumber(phnumber);
		lwp.postalcode1(pcode1);
		lwp.postalcode2(pcode2);
		lwp.postalcode();
		
	}
	/**
	 * This method is used to enter address on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	@And("^I enter streetno as \"([^\"]*)\" and buildingno as \"([^\"]*)\"$")
	public void i_enter_street_as_and_building_as(String strno, String buldng) throws Throwable {
		StepDetailsPage lwp = new StepDetailsPage(driver);
	//	lwp.selectprefectureoption();
		lwp.street(strno);
		lwp.building(buldng);
		
	}

	/**
	 * This method is used to verify userinfo on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	@And ("^I verify name namekana username birthdate gender email address postalcode phonenumber on step5$")
	public void flname() throws Throwable {
		StepDetailsPage lwp = new StepDetailsPage(driver);
		lwp.verifyname();
    	lwp.verifyemail();
		lwp.verifyphoneno();
		lwp.verifyaddress();
		lwp.verifynameKana();
		lwp.verifydob();
		lwp.verifygender();
		lwp.verifyusername();
		lwp.verifypincode();
		
	
	}
	
	/**
	 * This method is used to verify examinfo on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */		
			
	@And ("^I verify examinfo on step5$")
	public void examinfo() throws Throwable {
		StepDetailsPage lwp = new StepDetailsPage(driver);
		lwp.verifytestname();
		lwp.verifytestcode();
    	lwp.verifyprerequisite();
    	lwp.verifysubject();
    	lwp.verifysociety();
    	lwp.verifyscience(); 
    //	lwp.verifyexamdate();
		
	
	}
	
	



}	






