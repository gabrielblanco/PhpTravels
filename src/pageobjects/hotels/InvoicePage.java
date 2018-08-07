package pageobjects.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoicePage {

    /**
     * Web driver
     */
    WebDriver driver;

    /**
     * Web element selectors
     */
    @FindBy(xpath = "//button[@data-module='hotels']")
    WebElement payOnArrivalButton;
    @FindBy(xpath = "//b[@class='wow flash animted']")
    WebElement bookingStatusTitle;

    /**
     * Constructor method.
     * @param driver is the web driver.
     */
    public InvoicePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks over pay on arrival button.
     */
    public void clickOnPayOnArrivalBtn() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(payOnArrivalButton));
        payOnArrivalButton.click();
        driver.switchTo().alert().accept();
    }

    public boolean isBookStatusReserved () {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(bookingStatusTitle));
        String status = bookingStatusTitle.getText();
        return status.equalsIgnoreCase("RESERVED");
    }
}
