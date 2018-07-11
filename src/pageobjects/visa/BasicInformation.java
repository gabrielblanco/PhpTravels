package pageobjects.visa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasicInformation {

    /**
     * Web driver.
     */
    WebDriver driver;

    /**
     * Web elements selectors of General Information.
     */
    @FindBy(xpath = "//input[@data-ivisa-name='email']") WebElement email;
    @FindBy(xpath = "//input[@data-ivisa-name='arrival_date']") WebElement arrivalDate;
    @FindBy(xpath = "//ul[contains(@class,'country-list')]") WebElement countryCode;
    @FindBy(xpath = "//input[@data-ivisa-name='phone']") WebElement phone;
    @FindBy(xpath = "//input[@data-ivisa-name='address']") WebElement homeAddress;
    @FindBy(xpath = "//select[@data-ivisa-name='home_country']") WebElement homeCountry;
    @FindBy(xpath = "//select[@data-ivisa-name='traveling_by']") WebElement travelingBy;

    /**
     * Web element selectors of Applicant #1
     */
    @FindBy(xpath = "//section[contains(@class,'ivisa-applicant-fields')][2]//input[@data-ivisa-name='first_name']") WebElement firstName;
    @FindBy(xpath = "//section[contains(@class,'ivisa-applicant-fields')][2]//input[@data-ivisa-name='last_name']") WebElement lastName;
    @FindBy(xpath = "//section[contains(@class,'ivisa-applicant-fields')][2]//select[@data-ivisa-name='nationality_country']") WebElement nationalityCountry;
    @FindBy(xpath = "//section[contains(@class,'ivisa-applicant-fields')][2]//input[@data-ivisa-name='dob']") WebElement birthday;
    @FindBy(xpath = "//section[contains(@class,'ivisa-applicant-fields')][2]//select[@data-ivisa-name='gender']") WebElement gender;
    @FindBy(xpath = "//section[contains(@class,'ivisa-applicant-fields')][2]//input[@data-ivisa-name='passport_num']") WebElement passportNumber;
    @FindBy(xpath = "//section[contains(@class,'ivisa-applicant-fields')][2]//input[@data-ivisa-name='passport_issued_date']") WebElement passportIssued;
    @FindBy(xpath = "//section[contains(@class,'ivisa-applicant-fields')][2]//input[@data-ivisa-name='passport_expiration_date']") WebElement passportExpiration;

    /**
     * Constructor method.
     * @param driver is the web driver.
     */
    public BasicInformation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Fills the general information with user data.
     * @param uEmail is the user email.
     * @param uArrivalDate is the user arrival date.
     * @param uPhoneCode is the user phone country code.
     * @param uPhoneNumber is the user phone number.
     * @param uHomeAddress is the user home address.
     * @param uHomeCountry is the user country.
     * @param uTravelBy is the user traveling via.
     */
    public void fillGeneralInfo(String uEmail, String uArrivalDate, String uPhoneCode, String uPhoneNumber,
                                String uHomeAddress, String uHomeCountry, String uTravelBy){
        typeEmailAddress(uEmail);
        sendArrivalDate(uArrivalDate);
//        selectCountryCode(uPhoneCode);
        typePhoneNumber(uPhoneNumber);
        typeHomeAddress(uHomeAddress);
        selectHomeCountry(uHomeCountry);
        selectTravelingBy(uTravelBy);
    }

    /**
     * Fills the applicant #1 information.
     * @param uName is the applicant name.
     * @param uLastName is the applicant last name.
     * @param uNationality is the applicant nationality.
     * @param uBirthday is the applicant birthday.
     * @param uGender is the applicant gender.
     * @param uPassportNumber is the applicant passport number.
     * @param uPassportIssued is the applicant passport issued date.
     * @param uPassportExpiration is the applicant passport expiration date.
     */
    public void fillApplicantInfo(String uName, String uLastName, String uNationality, String uBirthday,
                                  String uGender, String uPassportNumber, String uPassportIssued, String uPassportExpiration){
        typeUserName(uName);
        typeUserLastName(uLastName);
        selectNationality(uNationality);
        typeBirthday(uBirthday);
        selectGender(uGender);
        typePassportNumber(uPassportNumber);
        typePassportIssuedDate(uPassportIssued);
        typePassportExpirationDate(uPassportExpiration);
    }

    /**
     * Types the user email address in the input.
     * @param uEmail is the user email.
     */
    private void typeEmailAddress(String uEmail){
        email.clear();
        email.sendKeys(uEmail);
    }

    /**
     * Sends the user arrival date to the input.
     * @param uArrivalDate is the user arrival date.
     */
    private void sendArrivalDate(String uArrivalDate){
        WebElement date = driver.findElement(By.xpath("//div[@class='datepicker-days']//td[contains(text(),'" + uArrivalDate + "') and not (contains(@class, 'old'))]"));
        arrivalDate.click();
        date.click();
    }

    /**
     * Select the phone country code.
     * @param uPhoneCode is the user phone country code.
     */
    private void selectCountryCode(String uPhoneCode){
        WebElement code = countryCode.findElement(By.xpath("/li[@data-dial-code='" + uPhoneCode + "']"));
        code.click();
    }

    /**
     * Types the user phone number in the input.
     * @param uPhoneNumber is the user phone number.
     */
    private void typePhoneNumber(String uPhoneNumber){
        phone.sendKeys(uPhoneNumber);
    }

    /**
     * Types the user home address in the input.
     * @param uHomeAddress is the user home address.
     */
    private void typeHomeAddress(String uHomeAddress){
        homeAddress.clear();
        homeAddress.sendKeys(uHomeAddress);
    }

    /**
     * Select a country from the list.
     * @param uHomeCountry is the user country.
     */
    private void selectHomeCountry(String uHomeCountry){
        Select drpCountry = new Select(homeCountry);
        drpCountry.selectByVisibleText(uHomeCountry);
    }

    /**
     * Select a travel via from the list.
     * @param uTravelBy is the user choice.
     */
    private void selectTravelingBy(String uTravelBy){
        Select drpTravelBy = new Select(travelingBy);
        drpTravelBy.selectByValue(uTravelBy);
    }

    /**
     * Handler for date modals.
     * @param title is the title of the modal.
     * @param month is the month to select.
     * @param day is the day to select.
     * @param year is the year to select.
     */
    private void modalHandler(String title, String month, String day, String year){
//        WebElement modal = driver.findElement(By.xpath("//h4[contains(@class,'modal-title') and (contains(text(),'" + title + "'))]"));
        WebElement modalMonth = driver.findElement(By.xpath("//h4[contains(@class,'modal-title') and (contains(text(),'" + title + "'))]/parent::div/parent::div//select[@id='dp_month']"));
        WebElement modalDay = driver.findElement(By.xpath("//h4[contains(@class,'modal-title') and (contains(text(),'" + title + "'))]/parent::div/parent::div//select[@id='dp_day']"));
        WebElement modalYear = driver.findElement(By.xpath("//h4[contains(@class,'modal-title') and (contains(text(),'" + title + "'))]/parent::div/parent::div//select[@id='dp_year']"));
        WebElement btnSave = driver.findElement(By.xpath("//h4[contains(@class,'modal-title') and (contains(text(),'" + title + "'))]/parent::div/parent::div//button[@id='dp_save']"));

        Select drpMonth = new Select(modalMonth);
        drpMonth.selectByVisibleText(month);

        Select drpDay = new Select(modalDay);
        drpDay.selectByVisibleText(day);

        Select drpYear = new Select(modalYear);
        drpYear.selectByVisibleText(year);

        btnSave.click();
    }

    /**
     * Types the applicant user name.
     * @param uName is the applicant user name.
     */
    private void typeUserName(String uName){
        firstName.clear();
        firstName.sendKeys(uName);
    }

    /**
     * Types the applicant user last name.
     * @param uLastName is the applicant last name.
     */
    private void typeUserLastName(String uLastName){
        lastName.clear();
        lastName.sendKeys(uLastName);
    }

    /**
     * Select the user nationality from the list.
     * @param uCountry is the user applicant nationality.
     */
    private void selectNationality(String uCountry){
        Select drpCountry = new Select(nationalityCountry);
        drpCountry.selectByVisibleText(uCountry);
    }

    /**
     * Types the user birthday in the input.
     * @param uBirthday is the user birthday.
     */
    private void typeBirthday(String uBirthday){
        birthday.click();
        // 1995-07-06
        modalHandler("Birthday", "7 - July", "6", "1995");
    }

    /**
     * Select the user gender from the list.
     * @param uGender is the user gender.
     */
    private void selectGender(String uGender){
        Select drpGender = new Select(gender);
        drpGender.selectByVisibleText(uGender);
    }

    /**
     * Types the user passport number in the input.
     * @param uPassportNumber is the user passport number.
     */
    private void typePassportNumber(String uPassportNumber){
        passportNumber.clear();
        passportNumber.sendKeys(uPassportNumber);
    }

    /**
     * Types the user passport issued in the input.
     * @param uPassportIssued is the user passport issued.
     */
    private void typePassportIssuedDate(String uPassportIssued){
//        passportIssued.sendKeys(uPassportIssued);
        passportIssued.click();
        // 2008-06-10
        modalHandler("Passport Issued", "6 - June", "10", "2008");
    }

    /**
     * Types the user passport expiration date.
     * @param uPassportExpiration is the user passport expiration date.
     */
    private void typePassportExpirationDate(String uPassportExpiration){
//        passportExpiration.sendKeys(uPassportExpiration);
        // 2030-10-11
        modalHandler("Passport Expiration", "10 - October", "11", "2030");
    }
}
