package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class LoginPage extends CommonUtils {
	WebDriver driver;

	@FindBy(css = ".form-control#email")
	private WebElement eid;

	@FindBy(css = ".form-control#password")
	private WebElement password;

	@FindBy(css = ".button.button--default.button--uplarge.button--login.js-submit")
	private WebElement submitbtn;

	@FindBy(xpath = "//h1[contains(text(),'テストの選択')]") /* テストの選択 = Test Selection */
	private WebElement testSelection;
	
	@FindBy(css = ".btn.btn-large.btn-gradient")
	private WebElement nextButton;


	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to launch the URL and verify URL launched properly
	 * 
	 * @param url
	 *            contains URL
	 */
	public void loadURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		// waitForElement(lnkHome);

	}

	/**
	 * This method is used to enter userid & Password in SignIn page
	 * 
	 * @param USERNAME,PASSWORD
	 * 
	 */
	public void UserPassword(String User, String Password) {
		waitForElement(eid);
		eid.sendKeys(User);
		password.sendKeys(Password);
	}
	
	/**
	 * This method is used to click on Submit Button on home page
	 */

	public void submitBtn() {
		waitForElement(submitbtn);
		submitbtn.click();
	}

	
	/**
	 * This method is used verify successfully navigated to Step 1 by verify
	 * 'Test Selection' title existence
	 * 
	 */
	public boolean verifyTestSelectionTitle() {

		if (waitForElement(testSelection)) {
			
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * This method is used verify successfully navigated to Step 1 by verify
	 * 'Test Selection' title existence
	 * @throws InterruptedException 
	 * 
	 */
	public void reloginAfterBooking() throws InterruptedException {

		if (!waitForElement(eid)) {
			String url=driver.getCurrentUrl();
			url = url.substring(8);
			System.out.println(url);
			url = "https://sgepuser:9tg6gxxCEaL3@"+url;
			System.out.println(url);
			driver.get(url);
			Thread.sleep(5000);
			waitForElement(eid);
		} 

	}
	
}
