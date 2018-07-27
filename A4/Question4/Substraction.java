
public class Substraction extends MathOperation {

	int leftOperand;
	int rightOperand;

	public Substraction(int leftOperand, int rightOperand) {
		super();
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int GetResult() {
		return leftOperand - rightOperand;
	}

}
