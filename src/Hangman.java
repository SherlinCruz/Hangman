import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class Hangman implements KeyListener {
	static ArrayList<String> arraylist = new ArrayList<String>();
	String wordPop;
	StringBuilder hiddenWord = new StringBuilder();
	JLabel guessLetter = new JLabel();

	public static void main(String[] args) {

		Hangman Hangman = new Hangman();

	}

	Hangman() {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(4, 1));
		JLabel underline = new JLabel();
		JLabel livesLeft = new JLabel();
		JLabel solvedWords = new JLabel();

		frame.setSize(700, 700);
		frame.setVisible(true);
		panel.setVisible(true);
		underline.setVisible(true);
		livesLeft.setVisible(true);
		solvedWords.setVisible(true);
		guessLetter.setVisible(true);

		frame.add(panel);
		panel.add(guessLetter);
		panel.add(underline);
		panel.add(livesLeft);
		panel.add(livesLeft);
		panel.add(solvedWords);
		frame.addKeyListener(this);

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

		wordPop = stack.pop();

		System.out.println(wordPop);

		System.out.println(stack);

		guessLetter.addKeyListener(this);
		for (int i = 0; i < wordPop.length(); i++) {

			hiddenWord.append("_ ");

			guessLetter.setText(hiddenWord.toString());
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (wordPop.contains(Character.toString(e.getKeyChar()))) {

			for (int i = 0; i < wordPop.length(); i++) {

				if (wordPop.charAt(i) == e.getKeyChar()) {

					hiddenWord.setCharAt(i, e.getKeyChar());

					guessLetter.setText(hiddenWord.toString());
					
				}

			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
