package question4;

public class USDollarAccount extends BankAccount
{
	static final float EXCHANGE_RATE = 0.75f;

	public void Credit(float amount)
	{
		balance += amount * EXCHANGE_RATE;
	}

	public void Debit(float amount)
	{
		balance -= amount * EXCHANGE_RATE;
	}
	
	public float GetBalance()
	{
		System.out.println("Returning USDs");
		return balance;
	}
}