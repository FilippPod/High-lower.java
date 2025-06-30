import java.util.Random;
import java.util.Scanner;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 


class HigherLower
{
	public static void main (String[] args) {
	
		Model secret = new Model();
		View display = new View();
		int guess;
		
		// Game Play
		display.introduction();
		guess = display.guess();
		while (guess != secret.getSecret()) {
			if (guess > secret.getSecret()) {
				display.tooHigh(guess);
				guess = display.guess();
			}
			else {
				display.tooLow(guess);
				guess = display.guess();
			}
		}
		display.win(guess);
		
	}

}

class Model
{

	private int randNum;
	int sum = 0;
	
	public Model () {
		setSecret();
	}

	
	private void setSecret () {
		Random rand = new Random();
		int upperbound = 100;
		this.randNum = rand.nextInt(upperbound) + 1;
	}
	
	public int getSecret () {
		return randNum;
	}
	
	public String toString () {
		return "Generates a secret number";
	}
}

class View
{

	Frame frmMain = new Frame();
	Button btnGo = new Button("Go");
	Label lblMessage = new Label("Guess");
	TextField txtGuess = new TextField("Guess",2);
	int userGuess;

	public View () {

		frmMain.setSize (400, 300);
		frmMain.setTitle ("Higher Lower Game");

		lblMessage.setBounds (20, 20, 360, 80);
		frmMain.add (lblMessage);

		txtGuess.setBounds (20, 200, 80, 30);
		txtGuess.setBackground(Color.GRAY);
		frmMain.add (txtGuess);

		btnGo.setBounds (200, 200, 80, 30);
		ButtonClick btnClick = new ButtonClick(this);
		btnGo.addActionListener (btnClick);
		frmMain.add (btnGo);

		frmMain.setLayout(null);
		frmMain.setVisible (true);

	}

	public void introduction () {
		String text = 	"Guess a number between 1 and 100";
		lblMessage.setText(text);
	}

	public void tooHigh (int x) {
		String text = "\n You guessed " + x + " which is too high.\n Please guess again.";
		lblMessage.setText(text);
	}

	public void tooLow (int x) {
		String text;
		if (x == 0) {
			text = 	"Guess a number between 1 and 100";
		} else {
			text = "\n You guessed " + x + " which is too low.\n Please guess again.";
		}

		lblMessage.setText(text);
	}

	public void win (int x) {
		String text = "\n You Won! You guessed the secret number " + x;
		lblMessage.setText(text);
	}

	public int guess () {
		return userGuess;
	}

}

class ButtonClick implements ActionListener
{
	View button;


	ButtonClick (View button) {
		this.button = button;
	}

	public void actionPerformed(ActionEvent e){
		button.userGuess = Integer.parseInt(button.txtGuess.getText());

	}
}
// Alternate View 1
/*
class View
{

	public void introduction () {
		String text = 	"\n ***************************\n" +
						" *                         *\n" +
						" * This is a guessing game *\n" +
						" *                         *\n" +
						" * You need to guess a     *\n" +
						" * random number between   *\n" +
						" * 1 and 100               *\n" +
						" *                         *\n" +
						" ***************************\n\n" +
						" Please guess a number: ";
		System.out.println (text);
	}

	public void tooHigh (int x) {
		String text = "\n You guessed " + x + " which is too high.\n Please guess again.";
		System.out.println (text);
	}

	public void tooLow (int x) {
		String text = "\n You guessed " + x + " which is too low.\n Please guess again.";
		System.out.println (text);
	}

	public void win (int x) {
		String text = "\n You Won! You guessed the secret number " + x;
		System.out.println (text);
	}

	public int guess () {
		Scanner playerGuess = new Scanner(System.in);
		return playerGuess.nextInt();
	}

}
*/
// Alternate View 2
/*
class View
{

	Frame frmMain = new Frame();
	Button btnGo = new Button("Go");
	Label lblMessage = new Label("Guess");
	TextField txtGuess = new TextField("Guess",2);
	int userGuess;
	
	public View () {
		
		frmMain.setSize (400, 300);
		frmMain.setTitle ("Higher Lower Game");
		
		lblMessage.setBounds (20, 20, 360, 80);
		frmMain.add (lblMessage);

		txtGuess.setBounds (20, 200, 80, 30);
		txtGuess.setBackground(Color.GRAY);
		frmMain.add (txtGuess);

		btnGo.setBounds (200, 200, 80, 30);
		ButtonClick btnClick = new ButtonClick(this);
		btnGo.addActionListener (btnClick);
		frmMain.add (btnGo);
		
		frmMain.setLayout(null);  
		frmMain.setVisible (true);

	}
	
	public void introduction () {
		String text = 	"Guess a number between 1 and 100";
		lblMessage.setText(text);
	}
	
	public void tooHigh (int x) {
		String text = "\n You guessed " + x + " which is too high.\n Please guess again.";
		lblMessage.setText(text);
	}
	
	public void tooLow (int x) {
		String text;
		if (x == 0) {
			text = 	"Guess a number between 1 and 100";
		} else {
			text = "\n You guessed " + x + " which is too low.\n Please guess again.";
		}
		
		lblMessage.setText(text);
	}
	
	public void win (int x) {
		String text = "\n You Won! You guessed the secret number " + x;
		lblMessage.setText(text);
	}

	public int guess () {
		return userGuess;
	}

}

class ButtonClick implements ActionListener
{
	View button;

	
	ButtonClick (View button) {
		this.button = button;
	}
	
	public void actionPerformed(ActionEvent e){
		button.userGuess = Integer.parseInt(button.txtGuess.getText());
		
	}
}

*/

