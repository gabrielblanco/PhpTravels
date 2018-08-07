package tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.HeaderObjects;
import pageobjects.LoginPage;
import pageobjects.ProfilePage;


public class LoginTest extends BaseTest{

	/**
	 * Web driver.
	 */
	private WebDriver driver;

	/**
	 * Instances.
	 */
	private LoginPage loginPage;
	private HeaderObjects headerObjects;
	private ProfilePage profilePage;

	/**
	 * Sets up the web driver.
	 */
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}

	/**
	 * This test case validates that the user can login 
	 * @param email
	 * @param password
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "loginAuthentication", dataProviderClass= data_providers.LoginDataProvider.class, enabled=false)
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
	 * Allows to edit the user account info.
	 * @param email is the user email to login.
	 * @param password is the user password to login.
	 */
	@Test (dataProvider = "editAccountData", dataProviderClass= data_providers.LoginDataProvider.class)
	public void editAccountInfo(String email, String password, String uPhone, String uEmail, String uPassword, String uConfirmationPassword,
								String uAddress1, String uAddress2, String uCity, String uRegion, String uZipCode, String uCountry){
		headerObjects = new HeaderObjects(driver);
		headerObjects.DisplayMyAccountDropDown();
		headerObjects.SelectLoginItem();
		loginPage = new LoginPage(this.driver);
		loginPage.Login(email, password);
		profilePage = new ProfilePage(driver);
		profilePage.selectProfileItem();
		profilePage.updateUserInfo(uPhone, uEmail, uPassword, uConfirmationPassword, uAddress1, uAddress2, uCity, uRegion, uZipCode, uCountry);
		Assert.assertTrue(profilePage.isSuccessAlertDisplayed());
	}

	/**
	 * This test close the browser window
	 */
	@AfterTest
	public void CloseWindow() {
		driver.close();
	}
	
}
