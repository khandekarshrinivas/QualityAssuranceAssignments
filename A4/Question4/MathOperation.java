public abstract class MathOperation {

	protected int leftOperand;
	protected int rightOperand;

	public MathOperation(int leftOperand, int rightOperand) {
		super();
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	abstract int GetResult();
}