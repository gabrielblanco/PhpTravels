package pageobjects.hotels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreviewPage {

    /**
     * Web driver
     */
    WebDriver driver;

    /**
     * Web element selectors
     */
    @FindBy(xpath = "//section[@id='ROOMS']//tr[1]//div[@class='col-md-4 go-right']//button")
    WebElement bookNowButton;

    /**
     * Constructor method
     * @param driver is the web driver.
     */
    public PreviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks over book now button.
     */
    public void clickOnBookNowButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookNowButton);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(bookNowButton));
        bookNowButton.click();
    }
}
