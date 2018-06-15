package question6;

import java.io.PrintWriter;

public class SaveData {
	public void Save(PiggyBank piggyBank) {
		try {
			PrintWriter writer = new PrintWriter("piggybank.txt", "UTF-8");
			writer.println(Integer.toString(piggyBank.numPennies));
			writer.println(Integer.toString(piggyBank.numDimes));
			writer.println(Integer.toString(piggyBank.numNickels));
			writer.println(Integer.toString(piggyBank.numQuarters));
			writer.close();
		} catch (Exception e) {
			System.out.println("I am a bad programmer that hid an exception.");
		}
	}

}
