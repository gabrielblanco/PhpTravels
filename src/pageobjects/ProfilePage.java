package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    /**
     * Web driver.
     */
    private WebDriver driver;

    /**
     * Web element selectors.
     */
    @FindBy(xpath = "//a[@href='#profile']") private WebElement profileLink;
    @FindBy(name = "phone") private WebElement phoneNumber;
    @FindBy(xpath = "//div[@class='panel-body']//input[@name='email']") private WebElement emailAddress;
    @FindBy(name = "password") private WebElement password;
    @FindBy(name = "confirmpassword") private WebElement confirmPassword;
    @FindBy(name = "address1") private WebElement addressOne;
    @FindBy(name = "address2") private WebElement addressTwo;
    @FindBy(name = "city") private WebElement city;
    @FindBy(name = "state") private WebElement state;
    @FindBy(name = "zip") private WebElement zip;
    @FindBy(name = "country") private WebElement country;
    @FindBy(xpath = "//div[@class='panel-footer']//button") private WebElement btnSubmit;
    @FindBy(className = "alert-success") WebElement successAlert;

    /**
     * Constructor method.
     * @param driver is the web driver.
     */
    public ProfilePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks over My Profile Link Tab.
     */
    public void selectProfileItem() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(profileLink));
        profileLink.click();
    }

    /**
     * Types and select the new information for the user account.
     * @param uPhone is the user new phone.
     * @param uEmail is the user email to send the confirmation.
     * @param uPassword is the user new password.
     * @param uConfirmationPassword is the user confirmation password.
     * @param uAddress1 is the user new first address.
     * @param uAddress2 is the user second address.
     * @param uCity is the user new city.
     * @param uRegion is the user new region.
     * @param uZipCode is the user new zip code.
     * @param uCountry is the user new country.
     */
    public void updateUserInfo(String uPhone, String uEmail, String uPassword, String uConfirmationPassword, String uAddress1,
                               String uAddress2, String uCity, String uRegion, String uZipCode, String uCountry){
        typePhone(uPhone);
        typeEmail(uEmail);
        typePassword(uPassword);
        typeConfirmationPassword(uConfirmationPassword);
        typeAddress1(uAddress1);
        typeAddress2(uAddress2);
        typeCity(uCity);
        typeRegion(uRegion);
        typeZipCode(uZipCode);
        selectCountry(uCountry);
        clickOnSubmitButton();
    }

    /**
     * Verifies if a success alert message is displayed.
     * @return the alert display state.
     */
    public boolean isSuccessAlertDisplayed() {
        return successAlert.isEnabled();
    }

    /**
     * Types the user phone number in the input field.
     * @param uPhone is the user input field.
     */
    private void typePhone(String uPhone) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(phoneNumber));
        phoneNumber.clear();
        phoneNumber.sendKeys(uPhone);
    }

    /**
     * Types the user email confirmation on the email input.
     * @param uEmail is the user email.
     */
    private void typeEmail(String uEmail) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emailAddress));
        emailAddress.clear();
        emailAddress.sendKeys(uEmail);
    }

    /**
     * Types the user password on the input field.
     * @param uPassword is the user password.
     */
    private void typePassword(String uPassword) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(uPassword);
    }

    /**
     * Types the user confirmation password on the input field.
     * @param uConfirmationPassword is the user confirmation password.
     */
    private void typeConfirmationPassword(String uConfirmationPassword) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(confirmPassword));
        confirmPassword.clear();
        confirmPassword.sendKeys(uConfirmationPassword);
    }

    /**
     * Types the user address one on the input field.
     * @param uAddressOne is the user first address.
     */
    private void typeAddress1(String uAddressOne) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(addressOne));
        addressOne.clear();
        addressOne.sendKeys(uAddressOne);
    }

    /**
     * Types the user address two on the input field.
     * @param uAddressTwo is the second user address.
     */
    private void typeAddress2(String uAddressTwo) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(addressTwo));
        addressTwo.clear();
        addressTwo.sendKeys(uAddressTwo);
    }

    /**
     * Types the user city on the input field.
     * @param uCity is the user city.
     */
    private void typeCity(String uCity) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(city));
        city.clear();
        city.sendKeys(uCity);
    }

    /**
     * Types the user region on the input field.
     * @param uRegion is the user state or region.
     */
    private void typeRegion(String uRegion) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(state));
        state.clear();
        state.sendKeys(uRegion);
    }

    /**
     * Types the user zip code on the input field.
     * @param uZipCode is the user zip code.
     */
    private void typeZipCode(String uZipCode) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(zip));
        zip.clear();
        zip.sendKeys(uZipCode);
    }

    /**
     * Select the user country from the list
     * @param uCountry is the user country.
     */
    private void selectCountry(String uCountry) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(country));
        Select drpCountry = new Select(country);
        drpCountry.selectByVisibleText(uCountry);
    }

    /**
     * Clicks over submit button.
     */
    private void clickOnSubmitButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnSubmit));
        btnSubmit.click();
    }
}
