// Building is the leaf node for the composite pattern, Square's can have MULTIPLE Buildings
// Buildings cannot have children.
public class Building extends BoardComponent {
	private int buildingHealth;

	public Building() {
		super();
		buildingHealth = 2;
	}

	@Override
	public void Operation() {
		// Buildings just stand there, they don't do anything.
	}

	@Override
	public void Add(BoardComponent child) {
		// Do nothing, I'm a leaf.
	}

	@Override
	public void Remove(BoardComponent child) {
		// Do nothing, I'm a leaf.
	}

	@Override
	public void Update(BoardComponent boardComponentHit) {

		// Decrement the health by 1, when it is hit by an asteroid
		this.buildingHealth -= 1;
		if (this.buildingHealth == 0) {
			// when building health goes to 0, decrement the building count by 1 and remove
			// the building from its square
			parent.Remove(this);
			GameBoard.Instance().DecrementBuildingCount();

		}

	}
}