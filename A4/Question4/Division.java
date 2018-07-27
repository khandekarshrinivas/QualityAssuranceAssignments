
public class Division extends MathOperation {

	public Division(int leftOperand, int rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public int GetResult() {
		return leftOperand / rightOperand;
	}

}
