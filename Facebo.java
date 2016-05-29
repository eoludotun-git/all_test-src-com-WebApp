package com.WebApp;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;















import utility.Constant;
import utility.Navigation.FaceBook;
import utility.Navigation.GenerateData;
import utility.browser.url.BrowserPage;
import utility.browser.url.Screenshot;


public class Facebo  {

	//FaceBookLogic faceBookObJ = new FaceBookLogic();
	protected  WebDriver driver;

	GenerateData genData=new GenerateData();

	
	
	@BeforeMethod
	public void wwww(){
		
	
 System.setProperty("webdriver.chrome.driver", "/SeleniumJars/ChromeDriver.exe");
	driver = new ChromeDriver();
		
		driver.get(Constant.URL);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("On " +  new Date()  + " - WebBrowser and Operating System type: " + driver );
	
	
	String CurrentURL = driver.getCurrentUrl();
	FaceBook.CompareAndVerify(CurrentURL, driver.getCurrentUrl());
	}



protected void logout() {
	
	driver.close();
}

@AfterMethod
public void tearDown() {

logout();
driver.quit();

}
	

	
	
		
		
		
	
	@Test
	public void FaceBookSignUP() throws InterruptedException
	{
		//WebDriver driver = BrowserPage.OpenChromeBrowser();
	
		//extends BaseDriverTest
	
				FaceBook.Nav_ToMainDashBoard.WriteToLog("###########################################");
				FaceBook.Nav_ToMainDashBoard.WriteToLog("*** TestCase (333) Testing Face Book ****");
				FaceBook.Nav_ToMainDashBoard.WriteToLog("############################################");
		facebK(genData.generateEmail(12), 
				genData.generateStringWithAllobedSplChars(12  , " @@@@@@ " ), genData.generateUrl(12),
				Constant.BirthMonths, Constant.BirthDay, Constant.BirthYear, Constant.EmailAddress);
		driver.quit();
	}


public void facebK(String FirstName, String LastName, String Password, String BirthMonths, 
		String BirthDay, String BirthYear, String EmailAddress ) throws InterruptedException{

		
	FaceBook.Nav_ToMainDashBoard.ResetStepCounter();
		FaceBook.Nav_ToMainDashBoard.Type_FirstName(driver).sendKeys(FirstName);
		
		
		//FaceBook.Nav_ToMainDashBoard.Type_LastName(driver).sendKeys(genData.generateRandomString(20));
		FaceBook.Nav_ToMainDashBoard.Type_LastName(driver).sendKeys(LastName);
		
		FaceBook.Nav_ToMainDashBoard.Type_EmailAddress(driver).sendKeys(EmailAddress);
		FaceBook.Nav_ToMainDashBoard.ReType_EmailAddress(driver).sendKeys(EmailAddress);
		
		FaceBook.Nav_ToMainDashBoard.Type_PassWord(driver).sendKeys(Password);
		
		FaceBook.Nav_ToMainDashBoard.Select_BirthMonths(driver).sendKeys(BirthMonths);
		FaceBook.Nav_ToMainDashBoard.Select_BirthDay(driver).sendKeys(BirthDay);
		
		FaceBook.Nav_ToMainDashBoard.Select_BirthYear(driver).sendKeys(BirthYear);
		
		FaceBook.Nav_ToMainDashBoard.SelectMale(driver).click();
		FaceBook.Nav_ToMainDashBoard.Click_SignUpButton(driver).click();
		Screenshot.Take_Screenshot(driver, Constant.Screenshot, "FaceBook-- ");
}
}
		
		
		
		
		
		
	
	


