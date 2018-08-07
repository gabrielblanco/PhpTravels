package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HeaderObjects;
import pageobjects.LoginPage;
import pageobjects.hotels.BookingDetailsPage;
import pageobjects.hotels.InvoicePage;
import pageobjects.hotels.PreviewPage;
import pageobjects.WishListPage;

import java.util.ArrayList;

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
    private PreviewPage previewPage;
    private BookingDetailsPage bookingDetailsPage;
    private InvoicePage invoicePage;

    /**
     * Sets up the web driver.
     */
    @BeforeClass
    public void setUp() {
        driver=getDriver();
    }

    /**
     * Sets a book state as reserved.
     * @param email is the user email to login.
     * @param password is the user password to login.
     * @throws InterruptedException catches sleep time exceptions.
     */
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
        wishListPage.goToPreview();

//        Swith driver to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        previewPage = new PreviewPage(driver);
        previewPage.clickOnBookNowButton();

        bookingDetailsPage = new BookingDetailsPage(driver);
        bookingDetailsPage.clockOnConfirmBookingButton();

        invoicePage = new InvoicePage(driver);
        invoicePage.clickOnPayOnArrivalBtn();
        Assert.assertTrue(invoicePage.isBookStatusReserved());
    }

    /**
     * This test close the browser window
     */
    @AfterTest
    public void CloseWindow() {
        //driver.close();
    }
}
