package pageobjects.visa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RevisionPayment {

    /**
     * Web driver
     */
    WebDriver driver;

    /**
     * Web element selectors
     */
//    @FindBy(xpath = "//div[@data-funding-source='paypal']") WebElement btnPaypal;

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
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        WebElement btnPaypal = driver.findElement(By.xpath("//div[@data-funding-source='paypal']"));
        btnPaypal.click();
    }

    /**
     * Validates if paypal modal is displayed.
     * @return the display result.
     */
    public boolean isModalDisplayed(){
        driver.switchTo().window(driver.getWindowHandle());
        System.out.println(driver.getCurrentUrl());
        WebElement modal = driver.findElement(By.xpath("//div[@class='paypal-checkout-sandbox']"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(modal));
        return modal.isDisplayed();
    }
}
