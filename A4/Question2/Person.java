public class Person {
	private String name;

	private PhoneNumber phoneNumber;
	private Authenticator authenticator;

	public Person(String name) {
		this.name = name;
		authenticator = new Authenticator();
		phoneNumber = new PhoneNumber();
	}

	public void SetAreaCode(String areaCode) {
		phoneNumber.SetAreaCode(areaCode);
	}

	public String GetAreaCode() {
		return phoneNumber.GetAreaCode();
	}

	public void SetPhoneNumber(String number) {
		phoneNumber.SetPhoneNumber(number);
	}

	public String GetPhoneNumber() {
		return phoneNumber.GetPhoneNumber();
	}

	public void SetLoginCredentials(String userName, String password) {
		authenticator.setUserName(userName);
		authenticator.setPassword(password);
	}

	public boolean AuthenticateUser() {
		return authenticator.AuthenticateUser();

	}
}