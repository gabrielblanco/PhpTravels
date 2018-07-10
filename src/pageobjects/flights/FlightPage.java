package pageobjects.flights;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage {

    /**
     * Web driver
     */
    WebDriver driver;

    /**
     * Web element selectors.
     */
    @FindBy(xpath = "//table[@id='load_data']//tr[1]//button") WebElement btnBookFlight;

    /**
     * Constructor method
     * @param driver is the web driver.
     */
    public FlightPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on Book Now button.
     */
    public void clickOnBookBtn(){
        btnBookFlight.click();
    }

}
