package pageobjects.visa;

import org.openqa.selenium.WebDriver;

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
                                     String uPassportNumber, String uPassportIssued, String uPassportExpiration){
        basicInformation.fillGeneralInfo(uEmail, uArrivalDate, uPhoneCode, uPhoneNumber, uHomeAddress,
                uHomeCountry, uTravelBy);
        basicInformation.fillApplicantInfo(uName, uLastName, uNationality, uBirthday, uGender, uPassportNumber,
                uPassportIssued, uPassportExpiration);
    }
}
