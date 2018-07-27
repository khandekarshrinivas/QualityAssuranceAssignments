public class Calculator {
	public static int Divide(int left, int right)
	{
		MathOperation op = new Division(left, right);
		return op.GetResult();
	}

	public static int Multiply(int left, int right) {
		MathOperation op = new Multiplication(left, right);
		return op.GetResult();
	}

	public static int Add(int left, int right) {
		MathOperation op = new Addition(left, right);
		return op.GetResult();
	}

	public static int Subtract(int left, int right) {
		MathOperation op = new Substraction(left, right);
		return op.GetResult();
	}
}