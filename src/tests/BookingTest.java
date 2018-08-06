package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HeaderObjects;
import pageobjects.LoginPage;
import pageobjects.WishListPage;

public class BookingTest extends BaseTest {

    /**
     * Web driver.
     */
    private WebDriver driver;

    /**
     * Instances.
     */
    private HeaderObjects headerObjects;
    private LoginPage loginPage;
    private WishListPage wishListPage;

    /**
     * Sets up the web driver.
     */
    @BeforeClass
    public void setUp() {
        driver=getDriver();
    }

    @Test (dataProvider = "loginAuthenticationWithOutURL", dataProviderClass= data_providers.LoginDataProvider.class)
    public void setBookingReservedState(String email, String password) throws InterruptedException {
        headerObjects = new HeaderObjects(driver);
        headerObjects.DisplayMyAccountDropDown();
        headerObjects.SelectLoginItem();
        loginPage = new LoginPage(this.driver);
        loginPage.Login(email, password);
        headerObjects.DisplayMyAccountDropDown();
        headerObjects.SelectAccountItem();
        wishListPage = new WishListPage(driver);
        wishListPage.GoToWishList();
        Thread.sleep(3000);
        wishListPage.goToPreview();
    }

    /**
     * This test close the browser window
     */
    @AfterTest
    public void CloseWindow() {
        //driver.close();
    }
}
