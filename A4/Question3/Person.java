public class Person
{
	public String name;
	public Address address;

	public Person()
	{
		name = "Rob";
		address = new Address("Rob street", "Rob city", "Rob province", "Rob postalcode");
	}

	public boolean IsPersonRob()
	{
		return name.equals("Rob") && IsRobsAddress(address);
	}

	private boolean IsRobsAddress(Address address)
	{
		return address.IsAddressEqual();
	}
}