package com.WebApp;



import java.util.Date;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;












import utility.Constant;
import utility.LoginAS.LoginAS;
import utility.Navigation.CampaignsPage;
import utility.browser.url.BrowserPage;
import utility.browser.url.Screenshot;

public class BO_CreateCampaigns_001 {
	@Test
	public void BO_CreateCampaigns() throws InterruptedException{
		
		WebDriver driver = BrowserPage.OpenChromeBrowser();
	
		
		System.out.println("TEST CASE=> " + new Object(){}.getClass().getEnclosingMethod().getName() + " -  " + " Date: " +  new Date());
		System.out.println( driver  +  " -  URL:  "  +  driver.getCurrentUrl());
		 
		
		//System.out.println("TEST CASE=> " + new Object(){}.getClass() + " -  WebBrowser: " + driver + " URL: " +  driver.getCurrentUrl() + " Date: " +  new Date() );

		
		
		LoginAS.Execute(driver, Constant.Username_B, Constant.Password_B);
		
		// Create Campaigns
		
		CampaignsPage.Nav_CampaignsPage.ResetStepCounter();
		Screenshot.Take_Screenshot(driver, Constant.Screenshot, "Campai _ ");
		CampaignsPage.Nav_CampaignsPage.ClickCampaigns(driver).click();
		
		CampaignsPage.CompareAndVerify("https://t3dev.cloudapp.net/Dashboard/BrandOwnerDashboard",
				driver.getCurrentUrl());
		//CampaignsPage.Nav_CampaignsPage.CampaignsListTitle(driver).getText());
		
		CampaignsPage.Nav_CampaignsPage.SelectCreate(driver).click();
		
		CampaignsPage.Nav_CampaignsPage.Type_Campaign_Title(driver).sendKeys("Ben is here again with automation");
		
		CampaignsPage.Nav_CampaignsPage.Type_BeginDate(driver).clear();
	
		 
		CampaignsPage.Nav_CampaignsPage.Type_BeginDate(driver).sendKeys("09/18/2");
		
		CampaignsPage.Nav_CampaignsPage.Type_EndDate(driver).clear();
		
		Thread.sleep(4000);
		
		CampaignsPage.Nav_CampaignsPage.Type_EndDate(driver).sendKeys("09/23/3");
		
		
		CampaignsPage.Nav_CampaignsPage.Type_CampaignTags(driver).sendKeys("here we go again");
		
		CampaignsPage.Nav_CampaignsPage.Click_DisabledCheckButton(driver).click();
		
		CampaignsPage.Nav_CampaignsPage.Type_Campaigns_Link_Text(driver).sendKeys("ben need to see his money bag");
		
		CampaignsPage.Nav_CampaignsPage.Type_Campaigns_LinkURL(driver).sendKeys("http://google.com");
		
		CampaignsPage.Nav_CampaignsPage.Type_Campaigns_ImageURL(driver).sendKeys("http://mangomaniafl.net/wp-content/uploads/2014/06/iStock_000012591574Medium.jpg");
		
		CampaignsPage.Nav_CampaignsPage.Type_Campaigns_Details(driver).sendKeys("Micheal is real great Automation Engineer");
		
		
		CampaignsPage.Nav_CampaignsPage.Click_Create(driver).click();
		
		driver.quit();
	
	}

}
