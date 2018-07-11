package pageobjects.visa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Visa {

    WebDriver driver;

    BasicInformation basicInformation;

    public Visa(WebDriver driver){
        this.driver = driver;
        basicInformation = new BasicInformation(driver);
    }

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

    // 4987 7756 0635 4658
}
