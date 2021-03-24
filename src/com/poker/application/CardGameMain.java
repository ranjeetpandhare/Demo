package com.poker.application;

import java.util.Scanner;

public class CardGameMain {

	
	static int i = 1;
	static int mode;

	public static void main(String[] args) {
		CardGame cardgame = new CardGame();

		System.out.println("1. Start Game -- enter 1 \n ------------------------------------ \n2."
				+ " Exit Game -- enter 2 \n -----------------------------------");
		while (i != 0) {
			Scanner in = new Scanner(System.in);
			i = in.nextInt();

			switch (i) {
			case 1:
				
				//select mode 
				System.out.println("select Mode ---? ");
				System.out.println("1: Normal mode");
				System.out.println("2: Low Card Joker");
				System.out.println("3: High Card Joker");
				System.out.println("4: Any Card Joker");
				mode = in.nextInt();
				System.out.println(mode + " mode seleted ");
				System.out.println(" Number of Players( should be greater than 1 and less than 4) : ");
				in = new Scanner(System.in);
				i = in.nextInt();
				
				//to check mode 
				if (i == 0) {
					System.out.println("please enter greater than 1 number from the numbers of players ");
				} else {
					if (mode == 1) {
						// method written on CardGame class
						
						cardgame.NormalMode(i);
						cardgame.displayWinners();
					} else if (mode == 2) {
						cardgame.LowCardJoker(i);
						cardgame.displayWinners();
					} else if (mode == 3) {
						cardgame.highCardJoker(i);
						cardgame.displayWinners();
					}else if (mode == 4) {
						cardgame.AnyCardJoker(i);
					}
				}

			case 2:
				System.out.println("............Game Finished..... please restart the game");
				System.exit(0);

			}
			System.out.println("restart the game.. ");
			System.out.println("1. Start Game \n1. Exit Game");
		}
	}
}