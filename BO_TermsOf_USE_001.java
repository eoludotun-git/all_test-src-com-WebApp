package com.WebApp;



import org.junit.Test;
import org.openqa.selenium.WebDriver;








import utility.Constant;
import utility.HomePage.HomePageUI;
import utility.LoginAS.LoginAS;
import utility.browser.url.BrowserPage;

public class BO_TermsOf_USE_001 {
	@Test
	public void BrandOWNER_TermsOF_USE() throws InterruptedException{
		/*WebDriver driver = BrowserPage.OpenChromeBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.URL);
		driver.manage().window().maximize();*/
		
		WebDriver driver = BrowserPage.OpenChromeBrowser();
		LoginAS.Execute(driver, Constant.Username_B, Constant.Password_B);
		
		//About Troy
		HomePageUI.Click_About_Troy(driver).click();
		
		
		
		HomePageUI.Click_Home(driver).click();
		
		//about Track and Track
		
		HomePageUI.Click_About_TROY_Track_and_Trace(driver).click();

		HomePageUI.Click_Home(driver).click();
		
		//Support
		HomePageUI.Click_Frequently_Asked_Questions(driver).click();
		
	HomePageUI.Click_Home(driver).click();
		
		//Legal
		
		HomePageUI.Click_Terms_of_Use(driver).click();
		
		HomePageUI.Click_Home(driver).click();
		
		HomePageUI.Click_Privacy_Policy(driver).click();
		
			HomePageUI.Click_Home(driver).click();
		
		
		//Ask a Question
		
		HomePageUI.Click_Ask_Questions(driver).click();
		
		HomePageUI.Type_FirstName_To_Ask_Questions(driver).sendKeys("james");
		
		HomePageUI.Type_LastName_To_Ask_Questions(driver).sendKeys("just me and you");
		
		HomePageUI.Type_Company_To_Ask_Questions(driver).sendKeys("Software Automation 1");
		
		HomePageUI.Type_City_To_Ask_Questions(driver).sendKeys("Southern Pine");
		
		
		
		
		HomePageUI.Type_State_To_Ask_Questions(driver).sendKeys("North Carolina");
		
		HomePageUI.Type_ZipCode_To_Ask_Questions(driver).clear();
		
		HomePageUI.Type_ZipCode_To_Ask_Questions(driver).sendKeys("201222");
		
		HomePageUI.Type_Phone_NUmber_To_Ask_Questions(driver).clear();
		
		HomePageUI.Type_Phone_NUmber_To_Ask_Questions(driver).sendKeys("3013441234");
		
		HomePageUI.Type_Email_To_Ask_Questions(driver).sendKeys("kadabulabambulu@gmail.com");
		
		HomePageUI.Type_Product_To_Ask_Questions(driver).sendKeys("Software Automation 1");
		
		HomePageUI.Type_Problem_Description_To_Ask_Questions(driver).sendKeys("Can you please tell me, when will you be giving free lunch, thank you");
		
		HomePageUI.Click_Submit_Report_Request(driver).click();
		
		// Legal
		
		
		
		HomePageUI.Click_Home(driver).click();
		
		
		HomePageUI.click_SignOut(driver).click();
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}


