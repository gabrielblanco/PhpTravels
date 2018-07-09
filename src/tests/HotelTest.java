package tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.HeaderObjects;
import pageobjects.HotelsPage;
import pageobjects.LoginPage;
import pageobjects.WishListPage;

public class HotelTest extends BaseTest {
WebDriver driver;
HeaderObjects headerObjects;
LoginPage loginPage;
HotelsPage hotelPage;
WishListPage wishListPage;

@BeforeClass
public void setUp() {
	driver=getDriver();
}
/**
 * The test case verifies that the user can add a hotel to the wishlist when is logged in.
 * @param email
 * @param password
 * @throws InterruptedException 
 */
@Test(dataProvider = "loginAuthenticationWithOutURL", dataProviderClass= data_providers.LoginDataProvider.class, enabled=true)
public void AddHotelToWishList(String email,String password) throws InterruptedException {
	headerObjects= new HeaderObjects(driver);
	headerObjects.DisplayMyAccountDropDown();
	Thread.sleep(3000);
	headerObjects.SelectLoginItem();
	Thread.sleep(3000);
	loginPage=new LoginPage(this.driver);
	loginPage.Login(email, password);	
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	headerObjects.GoToHotels();
	hotelPage=new HotelsPage(driver);
	Thread.sleep(4000);
	hotelPage.addHotelToWishList();
	String title=hotelPage.GetNameOfHotel();
	System.out.println(title);
	
	headerObjects.DisplayMyAccountDropDown();
	Thread.sleep(3000);
	headerObjects.SelectLoginItem();
	Thread.sleep(3000);
	wishListPage=new WishListPage(driver);
	wishListPage.GoToWishList();
	Thread.sleep(3000);
	String titleWish=hotelPage.GetNameOfHotel();
	System.out.println(titleWish);
	
}
/**
 * This test close the browser window
 */
@AfterTest
public void CloseWindow() {
	//driver.close();
}

}
