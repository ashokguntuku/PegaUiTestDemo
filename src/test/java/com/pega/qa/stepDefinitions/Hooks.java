package com.pega.qa.stepDefinitions;

import com.pega.qa.TestBase.TestBaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBaseClass{
	
	
	 
	public Hooks() {
		
		
	}
 
	@Before
	public void BeforeSteps() {
		
	}
 
	@After
	public void AfterSteps() {
		if(driver!=null)	{
			driver.quit();
			driver = null;
	}
}
}


