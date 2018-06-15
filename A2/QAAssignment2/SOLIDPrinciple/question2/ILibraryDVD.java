package question2;

import java.time.Duration;
import java.util.ArrayList;

public interface ILibraryDVD {

	public Duration GetPlayTime();
	public String GetTitle();
	public ArrayList<String> GetCastList();
}
