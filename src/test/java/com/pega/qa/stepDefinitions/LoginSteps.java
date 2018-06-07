package com.pega.qa.stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.pega.qa.Pages.LoginPage;
import com.pega.qa.TestBase.TestBaseClass;

import com.pega.qa.Util.WebPageOperations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends TestBaseClass {

	LoginPage lp;

	public LoginSteps() {
		super();
	}

	@Given("^user is on Login Page$")
	public void user_is_on_Login_Page() {
		initialization();
		lp = new LoginPage();
		

	}

	@When("^title of login page is Pega Platform$")
	public void title_of_login_page_is_Pega_Platform() throws InterruptedException {

		Thread.sleep(3000);
		Assert.assertEquals("Pega Platform", WebPageOperations.getPageTitle());
		//System.out.println("LoginPage When");

	}

	@Then("^user enters username and password for Admin$")
	public void user_enters_userand_password_for_admin() {
		
		lp.enter_username("");
		lp.enter_password("");
		lp.enter_username(prop.getProperty("Admin_User"));
		lp.enter_password(prop.getProperty("Admin_Password"));
		System.out.println("LoginPage admin credentials entered");

	}

	@Then("^user enters username and password for User$")
	public void user_enters_and_password_for_user() {
		lp.enter_username("");
		lp.enter_password("");

		lp.enter_username(prop.getProperty("Portal_User"));
		lp.enter_password(prop.getProperty("User_Password"));
		System.out.println("LoginPage Portal user credentials entered");

	}

	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		lp.click_login();
//		System.out.println("LoginPage Then2");
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() {

		//String login = driver.findElement(By.xpath("//ul[@id='nav-mobile']/li")).getText();
		String title = driver.getTitle();
		System.out.println("In Pega Designer Studio Home Page");
		Assert.assertEquals("Pega Designer Studio", title);		
		
	}

	@When("^user enters username and invalid password$")
	public void user_enters_username_and_invalid_password() {
		lp.enter_password(prop.getProperty("User_Name1"));
		lp.enter_password("12334567");
//		System.out.println("LoginPage When1");
	}

	@Then("^user is on login page and error message prompted$")
	public void user_is_on_login_page_and_error_message_prompted() {

		//Assert.assertEquals("Error!", lp.getError());
		Assert.assertEquals("The information you entered was not recognized.", lp.getErrorMessage());
		//lp.clickOk();
//		System.out.println("LoginPage Then1");

	}

	@When("^user enters username$")
	public void user_enters_username() {

		lp.enter_password(prop.getProperty("User_Name2"));
//		System.out.println("LoginPage When1");

	}

	@Then("^close the browser$")
	public void close_the_browser() {
		
		driver.close();
//		System.out.println("LoginPage Then2");

	}
}
