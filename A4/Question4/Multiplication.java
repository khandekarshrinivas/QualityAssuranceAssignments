
public class Multiplication extends MathOperation {

	int leftOperand;
	int rightOperand;

	public Multiplication(int leftOperand, int rightOperand) {
		super();
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int GetResult() {
		return leftOperand * rightOperand;
	}

}
