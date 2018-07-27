
public class Addition extends MathOperation {

	int leftOperand;
	int rightOperand;

	public Addition(int leftOperand, int rightOperand) {
		super();
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int GetResult() {
		return leftOperand + rightOperand;
	}

}
