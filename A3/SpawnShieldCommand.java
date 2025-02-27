public class SpawnShieldCommand extends Command {

	public SpawnShieldCommand(Object receiver, String[] args) {
		super(receiver, args);
	}

	@Override
	public void Execute() {
		BoardComponent square = (Square) receiver;

		int x= Integer.parseInt(args[0]);
		int y= Integer.parseInt(args[1]);
		
		IAsteroidGameFactory factory = GameBoard.Instance().GetFactory();
		System.out.println("Spawning Shield at (" + x + "," +y + ")");
		Shield shield= (Shield) factory.MakeShield(square);
		
		//Decorating Square with Shield object
		GameBoard.Instance().GetBoard().get(y).set(x, shield);
	}

}
