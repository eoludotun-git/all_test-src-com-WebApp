package com.WebApp;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

import utility.Constant;
public class BaseClassTest {
	protected  WebDriver driver;
	

	// If Boolen is set to true, the test runs on Firefox Browser.
	//But if the Boolen is set to false, the test runs on Chrome Browser 
	public void fireFoxLogin(boolean firefox ) {
		
			
		if (firefox)
		{
			
			
			driver = new FirefoxDriver();				
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("On " +  new Date()  + " - WebBrowser and Operating System type: " + driver );
			//driver.get("https://www.facebook.com/");
			  	driver.get(Constant.URL);
			
		}
		else
		{
		System.setProperty("webdriver.chrome.driver", "/SeleniumJars/ChromeDriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("On " +  new Date()  + " - WebBrowser and Operating System type: " + driver );
		
		  	driver.get(Constant.URL);
		}
		  	
		/*String CurrentURL = driver.getCurrentUrl();
		//Screenshot.Take_Screenshot(driver, Constant.Screenshot, "Loggin Screen Shot -- ");
		  	FaceBookPage.CompareAndVerify("https://www.facebook.com/", CurrentURL);*/
		}
	    // If Boolen is set to true, the test runs on Internet Browser.
		//But if the Boolen is set to false, the test runs on HTML Browser
		public void internetExplorerLogin( Boolean InternetExplorer) {
		if (InternetExplorer)
		{
			System.setProperty("webdriver.ie.driver", "/SeleniumJars/IEDriverServer.exe");
			
			DesiredCapabilities cap = DesiredCapabilities
					.internetExplorer();
			// if your IE is not at 100% setting the tests will fail
			cap.setCapability(
					InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			cap.setCapability(
					InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			cap.setCapability("logFile", "/tmp/server.log");
			cap.setCapability("logLevel", "DEBUG");
			cap.setVersion("11");// set version or you can add version
									// to test properties
			driver = new InternetExplorerDriver(cap);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(Constant.URL);
		}
		else
		{
			driver = new HtmlUnitDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(Constant.URL);
			
			
		}
		  	
		  	
	}

	protected void logout() {
		
		driver.close();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
	Thread.sleep(4000);
	//Screenshot.Take_Screenshot(driver, Constant.Screenshot, "Loggin Out Screen Shot-- ");
	logout();
	driver.quit();
	
	}
			
		
	
	
	
}