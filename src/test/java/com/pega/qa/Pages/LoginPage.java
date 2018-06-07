package com.pega.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pega.qa.TestBase.TestBaseClass;
import com.pega.qa.Util.WebPageOperations;

public class LoginPage extends TestBaseClass {

	@FindBy(xpath = "//input[@id='txtUserID']")
	WebElement username;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement password;

	@FindBy(xpath = "//button[@id='sub']")
	WebElement login;
	
	@FindBy(xpath ="//div[@id='error']")
	WebElement error;
	
	@FindBy(xpath ="//div[@id='error']")
	WebElement errorMessage;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	/*public void click_register_btn()
	{
		WebPageOperations.clickOperation(register);
	}*/
	public void enter_username(String Username)
	{
		WebPageOperations.populateField(username,Username );
	}
	
	public void enter_password(String user_password)
	{
		WebPageOperations.populateField(password,user_password);
		
	}
	
	public void click_login()
	{
		WebPageOperations.clickOperation(login);
		
	}	
	
	public String getError()
	{
		return WebPageOperations.getText(error);
	}
	
	public String getErrorMessage()
	{
		return WebPageOperations.getText(errorMessage);
	}
	
	/*public void clickOk()
	{
		WebPageOperations.clickOperation(okButton);
	}*/

}
