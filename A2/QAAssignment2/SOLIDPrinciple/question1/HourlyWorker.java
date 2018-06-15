package question1;
public class HourlyWorker implements Worker
{
	private float hourlyRate;

	public HourlyWorker()
	{
		hourlyRate = 10.0f;
	}

	@Override
	public float calculatePay(int hours)
	{
		return hourlyRate * hours;
	}
}