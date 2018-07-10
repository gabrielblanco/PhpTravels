package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarsPage {

    /**
     * Web driver
     */
    WebDriver driver;

    /**
     * Web element selectors.
     */
    @FindBy(xpath = "//a[@href='#collapseMap']") WebElement viewMapBtn;

    /**
     * Constructor method.
     * @param driver is the web driver.
     */
    public CarsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks over view map button.
     */
    public void clicOnViewMapBtn(){
        viewMapBtn.click();
    }
}
