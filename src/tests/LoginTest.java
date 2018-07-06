package tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.HeaderObjects;
import pageobjects.LoginPage;


public class LoginTest extends BaseTest{
	private WebDriver driver;
	private LoginPage loginPage;
	private HeaderObjects headerObjects;
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	/**
	 * This test case validates if user's can login 
	 * @param email
	 * @param password
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "loginAuthentication", dataProviderClass= data_providers.LoginDataProvider.class, enabled=true)
	public void CorrectLogin(String email,String password,String espectedURL) throws InterruptedException {
		headerObjects= new HeaderObjects(driver);
		headerObjects.DisplayMyAccountDropDown();
		Thread.sleep(3000);
		headerObjects.SelectLoginItem();
		Thread.sleep(3000);
		loginPage=new LoginPage(this.driver);
		loginPage.Login(email, password);	
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		assertEquals(driver.getCurrentUrl(),espectedURL,"Espected url not match");
		}
	/**
	 * This test close the browser window
	 */
	@AfterTest
	public void CloseWindow() {
		driver.close();
	}
	
}
