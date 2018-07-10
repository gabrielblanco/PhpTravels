package tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HeaderObjects;
import pageobjects.LoginPage;
import pageobjects.flights.FlightDetails;
import pageobjects.flights.FlightInvoice;
import pageobjects.flights.FlightPage;


import pageobjects.HeaderObjects;
import pageobjects.HotelsPage;
import pageobjects.LoginPage;
import pageobjects.WishListPage;


public class FlightTest extends BaseTest{

    /**
     * Instances.
     */  
    LoginPage loginPage;
    FlightPage flightPage;
    FlightDetails flightDetails;
    FlightInvoice flightInvoice;
    HeaderObjects headerObjects;

    /**
     * Sets up the web driver.
     */
    @BeforeClass
    public void setUp() {
        driver=getDriver();
    }

    /**
     * Books a new flight for a user.
     */
    @Test(dataProvider = "validBookingData", dataProviderClass = data_providers.FlightDataProvider.class, enabled=true)
    public void bookAFlight(String uName, String uLastName, String uEmail, String uEmailConfirmation) throws InterruptedException {
        loginPage = new LoginPage(driver);
        headerObjects = new HeaderObjects(driver);
        flightPage = new FlightPage(driver);
        flightDetails = new FlightDetails(driver);
        flightInvoice = new FlightInvoice(driver);

        headerObjects.GoToFlights();
        Thread.sleep(3000);
        flightPage.clickOnBookBtn();
        Thread.sleep(3000);
        flightDetails.bookFlight(uName, uLastName, uEmail, uEmailConfirmation);
        Thread.sleep(5000);
        flightInvoice.payOnArrival();
        Thread.sleep(3000);
        Assert.assertTrue(flightInvoice.bookingConfirmation(), "Your booking status is reserved.");
    }
    /**
     * Verify that the system displays the details oThis method clicks the details button of the first flight in the listf a flight when more details button is clicked.
     * @throws InterruptedException 
     */
    @Test( enabled=false)
    public void displayDetails() throws InterruptedException {
    	headerObjects = new HeaderObjects(driver);
    	headerObjects.GoToFlights();
    	flightPage=new FlightPage(driver);
    	flightPage.ClickOnDetails();
    	Thread.sleep(3000);
    	assertTrue(flightPage.descriptionIsDisplayed());
    }
        
  
    /**
     * Tear down the web driver.
     */
    @AfterTest
    public void CloseWindow() {
        driver.close();
    }
}
