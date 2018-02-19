package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class TestBaseSetup {
  
  protected WebDriver browser;
 
  static String driverPath = "./drivers/";
  
  public TestBaseSetup() {
	 
	  System.out.println("TestBaseSetup");
  }
  
  private static WebDriver initfirefoxDriver(String appURL){
	  
	  WebDriver driver = new FirefoxDriver();
	  driver.get(appURL);
	  return driver;
  }
  
  private static WebDriver initchromeDriver(String appURL){
	  System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get(appURL);
	  return driver;
  }
  private static WebDriver initIEDriver(String appURL){
	  
	  System.setProperty("webdriver.ie.driver", driverPath
				+ "IEDriverServer.exe");
	  WebDriver driver = new InternetExplorerDriver();
	  driver.get(appURL);
	  return driver;
  }
  
  /*
   * @author Jack.xiong
   * 
   *The parameters need to be defined into testng.xml file based on different browsertype 
   *to lunch broswer then connect to the appURL.
   *
   */
  
  @Parameters({"browserType","appURL"})
  @BeforeClass(alwaysRun=true)
  
  public void initializeTestBaseSetup(String browserType,String appURL) {
	  
	  System.out.println("start browser "+browserType);
	  
	  if(browserType.equals("chrome")){
		  
		  browser=  initchromeDriver(appURL);
		  
	  }else if (browserType.equals("iexplore")){
		  
		  browser= initIEDriver(appURL);
		  
	  }else if(browserType.equals("firefox")){
		  
		  browser=  initfirefoxDriver(appURL);
		 
	  }else {
		  System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
	  }
	  
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  
	  System.out.println("after class");
	  browser.manage().deleteAllCookies();
	  browser.close();
	  browser.quit();
	  
  }

}
