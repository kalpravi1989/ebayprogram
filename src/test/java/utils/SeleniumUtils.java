package utils;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class SeleniumUtils extends BaseClass {
	WebDriver driver = BaseClass.driver;
	public void type(WebElement ele, String data) {
		try {
			waitForclickability(ele);
			ele.clear();
			ele.sendKeys(data);
		} catch (InvalidElementStateException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();

		}
	}

	public String getTexts(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();

		} catch (InvalidElementStateException e) {
			// e.printStackTrace();
		} catch (WebDriverException e) {
			// e.printStackTrace();
		}
		return text;
	}

	public void submit(WebElement ele) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));

			ele.submit();

		} catch (InvalidElementStateException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void waitForclickability(WebElement ele) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ele));
	}
}
