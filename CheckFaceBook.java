package com.WebApp;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utility.Constant;
import utility.LoginAS.FaceBookLoginIN;
import utility.Navigation.FaceBook;
import utility.browser.url.Screenshot;

public class CheckFaceBook {
	@Test
	public void facebK() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "/SeleniumJars/ChromeDriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	driver.get("https://www.facebook.com/");
	
	
	//FaceBookLoginIN.Execute(driver, Constant.FaceBook_UserName, Constant.FaceBook_PassWord);
	FaceBookLoginIN.Execute(driver, "ebenezer.software.tester@gmail.com", "preludE123");
	
	FaceBook.Nav_ToMainDashBoard.ResetStepCounter();
	

	Screenshot.Take_Screenshot(driver, Constant.Screenshot, "FaceBook-- ");
	
	String CurrentURL = driver.getCurrentUrl();
	FaceBook.CompareAndVerify(CurrentURL, driver.getCurrentUrl());
driver.quit();
}
}
