
public class Division extends MathOperation {

	int leftOperand;
	int rightOperand;

	public Division(int leftOperand, int rightOperand) {
		super();
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int GetResult() {
		return leftOperand / rightOperand;
	}

}
