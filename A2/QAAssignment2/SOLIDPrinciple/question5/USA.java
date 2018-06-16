package question5;

public class USA implements ICountry {

	public String getAgriculture() {
		return "$1200000000 USD";
	}

	public String getManufacturing() {
		return "$900000 USD";
	}

	public String getTourism() {
		return "$100000 USD";
	}

	@Override
	public void PrintCountryGDPReport() {
		System.out.println("- USA:\n");
		System.out.println("   - Agriculture: " + getAgriculture());
		System.out.println("   - Manufacturing: " + getManufacturing());
		System.out.println("   - Manufacturing: " + getTourism());
	}

}
