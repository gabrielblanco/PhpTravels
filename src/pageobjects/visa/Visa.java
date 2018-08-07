package pageobjects.visa;

import org.openqa.selenium.WebDriver;

public class Visa {

    /**
     * Web driver.
     */
    WebDriver driver;

    /**
     * Instances.
     */
    BasicInformation basicInformation;
    RevisionPayment revisionPayment;

    /**
     * Constructor method.
     * @param driver is the web driver.
     */
    public Visa(WebDriver driver){
        this.driver = driver;
        basicInformation = new BasicInformation(driver);
        revisionPayment = new RevisionPayment(driver);
    }

    /**
     * Fills the first tab (Basic Information).
     * @param uEmail is the user Email.
     * @param uArrivalDate is the user arrival date.
     * @param uPhoneCode is the user phone code.
     * @param uPhoneNumber is the user phone number.
     * @param uHomeAddress is the user home address.
     * @param uHomeCountry is the user country.
     * @param uTravelBy is the way of travel.
     * @param uName is the user name.
     * @param uLastName is the user lastname.
     * @param uNationality is the user nationality.
     * @param uBirthday is the user birthday.
     * @param uGender is the user gender.
     * @param uPassportNumber is the user passport number.
     * @param uPassportIssued is the user passport issued.
     * @param uPassportExpiration is the user passport expiration date.
     * @param uIdentificationNumber is the user identification number.
     * @param uVisaType is the user visa type.
     * @param uCurrency is the user currency to pay.
     */
    public void fillBasicInformation(String uEmail, String uArrivalDate, String uPhoneCode, String uPhoneNumber,
                                     String uHomeAddress, String uHomeCountry, String uTravelBy, String uName,
                                     String uLastName, String uNationality, String uBirthday, String uGender,
                                     String uPassportNumber, String uPassportIssued, String uPassportExpiration,
                                     String uIdentificationNumber, String uVisaType, String uCurrency){
        basicInformation.fillGeneralInfo(uEmail, uArrivalDate, uPhoneCode, uPhoneNumber, uHomeAddress,
                uHomeCountry, uTravelBy);
        basicInformation.fillApplicantInfo(uName, uLastName, uNationality, uBirthday, uGender, uPassportNumber,
                uPassportIssued, uPassportExpiration, uIdentificationNumber);
        basicInformation.finishVisaCost(uVisaType, uCurrency);
    }

    /**
     * Verifies if the fields from Basic Information are required.
     * @return the state of the input fields.
     */
    public boolean verifyRequiredFields(){
        return  basicInformation.allFieldsAreReuired();
    }

    /**
     * Pays the travel by paypal method.
     */
    public void payViaPaypal(){
        revisionPayment.clickOnPaypalButton();
    }
    
    /**
    * Verify if PayPal modal window is displayed.
    */
    public boolean isModalDisplayed(){
        return revisionPayment.isModalDisplayed();
    }
    
    /**
     * This method removes the first element of  the list
     */
    public void removeApplicant() {
    	basicInformation.removeApplicant();
    }
    
    /**
     * This method adds a new applicant 
     */
    public void addApplicant() {
    	basicInformation.addAppliccant();
    }
    
    /**
     * This method returns the current number of applicants.
     * @return
     */
    public int getNumberOfApliccants() {
    	return basicInformation.getNumberOfAplicants();
    }
    
}
