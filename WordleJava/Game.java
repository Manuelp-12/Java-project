package game;

import java.util.*;
public class Game {
	// *** initiate the words array with the words for your variant of wordle, this is the word bank
	private String[] words = {"akita", "bison", "booby", "bongo", "camel", "crane", "coral", "coati", "dingo", "dhole", "eagle", 
			"fossa", "guppy", "gecko", "goose", "heron", "hyena", "horse", "human", "indri", "koala", "lemur", "llama", "liger",
			"macaw", "molly", "moose", "mouse", "otter", "okapi", "prawn", "quail", "quoll", "robin", "sheep", "snail", "snake",
			"squid", "skunk", "stoat", "sloth", "saola", "tiger", "tetra", "tapir", "xerus", "zebra", "zorse"};
	private String[] attempts;
	int attemptCounter = -1;
	private String chosenWord = "";
	private String userWord = "";
	private boolean gameOver;
	Scanner s = new Scanner(System.in);
	
	// set up the game
	public Game() {
		// set up a new game
		gameOver = false;
		attempts = new String[6];
		// set the attempts to blanks to initialize
		for (int i = 0; i<attempts.length; i++) {
			attempts[i] = "";
		}
		setChosenWord();
	}
	
	public String todaysWord() {
		// choose a random word from the set
		// *** complete the logic to choose a random word from the word bank
		int random = (int)(Math.random() * words.length);
		return words[random];
	}
	
	public boolean checkWin() {
		// *** complete the logic for checking if the user won the game
		if (userWord.equals(chosenWord)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setChosenWord() {
		chosenWord = todaysWord();
	}
	
	public void setUserWord(String w) {
		attempts[attemptCounter]=w;
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	// display the current game board
	public String display() {
		String returnMe = "";
		
		while (attemptCounter < 5) {
			//System.out.print("Guess the word: ");
			System.out.println("Guess: ");
			userWord = s.nextLine();
			attemptCounter++;
			returnMe += userWord + "\n";
		
			for (int i = 0; i < userWord.length(); i++) {
				if (userWord.charAt(i) == chosenWord.charAt(i)) {
					returnMe += "+";
				}
				else if (chosenWord.indexOf(userWord.charAt(i)) != -1) {
					returnMe += "^";
				}
				else {
					returnMe += "-";
				}
			}
			returnMe += "\n";
			System.out.println(returnMe);
			
			if (userWord.equals(chosenWord)) {
				break;
			}
		}
		if (checkWin()) {
			returnMe += "You won!";
		}
		else {
			returnMe += "You lost!";
			returnMe += "The word was: " + chosenWord;
		}
		gameOver = true;
		return returnMe;
		
		// display the user's attempts with indicators for whether they entered a letter in the word or not
		// + == letter's correct for this position
		// - == letter doesn't exist in the word
		// ^ == letter is in the word in the wrong place
		
		// *** complete the logic for the game
	}
}
