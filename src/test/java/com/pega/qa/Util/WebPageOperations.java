package com.pega.qa.Util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.qa.TestBase.TestBaseClass;

public class WebPageOperations extends TestBaseClass {

	private static int EXPLICT_WAIT_TIME = 20;
	// private static int IMPLICT_WAIT_TIME = 20;
	static int maxNoOfRetries = 5;
	static WebDriverWait wait = new WebDriverWait(driver, EXPLICT_WAIT_TIME);

	// WebDriverWait wait = new WebDriverWait(driver, 20);

	public static void clickOperation(WebElement element) {

		int counter = 0;
		while (maxNoOfRetries > 0 && counter != maxNoOfRetries) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICT_WAIT_TIME")), TimeUnit.SECONDS);
			}
			counter++;
		}

	}

	public static Boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception ex) {
			return false;
		}

	}
	
	public static void mouseHoverByXPath(String myXpath, WebDriver driver) throws InterruptedException {

		WebElement element = driver.findElement(By.xpath(myXpath));
		mouseHoverByElement(element, driver);

	}
	
	public static void mouseHoverByElement(WebElement elem, WebDriver driver) throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(elem).build().perform();
		Thread.sleep(1000);

	}

	public static void Refresh() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

	public static void switchFrame(String Frame) {

	}

	public static void takeScreenShot() throws IOException {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentdir = prop.getProperty("ScreenShot");
		FileUtils.copyFile(srcfile, new File(currentdir + "/ScreenShots" + System.currentTimeMillis() + ".png"));

	}

	public static void waitForPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(EXPLICT_WAIT_TIME, TimeUnit.SECONDS);

	}

	public static void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, EXPLICT_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static String getPopupMessage() {
		String message = null;
		try {
			Alert alert = driver.switchTo().alert();

			message = alert.getText();
			alert.accept();
		} catch (Exception e) {

			message = null;
		}
		System.out.println("message" + message);
		return message;
	}

	public static void populateField(WebElement element, String text) {
		int counter = 0;
		while (maxNoOfRetries > 0 && counter != maxNoOfRetries) {
			try {
				element.clear();
				element.sendKeys(text);

				break;
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICT_WAIT_TIME")), TimeUnit.SECONDS);
				// System.out.println(e.getMessage());

			}
			counter++;
		}
	}

	public static String getPageTitle() {

		return driver.getTitle();

	}

	public static String getText(WebElement element) {

		return element.getText();

	}

	public static void selectDropdownbyVisibleText(WebElement element, String value) {
		new Select(element).selectByVisibleText(value);
	}

	public static void selectDropdownbyValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	public static WebElement findElementByText(List<WebElement> elements, String text) {
		WebElement result = null;
		for (WebElement element : elements) {
			element.getText().trim();
			if (text.equalsIgnoreCase(element.getText().trim())) {
				result = element;
				break;
			}
		}
		return result;
	}

	public static boolean isElementPresent(WebElement element) {
		boolean available = false;
		try {
			if (element.isDisplayed())
				available = true;
			return available;

		} catch (NoSuchElementException e) {
			return available;
		}
	}

	public static void hoverOnElement(WebElement menu, WebElement subMenu) {
		Actions actions = new Actions(driver);
		actions.moveToElement(menu);
		actions.moveToElement(subMenu);
		actions.click().build().perform();
	}

	public static void bootStrapDropDown(List<WebElement> menuList, String option) {
		for (WebElement item : menuList) {
			if (item.getAttribute("innerHTML").equalsIgnoreCase(option)) {
				item.click();
				break;
			}
		}
	}

	public static void populateField(WebElement element, int number) {

		int counter = 0;
		while (maxNoOfRetries > 0 && counter != maxNoOfRetries) {
			try {
				element.clear();
				element.sendKeys(String.valueOf(number));

				break;
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICT_WAIT_TIME")), TimeUnit.SECONDS);
				// System.out.println(e.getMessage());

			}
			counter++;
		}

	}

}
