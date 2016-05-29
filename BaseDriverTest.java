package com.WebApp;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;



//import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import utility.Constant;
import SuiteBase.PropertyLoader;



public class BaseDriverTest {
	// protected WebDriver driver;
	protected static WebDriver driver;
	protected static Properties myprops = PropertyLoader.loadProperties();
	protected static Properties props = PropertyLoader.loadProperties();
	protected long shortWait;
	protected long mediumWait;
	protected long longWait;
	protected long veryLongWait;

	
	public static long TIMESTAMP = (long) (Math.random() * 10000);

	protected static String login = "admin";
	protected static String password = "admin";

	protected String host = myprops.getProperty("host");
	protected ArrayList<String> preData = new ArrayList<String>();
	protected ArrayList<String> postData = new ArrayList<String>();
	protected static boolean isStaticDriver = Boolean.parseBoolean(myprops
			.getProperty("staticDriver"));
	protected static String browser1 = myprops.getProperty("browser");
	

	protected String jumpPoint = myprops.getProperty("cliHost");

	//@Rule
	//public Retry retry = new Retry(1);

	{
		shortWait = Long.parseLong(props.getProperty("shortWait"));
		mediumWait = Long.parseLong(props.getProperty("mediumWait"));
		longWait = Long.parseLong(props.getProperty("longWait"));
		veryLongWait = Long.parseLong(props.getProperty("veryLongWait"));
	}

	//@BeforeClass
	public static void spawnDriver(String browser) {
		
		try {
			//String browser = Constant.Username_B;
			
				if (browser.contains("firefox")) {
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					driver.get(Constant.URL);
					Thread.sleep(5000);
				} else if (browser.equals("html")) {
					driver = new HtmlUnitDriver();
					Thread.sleep(5000);
				} else if (browser.contains("chrome")) {
					System.setProperty("webdriver.chrome.driver", "/SeleniumJars/ChromeDriver.exe");
					driver = new ChromeDriver();
					driver.get(Constant.URL);
					driver.manage().window().maximize();
					Thread.sleep(5000);
				} else {
					System.setProperty("webdriver.ie.driver",
							getIEDriverServer().getAbsolutePath());
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
					// setIEZoomTo100Percent(); only use this, if the browser by
					// default is more than 100%

					Thread.sleep(5000);
				}
			/*} else {
				if (System.getProperty("test.browser") != null) {
					browser = System.getProperty("test.browser");
				}
				System.out.println("Browser : " + browser);
				DesiredCapabilities capability = null;
				if (browser.toLowerCase().contains("firefox")) {
					capability = DesiredCapabilities.firefox();
				} else if (browser.toLowerCase().contains("internet")) {
					System.out.println("to expl");
					capability = DesiredCapabilities.internetExplorer();
				} else if (browser.toLowerCase().contains("chrome")) {
					System.out.println("to chrome");
					capability = DesiredCapabilities.chrome();
				}
				if (System.getProperty("test.version") != null) {
					capability.setVersion(System.getProperty("test.version"));
				} else {
					capability.setVersion(myprops.getProperty("version"));
				}
				String server = myprops.getProperty("seleniumServer");
				String port = myprops.getProperty("seleniumPort");
				driver = new RemoteWebDriver(new URL("http://" + server + ":"
						+ port + "/wd/hub"), capability);
				driver.manage().window().maximize();*/
			
		} catch (Exception e) 
		{
			}
		}
			
		
	

	public void init() {
		System.out.println("Cloudportal basedriver init, about to call login");
		login();
	}

	protected void login() {
		/*//com.cisco.ui2.cloudportal.BaseDriverTest.spawnDriver();
		System.out.println("Cloudportal basedriver login");
		driver.get(jumpPoint);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		jumpPage = loginPage.login(props.getProperty("login"),
				props.getProperty("password"));
		Assert.assertTrue(windowExists("Cisco Cloud Services"), "Login failed - Credentials not correct");
		
		headerPage = jumpPage.gotoMyProjects();*/
		driver.get(Constant.URL);
	}

	protected void logout() {
		
	}

	@AfterMethod
	public void tearDown() {
		cleanup();
		logout();
	}

	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}

	protected void cleanup() {
		// TODO Auto-generated method stub
	}

	protected boolean windowExists(String windowName) {
		String initialWindow = driver.getWindowHandle();
		Set<String> windowSet = driver.getWindowHandles();
		for (String window : windowSet) {
			driver.switchTo().window(window);
			// This is specific to Directory tasks, because they only have a sub
			// title and not a real title like everything else.
			System.out.println(driver.getTitle());
			if (driver.getTitle().equals(windowName)) {
				// driver.switchTo().window(initialWindow);
				return true;
			}
		}
		driver.switchTo().window(initialWindow);
		return false;
	}

	protected boolean isObjectActive(String objectName) {
		if (driver.findElement(By.xpath("//a[@class='active' and text()='"
				+ objectName + "']")) != null) {
			return true;
		}
		return false;
	}

	public static File getIEDriverServer() {
		try {
			String iexploreDriverPath = System.getProperty("user.dir");
			File file = new File(iexploreDriverPath + File.separator + "config"
					+ File.separator + "IEDriverServer.exe");
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String chromeDriverPath() {
		
	
		String chromeDriverLocation = System.getProperty("user.dir")+"/config/chromedriver";
		if(System.getProperty("os.name").equalsIgnoreCase("windows"))
		{
		
			chromeDriverLocation= chromeDriverLocation+".exe";
		}
		
		return chromeDriverLocation;
	}
	
	public static void main(String[] args) {
		System.out
				.println(System.getProperty("test.version") + " Test Version");
		System.out
				.println(System.getProperty("test.browser") + " Test Version");
		// for (int i = 10; i < 12; i++) {
		// try {
		// DesiredCapabilities capability = DesiredCapabilities.chrome();
		// capability.setVersion(i + "");
		// String server = "172.18.115.44";
		// String port = "4444";
		// WebDriver driver = new RemoteWebDriver(new URL("http://"
		// + server + ":" + port + "/wd/hub"), capability);
		// System.out.println(i + "Worked");
		// driver.quit();
		// } catch (Exception e) {
		// System.out.println(i + "Failed");
		// }
		// }
	}
}
