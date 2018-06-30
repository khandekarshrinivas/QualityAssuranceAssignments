import java.util.ArrayList;

// Square is a composite, making up the Composite pattern (contains components)
public class Square extends BoardComponent {
	private final ArrayList<BoardComponent> children;
	private BoardComponent parent;

	public Square() {
		super();
		children = new ArrayList<BoardComponent>();
	}

	@Override
	public void Operation() {

		ArrayList<BoardComponent> childrenCopy = new ArrayList<BoardComponent>(children);
		for (int i = 0; i < childrenCopy.size(); i++) {
			BoardComponent child = childrenCopy.get(i);
			child.Operation();
		}
	}

	@Override
	public void Add(BoardComponent child) {
		// I am now this child's parent.
		children.add(child);
		child.SetParent(this);
	}

	@Override
	public void Remove(BoardComponent child) {
		children.remove(child);
	}

	@Override
	public void Update(BoardComponent boardComponentHit) {

		// Update the children of the square, when its the one which is hit by the
		// asteroid
		if (this.equals(boardComponentHit)) {
			for (int i = 0; i < children.size(); i++) {
				children.get(i).Update(boardComponentHit);
			}
		}
	}
}