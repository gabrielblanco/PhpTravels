package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CarTest extends BaseTest {

    /**
     * Initialize the web driver.
     */
    @BeforeClass
    public void setUp() {
        driver=getDriver();
    }

    @Test
    public void showCarsMap(){
        
    }

    /**
     * Tears down the web driver
     */
    @AfterTest
    public void CloseWindow() {
        driver.close();
    }
}
