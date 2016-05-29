package com.WebApp;


import org.junit.Test;
import org.openqa.selenium.WebDriver;









import utility.Constant;
import utility.HomePage.HomePageUI;
import utility.LoginAS.LoginAS;
import utility.Navigation.CampaignsPage;
import utility.browser.url.BrowserPage;
import utility.browser.url.Screenshot;

public class BO_EditCampaigns_002 {
	@Test
	public void BO_EditCampaigns(){
		
	WebDriver driver = 	BrowserPage.OpenChromeBrowser();
	CampaignsPage.Nav_CampaignsPage.ResetStepCounter();
	
	LoginAS.Execute(driver, Constant.Username_B, Constant.Password_B);
	
	
	Screenshot.Take_Screenshot(driver, Constant.Screenshot, "Campa _ ");
	
	//Edit Campaigns
	CampaignsPage.CompareAndVerify("https://t3dev.cloudapp.net/Dashboard/BrandOwnerDashboard",
			driver.getCurrentUrl());
	
	CampaignsPage.Nav_CampaignsPage.ClickCampaigns(driver).click();
	
	Screenshot.Take_Screenshot(driver, Constant.Screenshot, "Campai _ ");
	
	CampaignsPage.Nav_CampaignsPage.SelectViewAll(driver).click();
	
	CampaignsPage.Nav_CampaignsPage.SelectEdit(driver).click();
	
	CampaignsPage.Nav_CampaignsPage.Type_Campaign_Title(driver).clear();
	
	CampaignsPage.Nav_CampaignsPage.Type_Campaign_Title(driver).sendKeys("Michael Rules!");
	
	Screenshot.Take_Screenshot(driver, Constant.Screenshot, "Campai _ ");
	
	CampaignsPage.Nav_CampaignsPage.Click_Save(driver).click();
	
	
	
	HomePageUI.click_SignOut(driver).click();
	
	driver.quit();

	}
	
	@Test
	public void DummyTest()
	{
		WebDriver driver = 	BrowserPage.OpenChromeBrowser();
		CampaignsPage.Nav_CampaignsPage.ResetStepCounter();
		
		LoginAS.Execute(driver, Constant.Username_B, Constant.Password_B);
		
		//Edit Campaigns
		
		CampaignsPage.Nav_CampaignsPage.ClickCampaigns(driver).click();
		Screenshot.Take_Screenshot(driver, Constant.Screenshot, "Campai _ ");
		
		driver.quit();
	}

}
