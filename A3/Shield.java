import java.util.ArrayList;

public class Shield extends BoardComponent {

	private BoardComponent square;
	private int shieldHealth;

	public Shield(BoardComponent square) {
		super();
		this.square = square;
		shieldHealth = 2;
	}

	@Override
	public void Operation() {

		square.Operation();

	}

	@Override
	public void Add(BoardComponent child) {
		square.Add(child);
	}

	@Override
	public void Remove(BoardComponent child) {
		square.Remove(child);
	}

	@Override
	public void Update(BoardComponent boardComponentHit) {

		if (this.square.equals(boardComponentHit)) {
			if (shieldHealth <= 0) {
				ArrayList<ArrayList<BoardComponent>> board = GameBoard.Instance().GetBoard();
				for (int i = 0; i < board.size(); i++) {
					ArrayList<BoardComponent> row = board.get(i);
					for (int j = 0; j < row.size(); j++) {
						if (this.equals(row.get(j))) {
							// Replace the shield object with square object, ie., removing decorator of the
							// square class when the health of the shield goes to 0
							row.set(j, this.square);
							
							//detaching the shield class from the observer list
							GameBoard.Instance().GetSubject().Detach(this);
							
							//attaching the shield class from the observer list
							GameBoard.Instance().GetSubject().Attach(this.square);
						}
					}
				}
			} else {
				//decrementing the health by 1 when asteropid is hit
				shieldHealth -= 1;
			}
		}
	}

}
