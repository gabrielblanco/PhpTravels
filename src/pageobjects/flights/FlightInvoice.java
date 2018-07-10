package pageobjects.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightInvoice {

    /**
     * Web driver
     */
    WebDriver driver;

    /**
     * Web element selectors.
     */
    @FindBy(xpath = "//button[contains(@class, 'arrivalpay')]") WebElement payOnArrivalBtn;
    @FindBy(xpath = "//button[@data-target='#pay']") WebElement payNowBtn;

    /**
     * Constructor method
     * @param driver is the web driver.
     */
    public FlightInvoice(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This method clicks over pay on arrival button and confirm the alert.
     */
    public void payOnArrival(){
        clickOnArraivalPayBtn();
        driver.switchTo().alert().accept();
    }

    /**
     * This method verifies if reserved title is displayed.
     * @return
     */
    public boolean bookingConfirmation(){
        WebElement confirmation = driver.findElement(By.xpath("//td[@bgcolor='#FF9900']"));
        return confirmation.isDisplayed();
    }

    /**
     * Clicks over Pay On Arrival button.
     */
    private void clickOnArraivalPayBtn(){
        payOnArrivalBtn.click();
    }

    /**
     * Clicks over Pay Now button.
     */
    private void clickOnPayNowBtn(){
        payNowBtn.click();
    }

}
