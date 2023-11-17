package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	WebDriver driver;
	WebDriverWait wait;
	final int DefaultTimeOut = 60;

	public CommonUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, DefaultTimeOut);
	}

	
	/**
	 * This method is used to wait until element is visible and return true and
	 * false value
	 * 
	 * @param element
	 * @return
	 */
	public boolean waitForElement(WebElement element) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}
	
	public void bringElementIntoView(WebElement element) throws InterruptedException {

		waitForElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Thread.sleep(1000);
    }
	
	public void closebrowser() throws Exception{
		Thread.sleep(10000);
		driver.close();
	
	}
}
