package driver;

import java.util.*;
import game.Game;
public class Driver {
	public static void main(String[] args) {
		Game theGame = new Game();
		String keepOn = "";
		boolean keepPlaying = true;
		Scanner in = new Scanner(System.in) ;
		
		System.out.println("Welcome to Animale - the animal based word game!  Enter a 5 letter word to guess what today's word is.");
		
		// game loop
		while (keepPlaying) {
			String output = theGame.display();
			System.out.println(output);
			
			if (theGame.getGameOver()) {
				System.out.println("Would you like to play again?  Enter true for yes, false for no.");
				keepOn = in.next();
				if (!keepOn.equals("true")) {
					keepPlaying = false;
				}
				else {
					theGame = new Game();
				}
			}		
			else {
				theGame.setUserWord(in.next());
			}
		}
	}
}