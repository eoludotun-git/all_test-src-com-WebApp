package com.WebApp;



import java.util.Date;



import org.testng.annotations.Test;

import utility.Constant;
import utility.Navigation.FaceBookPage;
import utility.Navigation.GenerateData;
import utility.browser.url.Screenshot;
import utility.browser.url.delete;


public class TestCase_0002 extends BaseClassTest{
	//LoginSS act;
	GenerateData genData;
	FaceBookPage faceBookOBJ;
	delete file ;
	/*@BeforeMethod
	public void loginmeIn()
	{
		internetExplorerLogin(true);
		
	}*/
	
	@Test
	public void TestUserSignUpForm(){
	
		faceBookOBJ = new FaceBookPage(driver);
		genData=new GenerateData();
		file = new delete();
	  
	
	
	faceBookOBJ.WriteToLog("##############################################");
	faceBookOBJ.WriteToLog("********    START TESTCASE_0001       ********");
	faceBookOBJ.WriteToLog("####### Test Face Book SignUpForm ##########");
	faceBookOBJ.WriteToLog("******     " +  new Date()  + "    ***********");
	faceBookOBJ.WriteToLog("##############################################");
	String CurrentURL = driver.getCurrentUrl();
	//Screenshot.Take_Screenshot(driver, Constant.Screenshot, "Loggin Screen Shot -- ");
	 FaceBookPage.CompareAndVerify("https://www.facebook.com/", CurrentURL);
	
	faceBookOBJ.FaceBookUserSignUpForm(genData.getRandomName(), genData.generateMeaningFullString(38), genData.generateRandomEmail(),
			genData.generateUrl(22));
	Screenshot.Take_Screenshot(driver, Constant.Screenshot, "TestUserSignUpForm _ ");
	
	
	String Just = faceBookOBJ.verify();

	if (Just.equalsIgnoreCase("Sign Up"))
	{
		faceBookOBJ.WriteToLog("##############################################");
		faceBookOBJ.WriteToLog("********  COMPLETED TESTCASE_0001  ********");
		faceBookOBJ.WriteToLog("####### Test Face Book SignUpForm ##########");
		faceBookOBJ.WriteToLog ("********    TESTCASE  PASSED    **********");
		faceBookOBJ.WriteToLog("##############################################");
	}
	else
	{
		faceBookOBJ.WriteToLog("##############################################");
		faceBookOBJ.WriteToLog("********  COMPLETED TESTCASE_0001    ********");
		faceBookOBJ.WriteToLog("#######   Test Face Book SignUpForm  ##########");
		faceBookOBJ.WriteToLog ("*******     TESTCASE  FAILED          ********");
		faceBookOBJ.WriteToLog("##############################################");
	
	}
		
	
		
		
	
	
	

}
	
}
