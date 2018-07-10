package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.FlightsPage;
import pageobjects.HeaderObjects;
import pageobjects.HotelsPage;
import pageobjects.LoginPage;
import pageobjects.WishListPage;

public class FlightTest extends BaseTest{
	WebDriver driver;
	FlightsPage flightsPage;
	HeaderObjects headerObjects;
	
    @BeforeClass
    public void setUp(){
	driver=getDriver();
    }
    
    /**
     * Verify that the system displays the details oThis method clicks the details button of the first flight in the listf a flight when more details button is clicked.
     * @throws InterruptedException 
     */
    @Test
    public void displayDetails() throws InterruptedException {
    	headerObjects = new HeaderObjects(driver);
    	headerObjects.GoToFlights();
    	flightsPage=new FlightsPage(driver);
    	flightsPage.ClickOnDetails();
    	Thread.sleep(3000);
    	assertTrue(flightsPage.descriptionIsDisplayed());
    }
    
    /**
     * This test close the browser window
     */
    @AfterTest
    public void CloseWindow() {
    	//driver.close();
    }
}
