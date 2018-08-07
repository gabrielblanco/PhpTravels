package tests;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static WebDriver driver;
	String path="C:\\Screen\\";
	public static String fireFoxDriverPath="resources\\geckodriver.exe";
	public static String chromeDriverPath="resources\\chromedriver.exe";
	//	public static String chromeDriverPath="C:\\Users\\gapuser\\Documents\\WebDriver\\chromedriver\\chromedriver.exe";
	
	/**
	 * this method returns a webDriver
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}
	/**
	 * This method create a new webDriver
	 * @param browser
	 * @param baseUrl
	 * @return
	 */
	public static void setDriver(String browser,String baseUrl) {
		switch (browser) {
		case "chrome":
			driver = initChromeDriver(baseUrl);
			break;
		case "firefox":
			driver = initFirefoxDriver(baseUrl);
			break;
		default:
			System.out.println("browser : " + browser
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(baseUrl);
		}
	}
	/**
	 * This method starts ChromeDriver
	 * @param baseUrl
	 * @return
	 */
	private static WebDriver initChromeDriver(String baseUrl) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver",  chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
		return driver;
	}
	
	/**
	 * This method starts fireFoxDriver
	 * @param baseUrl
	 * @return
	 */
	private static WebDriver initFirefoxDriver(String baseUrl) {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
		return driver;
	}
	/**
	 * This method initialize the testBaseSetup
	 * @param browser
	 * @param baseUrl
	 */
	@Parameters({ "browser", "baseUrl" })
	@BeforeClass
	public void initializeTestBaseSetup(String browser, String baseUrl) {
		try {
			setDriver(browser, baseUrl);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	/**
	 * This method takes a screenshot
	 * @throws IOException
	 */
	public  void captureScreenShot() throws IOException {
	    File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	    FileUtils.copyFile(screenshotFile,new File(path+GetTimeStampValue()+".png"));
	}
	/**
	 * This test case returns the currently date and the exactly hour
	 * @return
	 * @throws IOException
	 */
	public  String GetTimeStampValue()throws IOException{
		   Calendar cal = Calendar.getInstance();       
		    Date time=cal.getTime();
		    String timestamp=time.toString();
		    String systime=timestamp.replace(":", "-");
		    return systime;
	}
}
