package pageobjects.visa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
    @FindBy(xpath = "//div[@class='flag-container']") WebElement phoneCode;
    @FindBy(xpath = "//input[@data-ivisa-name='phone']") WebElement phone;
    @FindBy(xpath = "//input[@data-ivisa-name='address']") WebElement homeAddress;
    @FindBy(xpath = "//select[@data-ivisa-name='home_country']") WebElement homeCountry;
    @FindBy(xpath = "//select[@data-ivisa-name='traveling_by']") WebElement travelingBy;
    @FindBy(xpath="//div[@class='btn btn-sm btn-primary']") WebElement btnAddApplicant;

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
    @FindBy(xpath = "//section[contains(@class,'ivisa-applicant-fields')][2]//input[@data-ivisa-name='national_identity_number']") WebElement nationalIdentificationNumber;

    /**
     * Web element selectors of BasicInfo
     */
    @FindBy(xpath = "//select[@data-ivisa-name='currency']") WebElement currency;
    @FindBy(xpath = "//section//div[@class='ivisa_submit_error_message']") WebElement requiredFieldsAlert;
    @FindBy(xpath = "//button[contains(@class,'ivisa-submit-step1-button')]") WebElement nextBtn;

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
        selectPhoneCode(uPhoneCode);
        typePhoneNumber(uPhoneNumber);
        typeHomeAddress(uHomeAddress);
        selectHomeCountry(uHomeCountry);
        selectTravelingBy(uTravelBy);
    }
    
    /**
     * This method returns the current number of applicants.
     * @return
     */
    public int getNumberOfAplicants() {
    	int numberOfApplicants = driver.findElements(By.xpath("//div[@class='container ivisa-before-review']//section[contains(@style,'display: block;')]")).size();
    	return numberOfApplicants;
    }
    
    /**
     * This method adds a new applicant 
     */
    public void addAppliccant() {
    	btnAddApplicant.click();
    }
    
    /**
     * This method remove the first applicant of the list
     */
    public void removeApplicant() {
    	WebElement btnRemove = driver.findElement(By.xpath("//div[@class='container ivisa-before-review']//section[2]//div[1]//div[1]"));
    	btnRemove.click();
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
                                  String uGender, String uPassportNumber, String uPassportIssued, String uPassportExpiration,
                                  String uIdentificationNumber){
        typeUserName(uName);
        typeUserLastName(uLastName);
        selectNationality(uNationality);
        typeBirthday(uBirthday);
        selectGender(uGender);
        typePassportNumber(uPassportNumber);
        typePassportIssuedDate(uPassportIssued);
        try {
            typePassportExpirationDate(uPassportExpiration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeUserIdentificationNumber(uIdentificationNumber);
    }

    /**
     * Finish the last steps of Basic Information form.
     * @param uVisaType is the user Canada visa type.
     * @param uCurrency is the user currency to pay.
     */
    public void finishVisaCost(String uVisaType, String uCurrency){
        selectVisaType(uVisaType);
        selectCurrency(uCurrency);
        clickOnNextButton();
    }

    /**
     * Verifies if all input fields are required.
     * @return the state of the required input fields.
     */
    public boolean allFieldsAreReuired() {
        clickOnNextButton();
        return requiredFieldsAlert.isDisplayed();
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
        String dateParts[] = uArrivalDate.split("-");
        String year = dateParts[0];
        String month  = dateParts[1];
        String day  = dateParts[2];

        WebElement cDayHeader = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='switch']"));
        WebElement cMonthHeader = driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='switch']"));

        arrivalDate.click();

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(cDayHeader)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(cMonthHeader)).click();

        WebElement cYear = driver.findElement(By.xpath("//div[@class='datepicker-years']//span[contains(text(),'" + year + "')]"));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(cYear)).click();

        WebElement cMonth = driver.findElement(By.xpath("//div[@class='datepicker-months']//span[" + Integer.parseInt(month) + "]"));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(cMonth)).click();

        WebElement cDay = driver.findElement(By.xpath("//div[@class='datepicker-days']//td[contains(text(),'" + day + "') and not (contains(@class, 'old'))]"));
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(cDay)).click();
    }

    /**
     * Select the phone country code.
     * @param uPhoneCode is the user phone country code.
     */
    private void selectPhoneCode(String uPhoneCode){
        phoneCode.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flag-container']/ul/li[@data-dial-code='" + uPhoneCode + "']"))).click();
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
     * @param date is the date selected by the user.
     */
    private void modalHandler(String title, String date){
        WebElement modalMonth = driver.findElement(By.xpath("//h4[contains(@class,'modal-title') and (contains(text(),'" + title + "'))]/parent::div/parent::div//select[@id='dp_month']"));
        WebElement modalDay = driver.findElement(By.xpath("//h4[contains(@class,'modal-title') and (contains(text(),'" + title + "'))]/parent::div/parent::div//select[@id='dp_day']"));
        WebElement modalYear = driver.findElement(By.xpath("//h4[contains(@class,'modal-title') and (contains(text(),'" + title + "'))]/parent::div/parent::div//select[@id='dp_year']"));
        WebElement btnSave = driver.findElement(By.xpath("//h4[contains(@class,'modal-title') and (contains(text(),'" + title + "'))]/parent::div/parent::div//button[@id='dp_save']"));

        String dateParts[] = date.split("-");
        String year = dateParts[0];
        String month  = dateParts[1];
        String day  = dateParts[2];

        Select drpMonth = new Select(modalMonth);
        drpMonth.selectByIndex(Integer.parseInt(month));

        Select drpDay = new Select(modalDay);
        drpDay.selectByIndex(Integer.parseInt(day));

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
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        modalHandler("Birthday", uBirthday);
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
        passportIssued.click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        modalHandler("Passport Issued", uPassportIssued);
    }

    /**
     * Types the user passport expiration date.
     * @param uPassportExpiration is the user passport expiration date.
     */
    private void typePassportExpirationDate(String uPassportExpiration) throws InterruptedException {
        Thread.sleep(2000);
        passportExpiration.click();
        modalHandler("Passport Expiration", uPassportExpiration);
    }

    /**
     * Types the user identification number.
     * @param uIdentificationNumber is the user identification number.
     */
    private void typeUserIdentificationNumber(String uIdentificationNumber){
        nationalIdentificationNumber.clear();
        nationalIdentificationNumber.sendKeys(uIdentificationNumber);
    }

    /**
     * Select Canada visa type.
     * @param uVisaType is the selected visa type.
     */
    private void selectVisaType(String uVisaType){
        WebElement visaType = driver.findElement(By.xpath("//section[contains(@class,'ivisa-applicant-fields')][2]//select[@data-ivisa-name='visa_type']"));
        Select drpType = new Select(visaType);
        drpType.selectByVisibleText(uVisaType);
    }

    /**
     * Select the currency option.
     * @param uCurrency is the user option for currency.
     */
    private void selectCurrency(String uCurrency){
        Select drpCurrency = new Select(currency);
        drpCurrency.selectByVisibleText(uCurrency);
    }

    /**
     * Clicks on next button.
     */
    private void clickOnNextButton(){
        nextBtn.click();
    }
}
