package tests;

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
	  @Test
	  public void alertIsDisplayed() throws InterruptedException {
		  headeObjects= new HeaderObjects(driver);
		  headeObjects.GoToTours();
		  Thread.sleep(2000);
		  toursPage= new ToursPage(driver);
		  toursPage.addTourToWishList();
	  }
	  
	  /**
	   * This test close the browser window
	   */
	  @AfterTest
	  public void CloseWindow() {
	  	//driver.close();
	  }

}
