import java.util.HashMap;
import java.util.Map;

public class Help {

	private Map<String, AbstractCommand> commands = null;

	public Help() {
		commands = new HashMap<>();
		commands.put("print", new PrintCommand());
		commands.put("open", new OpenCommand());
		commands.put("close", new CloseCommand());
	}

	public String GetHelp(String command) {
		if (command != null && command.length() != 0) {
			return commands.get(command).GetHelp();
		}
		return ListAllCommands();
	}

	public String ListAllCommands() {
		return "Commands: print, open, close";
	}
}