package data_providers;

import org.testng.annotations.DataProvider;

public class FlightDataProvider {

    /**
     * Valid data for booking a flight.
     * @return
     */
    @DataProvider(name = "validBookingData")
    public static Object[][] userFlightData(){
        return new Object[][] {
                {"Gabriel", "Duran","jduran@example.com","jduran@example.com"}
        };
    }

}
