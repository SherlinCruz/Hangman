import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	static ArrayList<String> arraylist = new ArrayList<String>();

	public static void main(String[] args) {

		Hangman Hangman = new Hangman();

	}

	Hangman() {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(4, 1));
		JLabel guessLetter = new JLabel();
		JLabel underline = new JLabel();
		JLabel livesLeft = new JLabel();
		JLabel solvedWords = new JLabel();

		frame.setSize(700, 700);
		frame.setVisible(true);
		panel.setVisible(true);
		guessLetter.setVisible(true);
		underline.setVisible(true);
		livesLeft.setVisible(true);
		solvedWords.setVisible(true);

		frame.add(panel);
		panel.add(guessLetter);
		panel.add(underline);
		panel.add(livesLeft);
		panel.add(livesLeft);
		panel.add(solvedWords);

		guessLetter.setVisible(true);
		underline.setVisible(true);
		livesLeft.setVisible(true);
		solvedWords.setVisible(true);

		guessLetter.setText(" Guess a letter ");
		livesLeft.setText(" You have 7 lives left ");
		solvedWords.setText(" You have solved " + " words ");

		frame.pack();

		String number = JOptionPane.showInputDialog(" How many round do you want to play ? ");
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

			Random random = new Random();

			int randomNumber = random.nextInt(arraylist.size()) + 1;
			stack.push(arraylist.get(randomNumber));

		}
		System.out.println(stack);
	}

}
