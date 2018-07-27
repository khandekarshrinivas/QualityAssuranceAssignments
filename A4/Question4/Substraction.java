
public class Substraction extends MathOperation {

	public Substraction(int leftOperand, int rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public int GetResult() {
		return leftOperand - rightOperand;
	}

}
