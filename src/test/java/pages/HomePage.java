package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.SeleniumUtils;

public class HomePage extends SeleniumUtils {
	WebDriver driver;
	List<String> listName = new ArrayList<String>();
	List<String> sortList = new ArrayList<String>();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='gh-cat']")
	WebElement dropDown;

	@FindBy(xpath = "//select[@class='gh-sb ']/option")
	List<WebElement> list;

	public void getList() {
		for (int i = 1; i < list.size() - 1; i++) {
			sortList.add(list.get(i).getText().trim().toLowerCase());
			listName.add(list.get(i).getText().trim().toLowerCase());
			// System.out.println(list.get(i).getText());
		}

	}

	public void checklist() {
		Collections.sort(sortList);
		for (int i = 0; i < sortList.size(); i++) {
			System.out.print(listName.get(i) + "    ");
			System.out.println(sortList.get(i));
			Assert.assertEquals(listName.get(i), sortList.get(i));
		}
	}

}
