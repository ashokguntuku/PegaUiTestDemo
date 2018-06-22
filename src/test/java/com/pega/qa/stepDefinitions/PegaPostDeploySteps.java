package com.pega.qa.stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.pega.qa.Pages.LoginPage;
import com.pega.qa.TestBase.TestBaseClass;
import com.pega.qa.Util.StringEncrypt;
//import com.pega.qa.TestBase.TestBaseClass;
//import com.pega.qa.Util.WebPageOperations;
import com.pega.qa.Util.WebPageOperations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PegaPostDeploySteps extends TestBaseClass {

	LoginPage lp;

	public PegaPostDeploySteps() {
		super();
	}

	
	@Given("^user is on Pega Login Page$")
	public void user_is_on_Pega_Login_Page()	{
		initialization();
		lp = new LoginPage();
	  }

	@When("^title of Pega login page is Pega Platform$")
	public void title_of_Pega_login_page_is_Pega_Platform() throws Throwable {
		Thread.sleep(3000);
		Assert.assertEquals(WebPageOperations.getPageTitle(), prop.getProperty("PegaLoginPageTitle"));
		//System.out.println("LoginPage When");
	    
	}

	@Then("^Pega user enters username and password for Admin$")
	public void pega_user_enters_username_and_password_for_Admin() throws Throwable {
		lp.enter_username("");
		lp.enter_password("");
		lp.enter_username(prop.getProperty("Admin_User"));
		String decryptedPwd = StringEncrypt.decryptXOR(prop.getProperty("Admin_PasswordEncrypted"), prop.getProperty("Admin_PasswordKey"));
		System.out.println("decryptedPwd : "+decryptedPwd);
		lp.enter_password(decryptedPwd);
		System.out.println("LoginPage admin credentials entered");
	    
	}

	@Then("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		lp.click_login();
	}

	@Then("^user is on Pega home page$")
	public void user_is_on_Pega_home_page()	{
		String title = driver.getTitle();
		System.out.println("In Pega Designer Studio Home Page");
		System.out.println("Pega Title as in config file : "+ prop.getProperty("PegaHomePageTitle"));
		Assert.assertEquals(prop.getProperty("PegaHomePageTitle"), title);	
	}

	@Then("^user navigates to URL Settings screen$")
	public void user_navigates_to_URL_Settings_screen() throws InterruptedException {
		driver.findElement(By.linkText("Designer Studio")).click();
		Thread.sleep(1000);
		
		WebElement systemMenuItem = driver.findElement(By.xpath("//span[@class='menu-item-title' and contains(text(),'System')]"));
		WebPageOperations.mouseHoverByElement(systemMenuItem, driver);
		
		Actions actionObject = new Actions(driver);
		actionObject = actionObject.sendKeys(Keys.ARROW_DOWN); 
		actionObject.perform(); // Selects "System" --> "Settings"
		Thread.sleep(1000);
		
		actionObject = actionObject.sendKeys(Keys.ARROW_RIGHT);
		actionObject.perform();
		Thread.sleep(1000); // Selects "System" --> "Settings" --> "URLs"

		actionObject = actionObject.sendKeys(Keys.ENTER);
		actionObject.perform(); // Clicks on URLs
		Thread.sleep(1000);
		
						
	}

	@Then("^user enters the URLs and click Save$")
	public void user_enters_the__URLs_and_click_Save() throws Throwable {
	       
	    driver.switchTo().frame("PegaGadget0Ifr"); //Switches to the URLs frame
	    /* All URL fields are identified as below */
		WebElement elem_Online_Help_URL 	= driver.findElement(By.xpath("//input[@id='pyProComHelpURI']"));
		WebElement elem_Public_Link_URL 	= driver.findElement(By.xpath("//input[@id='pyPublicLinkURL']"));
		WebElement elem_External_Logs_URL 	= driver.findElement(By.xpath("//input[@id='pyExternalLogURL']"));
		WebElement elem_Sma_URL 			= driver.findElement(By.xpath("//input[@id='pySystemManagementURI']"));
		
		/* All existing values are taken into temporary variables and cleared */
		String temp_elem_Online_Help_URL = elem_Online_Help_URL.getText();
		elem_Online_Help_URL.clear();
		
		String temp_elem_Public_Link_URL = elem_Public_Link_URL.getText();
		elem_Public_Link_URL.clear();
		
		String temp_elem_External_Logs_URL = elem_External_Logs_URL.getText();
		elem_External_Logs_URL.clear();
		
		String temp_elem_Sma_URL = elem_Sma_URL.getText();
		elem_Sma_URL.clear();
		Thread.sleep(1000);
		
		/* All URLs are updated as given in properties file. If no Propery exists, will be updated with earlier exisiting value*/
		elem_Online_Help_URL.sendKeys(prop.getProperty("Online_Help_URL",temp_elem_Online_Help_URL));
		elem_Public_Link_URL.sendKeys(prop.getProperty("Public_Link_URL", temp_elem_External_Logs_URL));
		elem_External_Logs_URL.sendKeys(prop.getProperty("External_Logs_URL", temp_elem_Sma_URL));
		elem_Sma_URL.sendKeys(prop.getProperty("Sma_URL", temp_elem_Sma_URL));
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='button1' and @class='buttonTdButton']")).click();
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
	}

	@Then("^user logs out$")
	public void user_logs_out() throws Throwable {
		List<WebElement> users = driver.findElements(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[10]/i")); // Clicks logged in User icon on top right corner
		
		WebElement user = null;
		System.out.println("users size : "+users.size());
		
		if(users.size()>=1)	{
			user = users.get(0);
		}
		
		user.click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Log off')]")).click();
		Thread.sleep(1000);
	}

	@Then("^system closes the browser$")
	public void system_closes_the_browser() throws Throwable {
		driver.close();
		driver.quit();
	}

	
	}