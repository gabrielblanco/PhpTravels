package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsNoOrder;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.HeaderObjects;
import pageobjects.HotelsPage;
import pageobjects.LoginPage;
import pageobjects.WishListPage;

public class WhislistTest  extends BaseTest {
	HeaderObjects headerObjects;
	LoginPage loginPage;
	HotelsPage hotelPage;
	WishListPage wishListPage;
	
	@BeforeClass
	    public void setUp() {
		driver=getDriver();
	    }
	 
	/**
	 * TC16-Verify that the user can remove a wish when clicks on the remove button.
	 * @param email
	 * @param password
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "loginAuthenticationWithOutURL", dataProviderClass= data_providers.LoginDataProvider.class)
	public void removeItem(String email,String password) throws InterruptedException {
		headerObjects=new HeaderObjects(driver);
		headerObjects.DisplayMyAccountDropDown();
		Thread.sleep(3000);
		headerObjects.SelectLoginItem();
		Thread.sleep(3000);
		loginPage=new LoginPage(driver);
		loginPage.Login(email, password);	
		Thread.sleep(4000);
		wishListPage=new WishListPage(driver);
		wishListPage.GoToWishList();
		Thread.sleep(2000);
		String titleWish=wishListPage.GetTitleOfFirstWish();
		wishListPage.removeWish();
		Thread.sleep(2000);
		wishListPage.confirmRemove();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		wishListPage.GoToWishList();
		Thread.sleep(2000);
		String titleActualFirstWish=wishListPage.GetTitleOfFirstWish();
		assertNotEquals(titleActualFirstWish, titleWish, "title are equals");
	}
	  
	/**
	 * This test close the browser window
	 */
	@AfterTest
	public void CloseWindow() {
		driver.close();
	}

}
