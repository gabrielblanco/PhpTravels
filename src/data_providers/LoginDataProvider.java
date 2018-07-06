package data_providers;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	@DataProvider(name = "loginAuthentication")
    public static Object[][] credentials(){
        return new Object[][] {
        	{"user@phptravels.com", "demouser","https://www.phptravels.net/account/"}
         };
    }
	@DataProvider(name = "loginAuthenticationWithOutURL")
    public static Object[][] loginData(){
        return new Object[][] {
        	{"user@phptravels.com", "demouser"}
         };
    }
}
