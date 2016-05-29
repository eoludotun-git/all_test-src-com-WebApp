package com.WebApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Extract_Text {
 WebDriver driver;
 
 @BeforeTest
 public void StartBrowser() {
	 System.setProperty("webdriver.chrome.driver", "/SeleniumJars/ChromeDriver.exe");
		 driver = new ChromeDriver();  
 }
 
 @Test
 public void Text() throws InterruptedException{
  driver.get("http://gmail.com");
  //find all input fields where type = text or password and store them In array list txtfields.
  List<WebElement> txtfields = driver.findElements(By.xpath("//*[@id='Email']"));
  
  //for loop to send text In all text box one by one.
  for(int a=0; a<txtfields.size();a++){   
   txtfields.get(a).sendKeys("Text"+(a+1));  
  }
  Thread.sleep(3000);
 }
 
 @AfterTest
 public void CloseBrowser() {  
  driver.quit();  
 }
}