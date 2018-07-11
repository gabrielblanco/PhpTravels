package pageobjects.visa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevisionPayment {

    /**
     * Web driver
     */
    WebDriver driver;

    /**
     * Web element selectors
     */
    @FindBy(xpath = "//div[@data-funding-source='paypal']") WebElement btnPaypal;

    /**
     * Constructor method.
     * @param driver is the web driver.
     */
    public RevisionPayment(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks over Paypal button.
     */
    public void clickOnPaypalButton(){
        btnPaypal.click();
    }
}
