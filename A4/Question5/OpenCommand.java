
public class OpenCommand implements AbstractCommand {

	@Override
	public String GetHelp() {
		return "open -f <path> [-create=0/1]";
	}

}
