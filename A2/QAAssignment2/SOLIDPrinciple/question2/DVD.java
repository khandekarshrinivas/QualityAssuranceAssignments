package question2;

import java.time.Duration;
import java.util.ArrayList;

public class DVD implements ILibraryDVD {
	public Duration GetPlayTime() {
		return Duration.ofMinutes(135);
	}

	public String GetTitle() {
		return "Solo: A Star Wars Story";
	}

	public ArrayList<String> GetCastList() {
		ArrayList<String> cast = new ArrayList<String>();
		cast.add("Alden Ehrenreich");
		cast.add("Joonas Suotamo");
		cast.add("Woody Harrelson");
		cast.add("Emilia Clarke");
		cast.add("Donald Glover");
		cast.add("Thandie Newton");
		cast.add("Paul Bettany");
		return cast;
	}
}