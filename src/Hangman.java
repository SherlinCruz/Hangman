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
import javax.swing.WindowConstants;

public class Hangman implements KeyListener {
	static ArrayList<String> arraylist = new ArrayList<String>();
	String wordPop;
	JFrame frame = new JFrame();
	StringBuilder hiddenWord = new StringBuilder();
	JLabel guessLetter = new JLabel();	
	JLabel underline = new JLabel();
	JLabel solvedWords = new JLabel();
	JLabel livesLeft = new JLabel();

	Stack<String> stack = new Stack<String>();

	int livesleft = 7;

	int solvedwords = 0;

	public static void main(String[] args) {

		Hangman Hangman = new Hangman();

	}

	Hangman() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridLayout(4,1));



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
		frame.addKeyListener(this);

		guessLetter.setVisible(true);
		underline.setVisible(true);
		livesLeft.setVisible(true);
		solvedWords.setVisible(true);

		guessLetter.setHorizontalAlignment(JLabel.CENTER);
		guessLetter.setText("Guess a letter ");
		livesLeft.setText("     You have" + livesleft + " lives left ");
		solvedWords.setText(" You have solved " + solvedwords + " words ");

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

			underline.setText(hiddenWord.toString());
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (wordPop.contains(Character.toString(e.getKeyChar()))) {

			for (int i = 0; i < wordPop.length(); i++) {

				if (wordPop.charAt(i) == e.getKeyChar()) {

					hiddenWord.setCharAt(i * 2, e.getKeyChar());

					underline.setText(hiddenWord.toString());

				}
			}
		} else {
			livesleft = livesleft - 1;

			livesLeft.setText(" You have " + livesleft + " lives left ");

			if (livesleft == 0) {
				JOptionPane.showMessageDialog(null, "Better Luck New Time! Play again");
				System.exit(0);

			}

		}
		if (hiddenWord.toString().contains("_ ") == false) {
			// or !hiddenWord.toString().contains("_ ")

			solvedwords = solvedwords + 1;

			solvedWords.setText(" You have solved " + solvedwords + " words ");
			if (stack.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Congratulations! Play again");
			}

			else {

				wordPop = stack.pop();
			}
			hiddenWord = new StringBuilder();

			for (int i = 0; i < wordPop.length(); i++) {

				hiddenWord.append("_ ");

				underline.setText(hiddenWord.toString());
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
