import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Hangman {
	static ArrayList<String> arraylist = new ArrayList<String>();

	public static void main(String[] args) {

		Hangman Hangman = new Hangman();

	}

	Hangman() {
		String number = JOptionPane.showInputDialog(" How many round do you want to play ?  ");
		int userInput = Integer.parseInt(number);

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));

			String line = br.readLine();
			while (line != null) {

				arraylist.add(line);

				line = br.readLine();

				// System.out.println(line);

			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < userInput; i++) {

			
	
			System.out.println(stack);
		}
	}
}
