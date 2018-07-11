package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.CarsPage;
import pageobjects.HeaderObjects;
import pageobjects.HotelsPage;

public class CarTest extends BaseTest {

    /**
     * Instances
     */
    HeaderObjects headerObjects;
    CarsPage carsPage;


    /**
     * Initialize the web driver.
     */
    @BeforeClass
    public void setUp() {
        driver=getDriver();
    }

    /**
     * The test case verify that the cars map is displayed when user clicks on View Map button.
     */
    @Test(enabled=false)
    public void showCarsMap(){
        headerObjects = new HeaderObjects(driver);
        carsPage = new CarsPage(driver);
        headerObjects.GoToCars();
        carsPage.clicOnViewMapBtn();
        Assert.assertTrue(carsPage.containsMap(),"The Map Container does not have any map inside.");
    }
    
    @Test
    public void filterByStarGrade() throws InterruptedException {
    	 headerObjects = new HeaderObjects(driver);
         headerObjects.GoToCars();
         Thread.sleep(3000);
         carsPage=new CarsPage(driver);
         carsPage.findByStarGrade("5");
    }

    /**
     * Tears down the web driver
     */
    @AfterTest
    public void CloseWindow() {
//        driver.close();
    }
}
