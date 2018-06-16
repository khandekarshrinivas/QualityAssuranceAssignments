package question5;

import java.util.List;

public class CountryGDPReport {

	public void PrintCountryGDPReport(List<ICountry> countries) {
		if (countries != null && !countries.isEmpty()) {
			System.out.println("GDP By Country:\n");
			for (ICountry country : countries) {
				country.PrintCountryGDPReport();
			}
		}
	}
}