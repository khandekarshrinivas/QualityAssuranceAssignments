package question5;

import java.util.ArrayList;
import java.util.List;

public class OpenClosePrinciple {
	
	public static void main(String[] args) {
		
		List<ICountry> countries = new ArrayList<>();
		
		ICountry canada = new Canada();
		ICountry mexico = new Mexico();
		ICountry usa = new USA();
		
		countries.add(canada);
		countries.add(mexico);
		countries.add(usa);
		
		CountryGDPReport countryGDPReport = new CountryGDPReport();
		countryGDPReport.PrintCountryGDPReport(countries);
	}

}
