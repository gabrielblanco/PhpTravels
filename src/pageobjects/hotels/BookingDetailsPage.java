package pageobjects.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingDetailsPage {

    /**
     * Web driver.
     */
    WebDriver driver;

    /**
     * Web element selectors.
     */
    @FindBy(name = "logged")
    WebElement confirmBookingButton;

    /**
     * Constructor method.
     * @param driver is the web driver.
     */
    public BookingDetailsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on confirm booking button.
     */
    public void clockOnConfirmBookingButton() {
        new WebDriverWait(driver, 5 ).until(ExpectedConditions.visibilityOf(confirmBookingButton));
        confirmBookingButton.click();
    }
}
