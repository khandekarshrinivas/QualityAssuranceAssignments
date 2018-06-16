package question4;

public class LiskovSubstitutionPrinciple {
	public static void main(String[] args) {

		BankAccount account = null;
		
		account = new BankAccount();
		account.Credit(12);
		System.out.println(account.GetBalance());
		
		account = new USDollarAccount();
		account.Credit(12);
		System.out.println(account.GetBalance());
	}

}
