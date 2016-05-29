package com.WebApp;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class Mouse {
	
	@Test
	 public void beforetest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://only-testing-blog.blogspot.in/p/mouse-hover.html");
	
	  
	 
	  //Generate mouse hover event on main menu to click on sub menu
	  
	  Thread.sleep(4000);
	  Actions actions = new Actions(driver);
	  Thread.sleep(4000);
	  WebElement moveonmenu = driver.findElement(By.xpath("//div[@id='menu1']/div"));
	  Thread.sleep(4000);
	  actions.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//div[@id='menu1choices']/a"))).click().perform();
	  
	/*  WebDriverWait wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.titleContains("Google"));*/

	  driver.quit();
	 }
}
