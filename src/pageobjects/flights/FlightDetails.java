package pageobjects.flights;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightDetails {

    /**
     * Web driver
     */
    WebDriver driver;

    /**
     * Web element selectors.
     */
    @FindBy(name = "firstname")
    WebElement firstName;
    @FindBy(name = "lastname") WebElement lastName;
    @FindBy(name = "email") WebElement emailAddress;
    @FindBy(name = "confirmemail") WebElement confirmEmailAddress;
    @FindBy(name = "guest") WebElement confirmBookingBtn;

    /**
     * Constructor method.
     */
    public FlightDetails(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Books a new flight for a user
     * @param uName is the user name.
     * @param uLastName is the user last name.
     * @param uEmail is the user email.
     * @param uConfirmedEmail is the confirmed user email.
     */
    public void bookFlight(String uName, String uLastName, String uEmail, String uConfirmedEmail){
        typeUserName(uName);
        typeUserLastName(uLastName);
        typeUserEmail(uEmail);
        typeUserConfirmEmail(uConfirmedEmail);
        clickOnBookingBtn();
    }

    /**
     * Types the username on Name input field.
     * @param uName is the user name.
     */
    private void typeUserName(String uName){
        firstName.clear();
        firstName.sendKeys(uName);
    }

    /**
     * Types the user last name on lastName input field.
     * @param uLastName is the user last name.
     */
    private void typeUserLastName(String uLastName){
        lastName.clear();
        lastName.sendKeys(uLastName);
    }

    /**
     * Types the user email on email input field.
     * @param uEmail is the user email account.
     */
    private void typeUserEmail(String uEmail){
        emailAddress.clear();
        emailAddress.sendKeys(uEmail);
    }

    /**
     * Confirm the user email address.
     * @param uConfirmEmail is the confirmed user email address.
     */
    private void typeUserConfirmEmail(String uConfirmEmail){
        confirmEmailAddress.clear();
        confirmEmailAddress.sendKeys(uConfirmEmail);
    }

    /**
     * Clicks on confirm booking button.
     */
    private void clickOnBookingBtn(){
        confirmBookingBtn.click();
    }

}
