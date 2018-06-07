package com.pega.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.pega.qa.Listener.WebEventListner;

public class TestBaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListner eventListener;

	public TestBaseClass() {
		if (prop == null) {
			prop = new Properties();
			FileInputStream fs;
			try {
				fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
				prop.load(fs);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String strUsername = prop.getProperty("User_Name1");
		System.out.println("Username 1 " + strUsername);
		System.out.println("current path" + System.getProperty("user.dir"));
		}
	}
	
	public static String getReportConfigPath(){
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

	public static void initialization() {
		String browser = prop.getProperty("Browser");
		String Url = null;
		if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Driver/geckodriver.exe");
			if (driver == null) {
			driver = new FirefoxDriver();
			}
		}

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedrivernew.exe");
			if (driver == null )	
				driver = new ChromeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListner();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("EXPLICT_WAIT_TIME")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICT_WAIT_TIME")), TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("PegaUrl"));

	}

}
