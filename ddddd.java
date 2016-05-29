package com.WebApp;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import utility.Navigation.FaceBook;
import utility.Navigation.GenerateData;

public class ddddd {
	GenerateData genData=new GenerateData();
	@Test
	public void FaceBookSignUP() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "/SeleniumJars/ChromeDriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("On " +  new Date()  + " - WebBrowser and Operating System type: " + driver );
	
	driver.get("https://www.facebook.com/");
	FaceBook.Nav_ToMainDashBoard.ResetStepCounter();
	FaceBook.Nav_ToMainDashBoard.Type_FirstName(driver).sendKeys(genData.generateRandomString(9));
	
	
	//FaceBook.Nav_ToMainDashBoard.Type_LastName(driver).sendKeys(genData.generateRandomString(20));
	FaceBook.Nav_ToMainDashBoard.Type_LastName(driver).sendKeys(genData.generateRandomString(9));
	
	FaceBook.Nav_ToMainDashBoard.Type_EmailAddress(driver).sendKeys(genData.generateRandomString(9));
	FaceBook.Nav_ToMainDashBoard.ReType_EmailAddress(driver).sendKeys(genData.generateRandomString(9));
	
	FaceBook.Nav_ToMainDashBoard.Type_PassWord(driver).sendKeys(genData.generateRandomString(9));
	}
}
