package com.pega.qa.Listener;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.pega.qa.TestBase.TestBaseClass;
import com.pega.qa.Util.UiLogger;
import com.pega.qa.Util.WebPageOperations;

public class WebEventListner extends TestBaseClass implements WebDriverEventListener {

	public WebEventListner() {
		DOMConfigurator.configure("log4j.xml");
	}

	public void beforeAlertAccept(WebDriver driver) {

	}

	public void afterAlertAccept(WebDriver driver) {

	}

	public void afterAlertDismiss(WebDriver driver) {

	}

	public void beforeAlertDismiss(WebDriver driver) {

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		UiLogger.info("Before navigating to: '" + url + "'");

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		UiLogger.info("After navigating to: '" + url + "'");

	}

	public void beforeNavigateBack(WebDriver driver) {

		// System.out.println("Before navigating Back: '" + url + "'");
	}

	public void afterNavigateBack(WebDriver driver) {
		// System.out.println("After navigating Back: '" + url + "'");

	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		UiLogger.info("Trying to Find Element By: " + by.toString());

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		UiLogger.info("Found Element By: " + by.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		UiLogger.info("Clicked on Element: " + element.toString());

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable error, WebDriver driver) {
		UiLogger.error("Exception occured: " + error);
		try {
			
			WebPageOperations.takeScreenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
