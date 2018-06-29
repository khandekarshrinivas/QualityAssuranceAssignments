public class StartGameCommand extends Command
{
	public StartGameCommand(Object receiver, String[] args)
	{
		super(receiver, args);
	}

	@Override
	public void Execute()
	{
		// The receiver for the StartGameCommand is the GameBoard
		System.out.println("Start Game");
		GameBoard board = (GameBoard)receiver;
		board.StartGame();
	}
}