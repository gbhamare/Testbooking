package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
import utils.CommonUtils;

public class StepDetailsPage extends CommonUtils {
	WebDriver driver;

	@FindBy(css = ".form-control#email")
	private WebElement eid;

	@FindBy(css = ".form-control#password")
	private WebElement password;

	@FindBy(css = ".button.button--default.button--uplarge.button--login.js-submit")
	private WebElement submitbtn;

	@FindBy(xpath = "//h1[contains(text(),'テストの選択')]") /* テストの選択 = Test Selection */
	private WebElement testSelection;

	@FindBy(css = ".radio.department-item.department-item:nth-of-type(2) span")
	private WebElement subjectRadioBtnScience;
	
	@FindBy(css = ".radio.department-item.department-item:nth-of-type(2) span.label")  // step1 science done by Girish
	private WebElement subjectScience;

	@FindBy(css = ".radio.department-item.department-item:nth-of-type(1) span")
	private WebElement subjectRadioBtnHumanities;
	
	@FindBy(css = ".radio.department-item.department-item:nth-of-type(1) span.label") // step1 humanities done by Girish
	private WebElement subjectHumanities;

	@FindBy(css = "div[class='subject-item__choose-list'] label[class='radio subject-item__choose']:nth-of-type(1)>span")
	private WebElement rbWorldHistoryB;

	@FindBy(css = "div[class='subject-item__choose-list'] label[class='radio subject-item__choose']:nth-of-type(2)>span")
	private WebElement rbJapanesehistoryB;
	
	@FindBy(css = "div[class='subject-item__choose-list'] label[class='radio subject-item__choose']:nth-of-type(3)>span")
	private WebElement rbGeographyB;
	
	@FindBy(css = "div[class='subject-item__choose-list'] label[class='radio subject-item__choose']:nth-of-type(4)>span")
	private WebElement rbEthics_politics_economy;
	
	@FindBy(css = "div[class='subject-item__choose-list'] label[class='radio subject-item__choose']:nth-of-type(5)>span")
	private WebElement rbmodern_society;	
	
	@FindBy(css = ".deparment-child:nth-of-type(2) div[class='subject-chooses'] .subject-chooses__item:nth-of-type(1) label>span")
	private WebElement chkWorldHistoryB;

	@FindBy(css = ".deparment-child:nth-of-type(2) div[class='subject-chooses'] .subject-chooses__item:nth-of-type(2) label>span")
	private WebElement chkJapanesehistoryB;
	
	@FindBy(css = ".deparment-child:nth-of-type(2) div[class='subject-chooses'] .subject-chooses__item:nth-of-type(3) label>span")
	private WebElement chkGeographyB;
	
	@FindBy(css = ".deparment-child:nth-of-type(2) div[class='subject-chooses'] .subject-chooses__item:nth-of-type(4) label>span")
	private WebElement chkEthics_politics_economy;
	
	@FindBy(css = ".deparment-child:nth-of-type(2) div[class='subject-chooses'] .subject-chooses__item:nth-of-type(5)>span")
	private WebElement chkmodern_society;
	
	@FindBy(css = ".deparment-child:nth-of-type(3) .subject-chooses .subject-chooses__item:nth-of-type(1) label>span")
	private WebElement chkFirstOption;
	
	@FindBy(css = ".deparment-child:nth-of-type(3) .subject-chooses .subject-chooses__item:nth-of-type(2) label>span")
	private WebElement chkSecondOption;
	
	@FindBy(css = ".deparment-child:nth-of-type(3) .subject-chooses .subject-chooses__item:nth-of-type(3) label>span")
	private WebElement chkThirdOption;
	
	@FindBy(css = ".rule__desc.rule-html li:nth-of-type(8)")
	private WebElement examination_rules;
	
	@FindBy(css = "#terms-content #term-detail p>p")
	private WebElement terms_of_use;
	
	@FindBy(css ="#terms-content .terms__box button")
	private WebElement btnTermLink;
	
	@FindBy(css = ".btn.btn-large.btn-normal")
	private WebElement backButton;
	
	@FindBy(css = ".btn.btn-large.btn-gradient")
	private WebElement nextButton;

	@FindBy(css = "#rule-checkbox .checkbox-slide")
	private WebElement checkBox1;
	
	@FindBy(css = "#term-checkbox .checkbox-slide")
	private WebElement checkBox2;
	
	@FindBy(css = "#emergency-contact")	//Emergency contact details displayed as "緊急連絡先" on step3 
	private WebElement emergencyContact;
	
	@FindBy(css = ".other-info-item .emergency-contact-input")	//Z-kai member ID field on Step 3
	private WebElement ZkaimemberID;
	
	@FindBy(css = ".info-form-row.info-form__other-info.row>div:nth-of-type(2) .ng-value-container")	//Selected Group Name on Step 3 NEED TO CHECK
	private WebElement sltGroupNameDropdown;
	
	@FindBy(css = ".info-form-row.info-form__other-info.row>div:nth-of-type(2) .ng-dropdown-panel .ng-option:nth-of-type(2)") //Option 1 'グループA' from Selected Group Name on Step 3
	private WebElement sltGroupNameOption1;
	
	@FindBy(css = ".info-form-row.info-form__other-info.row>div:nth-of-type(3) .ng-value-container")	//Active Duty Student Dropdown on Step 3 NEED TO CHECK
	private WebElement ActDutyStudentDropDown;
	
	@FindBy(css = ".info-form-row.info-form__other-info.row>div:nth-of-type(3) .ng-dropdown-panel .ng-option:nth-of-type(2)")	//Option 1 '現役生 ' on Step 3 
	private WebElement ActDutyStudentOpt1;
	
	//.checkpc-btn .btn.btn-medium.btn-normal.device-test__btn
	@FindBy(css = ".btn.btn-medium.btn-normal.device-test__btn") // PC Device Check button on Step 4
	private WebElement pcDeviceChkBtn;
	
	@FindBy(css = ".modal-header__btn.step-next .btn.btn-gradient") // PC Device Check Next button on Step 4
	private WebElement deviceChkNextTBtn;
	
	@FindBy(css = "#modal-check .modal-dialog .modal-header .close") // PC Device Check close button on Step 4
	private WebElement deviceChkCloseBtn;
	
	@FindBy(css = ".btn.btn-large.btn-gradient.btn-payment-status") // Payment Button Step 5
	private WebElement ConfirmPayBtn;
	
	@FindBy(css = ".box-payment-method #register") // Register card radio button
	private WebElement registerYourCard;
	
	@FindBy(css = "#cardno") // Card no. field
	private WebElement addCardNo;
	
	@FindBy(css = "span[aria-labelledby='select2-expire-month-container']") // Card month expiry dropdown
	private WebElement cardMonthExpiry;
	
	@FindBy(css = "#select2-expire-month-results li:nth-of-type(3)") // Select Month Expiry
	private WebElement slctMonthExp;
	
	@FindBy(css = "span[aria-labelledby='select2-expire-year-container']") // Card year expiry dropdown
	private WebElement cardyearExpiry;
		
	@FindBy(css = "#select2-expire-year-results li:nth-of-type(3)") // Select Year Expiry
	private WebElement slctYearExp;
	
	@FindBy(css = ".form-control#holdername") // Card holder textfield
	private WebElement cardHolderTxtfield;
	
	@FindBy(css = ".form-control#securitycode") // Card Security textfield
	private WebElement cardSecurityCode;
	
	@FindBy(css = ".button#finalizeButton") // Card FinalPayment Button
	private WebElement finalPaymentBtn;
	
	@FindBy(css = ".group-button__right") // Thankyou page View Reservation List Button
	private WebElement viewReservationListBtn;
		
	@FindBy(css = ".btn.view-detail-btn") // View the Details Button
	private WebElement viewDetailBtn;
	
	@FindBy(css = ".btn.btn-medium.btn-red") // View the Details Button
	private WebElement cancelYourReservation1;
	
	@FindBy(css = ".btn.btn-large.btn-red") // View the Details Button
	private WebElement cancelYourReservation2;
	
	@FindBy(css = ".header__user-list") // Account information dropdown
	private WebElement accInfoDropDown;
	
	@FindBy(css = ".dropdown-menu__item:nth-of-type(2)") // Logout link option
	private WebElement logOut;
		
	@FindBy(css = ".booking-navigator__button .btn.btn-medium.btn-gradient") // Edit reservation button
	private WebElement editReservationBtn;
	
	@FindBy(css = "#modal-confirm-edit .modal-footer .btn.btn-medium.btn-gradient") // Edit reservation Okay button in pop-up
	private WebElement editReservationOkayBtn;
		
	@FindBy(css = ".card__content:nth-of-type(3) .card__content-desc.check-tooltip") // Step 1 Exam Fee
	private WebElement examFeeStep1;
	
	@FindBy(css = ".test-info:nth-of-type(1) .info-section__part:nth-of-type(2) .info-row:nth-of-type(3) .info-row__val") // Step 5 Exam Fee
	private WebElement examFeeStep5;
	
	@FindBy(css = ".test-info:nth-of-type(1) .info-section__part:nth-of-type(2) .info-row:nth-of-type(3) .info-row__val") // Step 5 Exam Fee
	private WebElement examFeeThanksPage;
	
	
	
	@FindBy(css = ".btn-medium.btn-white.booking__button-show") 
	private WebElement btnDetails;
	
	@FindBy(css = ".info-detail-item.basic-info__dob .info-val.text") // Step 3 date of birthdate by Girish
	private WebElement dob;
	
	@FindBy(css = ".user-info.info-section .info-section__part:nth-of-type(1) .info-row:nth-of-type(1) .info-row__val")  // Step 5 date of birthdate by Girish
	private WebElement dobstep5;
	
	@FindBy(css = ".row.info-test .test-info.info-section:nth-of-type(1) .info-section__part:nth-of-type(1) .info-row:nth-of-type(1) .info-row__val")  // current booking date of birthdate by Girish
	private WebElement dobcb;
	
	@FindBy(css = ".info-detail-item.basic-info__gender .info-val")  // Step 3 gender by Girish
	private WebElement gender;
	
	@FindBy(css = ".user-info.info-section .info-section__part:nth-of-type(1) .info-row:nth-of-type(2) .info-row__val") // Step 5 gender by Girish
	private WebElement genderstep5;
	
	@FindBy(css = ".row.info-test .test-info.info-section:nth-of-type(1) .info-section__part:nth-of-type(1) .info-row:nth-of-type(2) .info-row__val") // current booking gender by Girish
	private WebElement gendercb;
	
	@FindBy(css = ".info-detail-item.basic-info__user-name .info-val.text") // step3 user name by Girish
	private WebElement username;
	
	@FindBy(css = ".user-info.info-section .info-section__part:nth-of-type(1) .info-row:nth-of-type(3) .info-row__val") // step5 user name by Girish
	private WebElement usernamestep5;
	
	@FindBy(css = ".row.info-test .test-info.info-section:nth-of-type(1) .info-section__part:nth-of-type(1) .info-row:nth-of-type(3) .info-row__val") // current booking user name by Girish
	private WebElement usernamecb;
	
	@FindBy(css = ".info-form__field .email-field")  //step3 email by Girish
	private WebElement email;
	
	@FindBy(css = ".user-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(3) .info-row__val") //step5 email by Girish
	private WebElement emailstep5;
	
	@FindBy(css = "#first-name") //step3 firstname by Girish
	private WebElement firstname;
	
	@FindBy(css = "#last-name")   //step3 lastname by Girish
	private WebElement lastname;
	
	@FindBy(css = ".user-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(1) .info-row__val")  //step5 firstnlastname by Girish
	private WebElement flnamestep5;
	
	
	
	@FindBy(css = "#first-name-kana")  //step3 firstnamekana by Girish
	private WebElement firstnamekana;
	
	@FindBy(css = "#last-name-kana")  //step3 lastnamekana by Girish

	private WebElement lastnamekana;
	
	@FindBy(css = ".user-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(2) .info-row__val") //step5 fistnlastnamekana by Girish
	private WebElement flnamekanastep5;
	
	
	@FindBy(css = "#phone-num")  //step3 phonenumber by Girish
	private WebElement phonenumber;
	
	@FindBy(css = ".user-info.info-section .info-row:nth-of-type(4) .info-row__val") //step5 phonenumber by Girish
	private WebElement phonenostep5;
	
	@FindBy(css = "#postal-code1")  //step3 pinnumber1 by Girish
	private WebElement postalcode1;
	
	@FindBy(css = "#postal-code2")  //step3 pinnumber1 by Girish
	private WebElement postalcode2;
	
	@FindBy(css = "#postal-code")   //step3 pinnumber by Girish
	private WebElement postalcode;
	
	@FindBy(css = ".user-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(5) .info-row__val")  //step5 pinnumber by Girish
	private WebElement postalcodestep5;
	
	@FindBy(css = "#street")   //step3 street by Girish
	private WebElement street;
	
	@FindBy(css = ".info-form-row.prefecture-info.row>div:nth-of-type(1) .ng-value-container") //step3 perfecture by Girish
	private WebElement prefecture;
	
	
	@FindBy(css = "#city")  //step3 city by Girish
	private WebElement city;
	
	@FindBy(css = "#town")  //step3 town by Girish
	private WebElement town;
	
	@FindBy(css = "#building")  //step3 town by Girish
	private WebElement building;
	
	@FindBy(css = ".user-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(6) .info-row__val") //step5 address by Girish
	private WebElement adrresstep5;
	
	@FindBy(css = ".test-name .test-name__text")  //step1 testname by Girish
	private WebElement testname;
	
	@FindBy(css = ".test-info.info-section .info-section__part:nth-of-type(1) .info-row:nth-of-type(1) .info-row__val") //step5 testname by Girish
	private WebElement testnamestep5;
	
	@FindBy(css = ".card__content:nth-of-type(2) .card__content-desc.check-tooltip")  //step1 testcode by Girish
	private WebElement testcode;
	
	@FindBy(css = ".test-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(2) .info-row__val")  //step5 testcode by Girish
	private WebElement testcodestep5;
	
	
	@FindBy(css = ".card__content:nth-of-type(4) .card__content-desc.check-tooltip") //step1 pre-requisite by Girish
	private WebElement prerequisite; 
	
	@FindBy(css = ".test-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(4) .info-row__val")  //step5 pre-requisite by Girish
	private WebElement prerequisitestep5;
	
	@FindBy(css = "span.label")  //step4 examdate by Girish
	private WebElement examdate;
	
	@FindBy(css = ".test-info.info-section .info-section__part:nth-of-type(3) .info-row:nth-of-type(2) .info-row__val")  //step5 examdate by Girish
	private WebElement examdatestep5;
	
	
	@FindBy(css = ".test-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(5) .info-row__val")  //step5 subject by Girish
	private WebElement subjectstep5;
	
	@FindBy(css = ".test-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(6) .info-row__val")  //step5 society by Girish
	private WebElement societystep5;
	
	@FindBy(css = ".test-info.info-section .info-section__part:nth-of-type(2) .info-row:nth-of-type(7) .info-row__val")  //step5 science by Girish
	private WebElement sciencestep5;
	
	@FindBy(css = ".progress__item-title.btn.btn-noline:nth-of-type(2)")  //candidate information on current booking by Girish
	private WebElement userinfo;
	
	@FindBy(css = ".progress__item-title.btn.btn-noline:nth-of-type(1)")   //exam  information on current booking by Girish
	private WebElement examinfo;
	
	
	
	
	static String examFees="";    
	static String dobValue="";    		// step3 dob by Girish
	static String genderValue=""; 		// step3 gender by Girish
	static String usernameValue="";		// step3 username by Girish
	static String emailValue="";		// step3 email by Girish
	static String fnameValue="";		// step3 fname by Girish
	static String lnameValue="";		// step3 lname by Girish
	static String fnamekanaValue="";	// step3 fnamekana by Girish
	static String lnamekanaValue="";	// step3 lnamekana by Girish
	static String pincode1Value="";		// step3 pincode1 by Girish
	static String pincode2Value="";		// step3 pincode2 by Girish
	static String cityValue="";			// step3 city by Girish
	static String townValue="";			// step3 town by Girish
	static String streetValue="";		// step3 street by Girish
	static String buildingValue="";		// step3 building by Girish
	static String prefectureValue="";	// step3 prefecture by Girish
	static String phonenoValue="";		// step3 phoneno by Girish
//	static String defaultItem="";		// step3 dob by Girish
	static String testnameValue="";		// step1 testname by Girish
	static String testcodeValue="";		// step1  testcode by Girish
	static String prerequisitesValue="";// step1 prerequisite by Girish
	static String subjectscineceValue="";// step1 subjectscinece by Girish
	static String examdateValue="";		// step4 examdate by Girish
	static String societyjpnValue="";	// step1 societyjpn by Girish
	static String sciencechmvalue="";	// step1 sciencechm by Girish
	static String sciencebioValue="";	// step1 sciencebio by Girish
	  
	
	
	public StepDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to select subject
	 * '
	 * @throws InterruptedException 
	 * 
	 */
	public void subjectRadioButton(String subject) throws InterruptedException {
		waitForElement(testname);			// get testnameValue on step1 by Girish
		testnameValue = testname.getText();      
		
		bringElementIntoView(testcode); 	// get testcodeValue on step1 by Girish
		testcodeValue = testcode.getText();
		
		bringElementIntoView(prerequisite);	  		// get prerequisitesValue on step1 by Girish
		prerequisitesValue = prerequisite.getText();
		
		waitForElement(examFeeStep1);
		examFees = examFeeStep1.getText().split(" ")[0];
		System.out.println("Actual Exam Fees:- "+examFees);
		
		bringElementIntoView(subjectRadioBtnScience);
		subjectscineceValue = subjectScience.getText();
		
		if (subject.equalsIgnoreCase("Science")) {
			subjectRadioBtnScience.click();
		} else {
			subjectRadioBtnHumanities.click();
		}
	}
	
	/**
	 * This method is used to select society
	 * '
	 * @throws InterruptedException 
	 * 
	 */
	public void selectSociety(String subject) throws InterruptedException {
		
		bringElementIntoView(rbJapanesehistoryB);   		// get societyjpnValue on step1 by Girish
		societyjpnValue = rbJapanesehistoryB.getText();
		
		
		if(subject.equalsIgnoreCase("Science")){
			rbJapanesehistoryB.click();
		}else{
			chkWorldHistoryB.click();
			chkJapanesehistoryB.click();
		}
		
	}

	/**
	 * This method is used to select society
	 * '
	 * @throws InterruptedException 
	 * 
	 */
	public void selectScience() throws InterruptedException {
		bringElementIntoView(chkSecondOption);
		chkSecondOption.click();
		sciencechmvalue = chkSecondOption.getText();  		// get sciencechmvalue on step1 by Girish
		
		bringElementIntoView(chkThirdOption);
		chkThirdOption.click();
		sciencebioValue = chkThirdOption.getText();
	}
	
	
	/**
	 * This method is used to click on Next button to Navigate to Step 2
	 * @throws InterruptedException 
	 * 
	 */
	public void nextButton() throws InterruptedException {
		bringElementIntoView(nextButton);
		nextButton.click();
	}
	
	/**
	 * This method is used to select check box present on step 2
	 * @throws InterruptedException 
	 * 
	 */
	public void selectCheckBoxOnStep2() throws InterruptedException {
		bringElementIntoView(driver.findElement(By.id("rule-desc")));
		Actions actions = new Actions(driver);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('rule-detail').scrollTop= 10000");
		
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
//		//bringElementIntoView(driver.findElement(By.id("#terms-content")));
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		bringElementIntoView(checkBox1);	
		checkBox1.click();
		Thread.sleep(5000);
	//	bringElementIntoView(backButton);
		bringElementIntoView(driver.findElement(By.id("term-detail")));	
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('term-detail').scrollTop= 3900");
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)", "");
     	bringElementIntoView(checkBox2);												// uncommented for step2 by Girish
//		nextButton.click();
		checkBox2.click();																// uncommented for step2 by Girish
	}
	
	/**
	 * This method is used add Emergency contact details '緊急連絡先' in Step 3
	 * @throws InterruptedException 
	 * 
	 */
	public void emergencyContact(String contact) throws InterruptedException{
		Thread.sleep(5000);
		bringElementIntoView(emergencyContact);
		emergencyContact.sendKeys(contact);   				
	}
	
	/**
	 * This method is used to add ZKAI member ID 'Z会会員ID' in Step 3
	 * @throws InterruptedException 
	 * 
	 */	
	public void ZKAImemberIDdetails(String ZKAIid) throws InterruptedException{
		Thread.sleep(1000);
		bringElementIntoView(ZkaimemberID);
		ZkaimemberID.sendKeys(ZKAIid);
	}
	
	/**
	 * This method is used to select Group Name '選択グループ名' in Step 3
	 * @throws InterruptedException 
	 * 
	 */	
	public void selectGroupNameDropdown() throws InterruptedException{
		bringElementIntoView(sltGroupNameDropdown);
		sltGroupNameDropdown.click();
	}
	
	/**
	 * This method is used to select 1st option in Group Name 'グループA' in Step 3
	 * @throws InterruptedException 
	 * 
	 */	
	public void selectOpt1FromDropdownGroupName() throws InterruptedException{
		bringElementIntoView(sltGroupNameOption1);
		sltGroupNameOption1.click();
	}
	
	/**
	 * This method is used to click Active Duty Student dropdown in Step 3
	 * @throws InterruptedException 
	 * 
	 */	
	public void actDutyStudDropdown() throws InterruptedException{
		bringElementIntoView(ActDutyStudentDropDown);
		ActDutyStudentDropDown.click();
	}
	
	/**
	 * This method is used to select option 1 as '現役生 ' click Active Duty Student dropdown in Step 3
	 * @throws InterruptedException 
	 * 
	 */	
	public void selectOpt1FromDropdownActDutyStud() throws InterruptedException{
		bringElementIntoView(ActDutyStudentOpt1);
		ActDutyStudentOpt1.click();
	}
	
	/**
	 * This method is used to clickon PC Device Check button
	 * @throws InterruptedException 
	 * 
	 */	
	public void pcDeviceChkBtn() throws InterruptedException{
		Thread.sleep(5000);
		bringElementIntoView(pcDeviceChkBtn);
		pcDeviceChkBtn.click();
	}
	/**
	 * This method is used to click on PC Device Check NEXT button
	 * @throws InterruptedException 
	 * 
	 */	
	public void pcDeviceChkNextBtn()throws InterruptedException{
		
//		bringElementIntoView(examdate);					// get examdateValue on step4 by Girish
//		examdateValue = examdate.getText();
		
		
		waitForElement(deviceChkNextTBtn);
		deviceChkNextTBtn.click();
	}
	/**
	 * This method is used to click on PC Device Check ClOSE button
	 * @throws InterruptedException 
	 * 
	 */	
	public void pcDeviceChkBackBtn(){
		waitForElement(deviceChkCloseBtn);
		deviceChkCloseBtn.click();
	}

	/**
	 * This method is used to click on Confirm and Payment button
	 * @throws InterruptedException 
	 * 
	 */	
	public void clkConfirmPay() throws InterruptedException{
		Thread.sleep(3000);
		bringElementIntoView(ConfirmPayBtn);
		ConfirmPayBtn.click();
	}
	
	/**
	 * This method is used to check second radio button on Register your card information
	 * @throws InterruptedException 
	 * 
	 */	
	public void clckRadioBtnRegistCard() throws InterruptedException{
		Thread.sleep(3000);
		bringElementIntoView(registerYourCard);
		registerYourCard.findElement(By.xpath("../label")).click();
	}
	
	/**
	 * This method is used add card no. in Register your card information
	 * @throws InterruptedException 
	 * 
	 */	
	public void addCardNumber(String CardNo) throws InterruptedException{
		
		bringElementIntoView(addCardNo);
		addCardNo.sendKeys(CardNo);
	}
	
	/**
	 * This method is used select month expiry on Register your card information
	 * @throws InterruptedException 
	 * 
	 */	
	public void monthExpiry() throws InterruptedException{
	
		bringElementIntoView(cardMonthExpiry);
		cardMonthExpiry.click();
		bringElementIntoView(slctMonthExp);
		slctMonthExp.click();
	}
	
	/**
	 * This method is used select year expiry on Register your card information
	 * @throws InterruptedException 
	 * 
	 */	
	public void yearExpiry() throws InterruptedException{
		bringElementIntoView(cardyearExpiry);
		cardyearExpiry.click();
		bringElementIntoView(slctYearExp);
		slctYearExp.click();
	}
	
	
	
	/**
	 * This method is used to add card holder name on Register your card information
	 * @throws InterruptedException 
	 * 
	 */	
	public void cardHolder(String CrdHolder) throws InterruptedException{
		bringElementIntoView(cardHolderTxtfield);
		cardHolderTxtfield.sendKeys(CrdHolder);
	}
	
	/**
	 * This method is used to add security code on Register your card information
	 * @throws InterruptedException 
	 * 
	 */	
	public void securityCode(String sctyCode) throws InterruptedException{
		bringElementIntoView(cardSecurityCode);
		cardSecurityCode.sendKeys(sctyCode);
	}
	/**
	 * This method is used to click on FinalizePayment button to Navigate to Step 2
	 * @throws InterruptedException 
	 * 
	 */
	public void finalPayBtn() throws InterruptedException {
		bringElementIntoView(finalPaymentBtn);
		finalPaymentBtn.click();
	}
	
	/**
	 * This method is used to click on View Reservation List button on Step 6
	 * @throws InterruptedException 
	 * 
	 */
	public void clkViewResrvationLstBtn() throws InterruptedException {
		bringElementIntoView(viewReservationListBtn);
		viewReservationListBtn.click();
	}
	
	/**
	 * This method is used to click on View the Detail detail button in Reservation List page
	 * @throws InterruptedException 
	 * 
	 */
	public void clkViewDetailBtn() throws InterruptedException {
		bringElementIntoView(viewDetailBtn);
		viewDetailBtn.click();
	}
	
	/**
	 * This method is used to click on Cancel Your Reservation button in Reservation List page
	 * @throws InterruptedException 
	 * 
	 */
	public void clkCancelReservationBtn() throws InterruptedException {
		bringElementIntoView(cancelYourReservation1);
		cancelYourReservation1.click();
	}
	
	/**
	 * This method is used to click on Cancel Your Reservation button in cancellation page within Reservation list tab
	 * @throws InterruptedException 
	 * 
	 */
	public void clkCancelReservationBtn2() throws InterruptedException {
		bringElementIntoView(cancelYourReservation2);
		cancelYourReservation2.click();
	}
	
	/**
	 * This method is used to click on account information option
	 * @throws InterruptedException 
	 * 
	 */
	public void clkAccInfo() throws InterruptedException {
		bringElementIntoView(accInfoDropDown);
		accInfoDropDown.click();
	}
	
	/**
	 * This method is used to click on logout link option
	 * @throws InterruptedException 
	 * 
	 */
	public void clkLogOut() throws InterruptedException {
		bringElementIntoView(logOut);
		logOut.click();
	}
	

	/**
	 * This method is used to click on account information option
	 * @throws InterruptedException 
	 * 
	 */
	public void chksubjectRadioBtnHumanities() throws InterruptedException {
		bringElementIntoView(subjectRadioBtnHumanities);
		subjectRadioBtnHumanities.click();
	}
	
	/**
	 * This method is used to click on rbWorldHistoryB checkbox
	 * @throws InterruptedException 
	 * 
	 */
	public void clkWorldHistoryBChkBox() throws InterruptedException {
		bringElementIntoView(chkWorldHistoryB);
		chkWorldHistoryB.click();
	}
	
	/**
	 * This method is used to click on rbWorldHistoryB checkbox
	 * @throws InterruptedException 
	 * 
	 */
	public void clkJapanesehistoryBChkBox() throws InterruptedException {
		bringElementIntoView(chkJapanesehistoryB);
		chkJapanesehistoryB.click();		
	}
	
	/**
	 * This method is used to click on edit reservation button
	 * @throws InterruptedException 
	 * 
	 */
	public void clkEditReservationBtn() throws InterruptedException {
		bringElementIntoView(editReservationBtn);
		editReservationBtn.click();
	}
	
	/**
	 * This method is used to click on edit reservation Okay button
	 * @throws InterruptedException 
	 * 
	 */
	public void clkEditReservationOKBtn() throws InterruptedException {
		bringElementIntoView(editReservationOkayBtn);
		editReservationOkayBtn.click();
	}
	
	/**
	 * This method is used to verify payment on step 5
	 * @throws InterruptedException 
	 * 
	 */	
	public void verifyExamFeesOnStep5() throws InterruptedException{
		
		bringElementIntoView(examFeeStep5);
		System.out.println(examFeeStep5.getText());
		String feesOnStep5 = examFeeStep5.getText().split("\\n")[0];
		System.out.println("Expected "+examFees.trim());
		System.out.println("Actual "+feesOnStep5.trim()); 
		System.out.println("Fees on step 5:- "+examFees.trim().contains(feesOnStep5.trim()));
		Assert.assertTrue(examFees.trim().contains(feesOnStep5.trim()));
	}
	
	
	/**
	 * This method is used to click on detail button present on thank you page
	 * @throws InterruptedException 
	 * 
	 */
	public void clickOnDetailsButton() throws InterruptedException {
		bringElementIntoView(btnDetails);
		btnDetails.click();
	}
	
	/**
	 * This method is used to verify payment on thank you page
	 * @throws InterruptedException 
	 * 
	 */	
	public void verifyExamFeesOnThanksPage() throws InterruptedException{
		
		bringElementIntoView(btnDetails);
		btnDetails.click();
		bringElementIntoView(examFeeThanksPage);
		waitForElement(examFeeThanksPage);
		System.out.println(examFeeThanksPage.getText());
		String feesOnStep5 = examFeeStep5.getText().split("\\n")[0];
		System.out.println("Expected "+examFees.trim());
		System.out.println("Actual "+feesOnStep5.trim());
		System.out.println("Fees on Thankyou page- "+examFees.trim().contains(feesOnStep5.trim()));
		Assert.assertTrue(examFees.trim().contains(feesOnStep5.trim()));
	}

//	public void clearExistingText() throws InterruptedException {

//		firstname.clear();
//		lastname.clear();
//		firstnamekana.clear();
//		lastnamekana.clear();
//		phonenumber.clear();
//		postalcode1.clear();
//		postalcode2.clear();
//		prefecture.clear();
//		city.clear();
//		town.clear();
		
//	  }
	
	/**
	 * This method is used to clear default userinfo on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */	
	
	 public void clearExistingText(){
		 	firstname.clear();
		 	lastname.clear();
			firstnamekana.clear();
			lastnamekana.clear();
			phonenumber.clear();
			postalcode1.clear();
			postalcode2.clear();
			city.clear();
		    town.clear();
		    street.clear();
		    building.clear();
	 }
	
	 /**
		 * This method is used to enter firstname on step 3 by Girish
		 * @throws InterruptedException 
		 * 
		 */	
	
	public void firstname(String fname) throws InterruptedException{
		bringElementIntoView(dob);
		dobValue = dob.getText();
		
		bringElementIntoView(username);
		usernameValue = username.getText();
		
		bringElementIntoView(gender);
		genderValue = gender.getText();
		
		bringElementIntoView(email);
		emailValue = email.getText();
		
		bringElementIntoView(firstname);
		firstname.sendKeys(fname);
		
		fnameValue =firstname.getAttribute("value");
	}
	
	/**
	 * This method is used to enter lastname on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */		
	
	
	public void lastname(String lname) throws InterruptedException{
	
	bringElementIntoView(lastname);
	lastname.sendKeys(lname);

	lnameValue =lastname.getAttribute("value");
	
	}

	
	/**
	 * This method is used to enter firstnamekana on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	
	public void firstnamekana(String fnamekana) throws InterruptedException{
		
		bringElementIntoView(firstnamekana);
		firstnamekana.sendKeys(fnamekana);
	
		fnamekanaValue =firstnamekana.getAttribute("value");
	}
	
	/**
	 * This method is used to enter lastnamekana on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	public void lastnamekana(String lnamekana) throws InterruptedException{
		
		bringElementIntoView(lastnamekana);
		lastnamekana.sendKeys(lnamekana);
		
		lnamekanaValue =lastnamekana.getAttribute("value");
	}

	/**
	 * This method is used to enter phonenumber on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	
	public void phonenumber(String phnumber) throws InterruptedException{
		
		bringElementIntoView(phonenumber);
		phonenumber.sendKeys(phnumber);
		phonenoValue =phonenumber.getAttribute("value");
	
	}
	
	/**
	 * This method is used to enter postalcode1 on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	
	public void postalcode1(String pcode1) throws InterruptedException{
		
		bringElementIntoView(postalcode1);
		postalcode1.sendKeys(pcode1);
	
		pincode1Value =postalcode1.getAttribute("value");
	
	}
	
	/**
	 * This method is used to enter postalcode2 on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	public void postalcode2(String pcode2) throws InterruptedException{
		
		bringElementIntoView(postalcode2);
		postalcode2.sendKeys(pcode2);
	
		pincode2Value =postalcode2.getAttribute("value");
	}
	/**
	 * This method is used to click  postalcode on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	
	public void postalcode() throws InterruptedException {
		bringElementIntoView(postalcode);
		postalcode.click();
	}
	
	/**
	 * This method is used to enter street on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	
	
	public void street(String strno) throws Exception{
		
			
		bringElementIntoView(city);
		cityValue =city.getAttribute("value");
		
		bringElementIntoView(town);
		townValue =town.getAttribute("value");
		
		
		
		bringElementIntoView(prefecture);
	//	prefectureValue =prefecture.getText();
		
	//	Select prefecture = new Select(driver.findElement(By.cssSelector(".info-form-row.prefecture-info.row .ng-select-container.ng-has-value .ng-value-container .ng-input")));
		prefectureValue = prefecture.getText();
		
	bringElementIntoView(street);	
	street.sendKeys(strno);
	streetValue =street.getAttribute("value");
		
	}
	
	/**
	 * This method is used to enter building on step 3 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	
	public void building(String buldng) throws InterruptedException{
		
		bringElementIntoView(building);
		building.sendKeys(buldng);
	
		buildingValue =building.getAttribute("value");
	}
	
	/**
	 * This method is used to verify phoneno on step 5 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	
	public void verifyphoneno () throws Exception{
		
		bringElementIntoView(phonenostep5);
		waitForElement(phonenostep5);
	//	System.out.println(phonenostep5.getText());
		String ActphonenoStep5 = phonenostep5.getText();
		System.out.println("Actual phoneno "+  ActphonenoStep5);
		System.out.println("Expected phoneno "+  phonenoValue);
		Assert.assertEquals(phonenoValue, ActphonenoStep5);
	}

	
	/**
	 * This method is used to verify name on step 5 by Girish
	 * @throws InterruptedException 
	 * 
	 */
	
		public void verifyname() throws Exception{
		
		bringElementIntoView(flnamestep5);
		waitForElement(flnamestep5);
	
		String Actflnamestep5 = flnamestep5.getText();
		System.out.println("Expected name "+  Actflnamestep5);
		System.out.println("Actual name "+  fnameValue+" " + lnameValue);
		Assert.assertEquals(Actflnamestep5.trim(), fnameValue+" " + lnameValue);
		
		 	
		}

		/**
		 * This method is used to verify nameKana on step 5 by Girish
		 * @throws InterruptedException 
		 * 
		 */		
		public void verifynameKana() throws Exception{
			
			bringElementIntoView(flnamekanastep5);
			waitForElement(flnamekanastep5);
		
			String Actflnamekanastep5 = flnamekanastep5.getText();
			System.out.println("Expected namekana "+  Actflnamekanastep5.trim());
			System.out.println("Actual namekana "+  fnamekanaValue+" " + lnamekanaValue);
			Assert.assertEquals(Actflnamekanastep5.trim(), fnamekanaValue+" " + lnamekanaValue);
			
		}

		/**
		 * This method is used to verify dob on step 5 by Girish
		 * @throws InterruptedException 
		 * 
		 */	
			public void verifydob() throws Exception{
			
			bringElementIntoView(dobstep5);
			waitForElement(dobstep5);
		
			String Actdobstep5 = dobstep5.getText();
			System.out.println("Expected dob "+  Actdobstep5.trim());
			System.out.println("Actual dob "+  dobValue);
			Assert.assertEquals(Actdobstep5.trim(), dobValue);
			
		}
			

			
	/**
	 * This method is used to verify email on step 5 by Girish
	 * @throws InterruptedException 
	 * 
	 */			
		public void verifyemail() throws Exception{
				
			bringElementIntoView(emailstep5);
				waitForElement(emailstep5);
		
				String Actemailstep5 = emailstep5.getText();
				System.out.println("Expected email "+  Actemailstep5.trim());
				System.out.println("Actual email "+  emailValue);
				Assert.assertEquals(Actemailstep5.trim(), emailValue);
		}
		/**
		 * This method is used to verify username on step 5 by Girish
		 * @throws InterruptedException 
		 * 
		 */			
		
		public void verifyusername() throws Exception{
				
			bringElementIntoView(usernamestep5);
			waitForElement(usernamestep5);
			
			String Actusernamestep5 = usernamestep5.getText();
			System.out.println("Expected username "+  Actusernamestep5.trim());
			System.out.println("Actual username "+  usernameValue);
			Assert.assertEquals(Actusernamestep5.trim(), usernameValue);
				
		}
	
	/**
	 * This method is used to verify gender on step 5 by Girish
	 * @throws InterruptedException 
	 * 
	 */			
	public void verifygender() throws Exception{
					
		bringElementIntoView(genderstep5);
		waitForElement(genderstep5);
				
		String Actulgenderstep5 = genderstep5.getText();
		System.out.println("Expected gender "+  Actulgenderstep5.trim());
		System.out.println("Actual gender "+  genderValue);
		Assert.assertEquals(Actulgenderstep5.trim(), genderValue);
					
	}
	/**
	 * This method is used to verify  pincode on step 5 by Girish
	 * @throws InterruptedException 
	 * 
	 */	
		public void verifypincode() throws Exception{
					
		bringElementIntoView(postalcodestep5);
		waitForElement(postalcodestep5);
				
		String Actpostalcodestep5 = postalcodestep5.getText();
		System.out.println("Expected pincode "+  Actpostalcodestep5.trim());
		System.out.println("Actual pincode "+  pincode1Value+"-" + pincode2Value);
		Assert.assertEquals(Actpostalcodestep5.trim(), pincode1Value+"-" + pincode2Value);
					
	}
		/**
		 * This method is used to verify  address on step 5 by Girish
		 * @throws InterruptedException 
		 * 
		 */

		public void verifyaddress() throws Exception{
					
		bringElementIntoView(adrresstep5);
		waitForElement(adrresstep5);
				
		String Actadrresstep5 = adrresstep5.getText();
		System.out.println("Expected address "+  Actadrresstep5.trim());
		System.out.println("Actual address "+  prefectureValue+" " + cityValue+" " + townValue+" " + streetValue+" " + buildingValue);
		Assert.assertEquals(Actadrresstep5.trim(), prefectureValue+" " + cityValue+" " + townValue+" " + streetValue+" " + buildingValue);
					
		}
		/**
		 * This method is used to verify  testname on step 5 by Girish
		 * @throws InterruptedException 
		 * 
		 */
					
		public void verifytestname() throws Exception{
						
		bringElementIntoView(testnamestep5);
		waitForElement(testnamestep5);
					
		String Actultestnamestep5 = testnamestep5.getText();
		System.out.println("Expected testname "+  Actultestnamestep5.trim());
		System.out.println("Actual testname "+  testnameValue);
		Assert.assertEquals(Actultestnamestep5.trim(), testnameValue);
						
		}
					
		/**
		 * This method is used to verify  testcode on step 5 by Girish
		 * @throws InterruptedException 
		 * 
		 */					
					
	public void verifytestcode() throws Exception{
						
	bringElementIntoView(testcodestep5);
	waitForElement(testcodestep5);
					
		String Actulcodestep5 = testcodestep5.getText();
		System.out.println("Expected testcode "+  Actulcodestep5.trim());
		System.out.println("Actual testcode "+  testcodeValue);
		Assert.assertEquals(Actulcodestep5.trim(), testcodeValue);			
		}	
	/**
	 * This method is used to verify  prerequisite on step 5 by Girish
	 * @throws InterruptedException 
	 * 
	 */			
		public void verifyprerequisite() throws Exception{
							
		bringElementIntoView(prerequisitestep5);
		waitForElement(prerequisitestep5);
						
		String Actulprerequisitestep5 = prerequisitestep5.getText();
		System.out.println("Expected prerequisite "+  Actulprerequisitestep5.trim());
		System.out.println("Actual prerequisite "+  prerequisitesValue);
		Assert.assertEquals(Actulprerequisitestep5.trim(), prerequisitesValue);
		}	
	
		
		/**
		 * This method is used to verify  subject on step 5 by Girish
		 * @throws InterruptedException 
		 * 
		 */							
		public void verifysubject() throws Exception{
							
	    bringElementIntoView(subjectstep5);
	    waitForElement(subjectstep5);
						
		String Actulsubjecttestep5 = subjectstep5.getText();
		System.out.println("Expected subject "+  Actulsubjecttestep5.trim());
		System.out.println("Actual subject "+  subjectscineceValue);
		Assert.assertEquals(Actulsubjecttestep5.trim(), subjectscineceValue);
							
		}
					
		
		
		/**
		 * This method is used to verify  society on step 5 by Girish
		 * @throws InterruptedException 
		 * 
		 */		
		

	public void verifysociety() throws Exception{
							
	bringElementIntoView(societystep5);
	waitForElement(societystep5);
						
	String Actulsocietystep5 = societystep5.getText();
	System.out.println("Expected society "+  Actulsocietystep5.trim());
	System.out.println("Actual society "+  societyjpnValue);
	Assert.assertEquals(Actulsocietystep5.trim(), societyjpnValue);
							
	}

	
	/**
	 * This method is used to verify science on step 5 by Girish
	 * @throws InterruptedException 
	 * 
	 */		
		
	public void verifyscience() throws Exception{
							
	bringElementIntoView(sciencestep5);
	waitForElement(sciencestep5);
						
	String Actulsciencestep5 = sciencestep5.getText();
	System.out.println("Expected science "+  Actulsciencestep5.trim());
	System.out.println("Actual science "+  sciencechmvalue+", " + sciencebioValue);
	Assert.assertEquals(Actulsciencestep5.trim(), sciencechmvalue+", " + sciencebioValue);
	}
					

	
	/**
	 * This method is used to verify examdate on step 5 by Girish
	 * @throws InterruptedException 
	 * 
	 */		
		
	
	public void verifyexamdate() throws Exception{
								
	bringElementIntoView(examdatestep5);
	waitForElement(examdatestep5);
							
	String Actulexamdatestep5 = examdatestep5.getText();
	System.out.println("Expected testcode: "+  Actulexamdatestep5.trim());
	System.out.println("Actual testcode: "+  examdateValue);
	Assert.assertEquals(Actulexamdatestep5.trim(), examdateValue);
								
							
							}
						
					
					
					
					
					
					
	//		public void selectprefectureoption() throws Exception{
						
	//		bringElementIntoView(prefecture);
	//		Select prefecture = new Select(driver.findElement(By.cssSelector(".info-form-row.prefecture-info.row .ng-select-container.ng-has-value .ng-value-container .ng-input")));
						
	//		Select select = new Select(prefecture);
					
	//		WebElement option = select.getFirstSelectedOption();
	//		defaultItem = option.getText();	
	//		System.out.println(defaultItem );
			
			
	//		}


}






