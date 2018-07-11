package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.HeaderObjects;
import pageobjects.ToursPage;

public class TourTest extends BaseTest {
	 ToursPage toursPage;
	 HeaderObjects headeObjects;
		
	  @BeforeClass
	  public void setUp() {
		driver=getDriver();
	  }
	  
	  /**
	   * Verify that the system displays an alert when user tries to add a tour to the wish list and isn’t  logged.
	   * @throws InterruptedException
	   */
	  @Test
	  public void alertIsDisplayed() throws InterruptedException {
		  headeObjects= new HeaderObjects(driver);
		  headeObjects.GoToTours();
		  Thread.sleep(2000);
		  toursPage= new ToursPage(driver);
		  toursPage.addTourToWishList();
		  Thread.sleep(2000);
		  assertTrue(toursPage.isAlertPresent(), "Alert isn't present!");
	  }
	  
	  /**
	   * This test close the browser window
	   */
	  @AfterTest
	  public void CloseWindow() {
	  	//driver.close();
	  }

}
