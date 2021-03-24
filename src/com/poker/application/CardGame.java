package com.poker.application;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.poker.application.CARD.CARDNUMBER;
import com.poker.application.CARD.CARDTYPE;

public class CardGame {
	static int s = 0, m = 0;

	private List<CARD> cards;

	private ArrayList<CARD> cdal = new ArrayList<CARD>();

	private List<Player> players = new ArrayList<Player>();

	private Map<Player, List<CARD>> cardsPlayerMap = new HashMap<Player, List<CARD>>();

	private int currentPlayerIdx = 0;
// to provide by defalut 3 cards from user
	private static final int numberOfCardsPerPlayer = 3;

	private int numberOfPlayers = 2;

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public CardGame() {
		cards = CARD.getPackOfCards();
	}
// 
	public static int getNumber1(CARDNUMBER str1) {
		int n = 0;
		String str = str1.toString();
		switch (str) {
		case "TWO":
			n = 2;
			break;
		case "THREE":
			n = 3;
			break;
		case "FOUR":
			n = 4;
			break;
		case "FIVE":
			n = 5;
			break;
		case "SIX":
			n = 6;
			break;
		case "SEVEN":
			n = 7;
			break;
		case "EIGHT":
			n = 8;
			break;
		case "NINE":
			n = 9;
			break;
		case "TEN":
			n = 10;
			break;
		case "JACK":
			n = 11;
			break;
		case "QUEEN":
			n = 12;
			break;
		case "KING":
			n = 13;
			break;
		case "ACE":
			n = 14;
			break;
		}

		return n;
	}

	public static List<CARD> getcardsAll() {
		List<CARD> crdLst = new ArrayList<CARD>();
		ArrayList<CARD.CARDNUMBER> compareCarNumberList = new ArrayList<CARD.CARDNUMBER>();
		ArrayList<CARD.CARDTYPE> compareCarTypeList = new ArrayList<CARD.CARDTYPE>();

		for (CARDTYPE types : CARDTYPE.values()) {
			for (CARDNUMBER cNums : CARDNUMBER.values()) {
				CARD cd = new CARD();
				cd.cdNumber = cNums;
				cd.cdType = types;
				crdLst.add(cd);
			}

		}
		for (int i = 0; i < 3; i++) {
			int n = (int) (Math.random() * 51);
			System.out.println("new " + crdLst.get(n));
			compareCarTypeList.add(crdLst.get(n).getCdType());
			compareCarNumberList.add(crdLst.get(n).getCdNumber());

		}

		System.out.println("original card number ");
		int n0 = getNumber1(compareCarNumberList.get(0));
		int n1 = getNumber1(compareCarNumberList.get(1));
		int n2 = getNumber1(compareCarNumberList.get(2));

		System.out.println(n0);
		System.out.println(n1);
		System.out.println(n2);

		// to get current mode
		int currentmode = CardGameMain.mode;

		// to check 2 mode or 3 mode

		if (currentmode == 2) {
			int smallest, temp1, temp2, largest;

			// to find smallest and largest number using ternary

			temp1 = n0 < n1 ? n0 : n1;
			smallest = n2 < temp1 ? n2 : temp1;
			temp2 = n0 > n1 ? n0 : n1;
			largest = n2 > temp2 ? n2 : temp2;
			smallest = largest;
			System.out.println("Low card joker");
			System.out.println(largest);
			System.out.println(n1);
			System.out.println(n2);
		} else if (currentmode == 3) {
			int smallest, temp1, temp2, largest;
			temp1 = n0 < n1 ? n0 : n1;
			smallest = n2 < temp1 ? n2 : temp1;
			temp2 = n0 > n1 ? n0 : n1;
			largest = n2 > temp2 ? n2 : temp2;
			largest = smallest;
			System.out.println("High card joker");
			System.out.println(largest);
			System.out.println(n1);
			System.out.println(n2);
		}

		if (compareCarNumberList.get(0).equals(compareCarNumberList.get(1))
				&& compareCarNumberList.get(1).equals(compareCarNumberList.get(2))) {
			System.out.println("All same number card");

		}
		// Sequence with Color
		else if (compareCarTypeList.get(0).equals(compareCarTypeList.get(1))
				&& compareCarTypeList.get(1).equals(compareCarTypeList.get(2))
				&& compareCarTypeList.get(0).equals(compareCarTypeList.get(1))
				&& compareCarTypeList.get(1).equals(compareCarTypeList.get(2))) {
			System.out.println("Sequence with Color ");

		}
		// Sequence without Color
		else if (n0 == n1 && n1 == n2) {
			System.out.println("Sequence without Color");
		}
		// Same color
		else if (compareCarTypeList.get(0).equals(compareCarTypeList.get(1))
				&& compareCarTypeList.get(1).equals(compareCarTypeList.get(2))) {
			System.out.println("same color");

		}
		// Highest Cards Win
		else if (n0 > n1 && n1 > n2 && n0 > n2) {
			System.out.println("Highest Cards Win");
		}

//		System.out.println(compareCarTypeList.get(0));
//		System.out.println(compareCarTypeList.get(1));
//		System.out.println(compareCarTypeList.get(2));

//		 All same number card

		return crdLst;

	}
// normal method
	public void NormalMode(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
		createMultipleUser(numberOfPlayers);
		int i = 0;

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("~~~~~~~~~~~~Game Started~~~~~~~~~~~ ");
		System.out.println("------------------------------------------------------------------------------");

		List<CARD> selCards = new ArrayList<CARD>();
		CARD maxCard = null;
		//player class object will be created
		Player maxPlayer = new Player(0);

		// dispatch from player 
		dispatchCardsForPlayers(players);
		do {
			Player player = getNextPlayer();
			System.out.println("Player......... " + player.getPlayerId());
			System.out.println("1. display Cards available enter 1 \n2. Stop Game enter 2");

			System.out.print("Please provide your option 1 or 2 : ");

			Scanner in = new Scanner(System.in);
			i = in.nextInt();

			switch (i) {

			// case 1
			case 1:
				displayCardsForPlayer(player);
				System.out.println("Select your card number in between them :");

//					in = new Scanner(System.in);
				int m = in.nextInt();
				CARD c = cardsPlayerMap.get(player).get(m - 1);

				cdal.add(c);
//              to get the all card number and card types from this method
				getcardsAll();

				System.out.println("---------------------------------------------------------------------------");
				cardsPlayerMap.get(player).remove(m - 1);
				if (maxCard == null) {
					maxCard = c;
					maxPlayer = player;
				} else {
					if (maxCard.compareTo(c) < 0) {
						maxCard = c;
						maxPlayer = player;
					}
				}
				selCards.add(c);

				break;
			// case 2
			case 2:
				return;
			}

			System.out.println();
			s++;
		} while (s < players.size());
		if (maxPlayer.getPlayerId() > 0)
			maxPlayer.setPoints((maxPlayer.getPoints()) + 1);
		maxCard = null;
		maxPlayer = null;

		displayScores();
	}
//     user selec 123 in between them then player can seen from the  cards 
	public void dispatchCardsForPlayers(List<Player> plys) {
		this.players = plys;
		CARD.shuffleCards(cards);
		if (cardsPlayerMap.size() == 0)
			cardsPlayerMap.clear();

		for (Player pl : players) {
			pl.setPoints(0);
			List<CARD> cds = new ArrayList<CARD>();
			int cardLimit = m + numberOfCardsPerPlayer;
			for (int i = m; i < cardLimit; i++) {
				cds.add(cards.get(i));
			}
			m = cardLimit;
			cardsPlayerMap.put(pl, cds);
		}
	}
// create how many player do you want then this method call
	private void createMultipleUser(int j) {
		if (players.size() != 0) {
			players.clear();
		}

		for (int i = 0; i < j; i++) {
			int id = i + 1;
			Player usr = new Player(id);
			players.add(usr);
		}
// display card for player called to pass parameter as number 
		dispatchCardsForPlayers(players);
	}
//  who is higest point winner
	private void displayScores() {
		for (Player pl : players) {
			System.out.println("Player " + pl.getPlayerId() + " Score -> " + pl.getPoints());
		}

	}
// user enter 123 in between them the this method call
	private void displayCardsForPlayer(Player pl) {
		int cards = cardsPlayerMap.get(pl).size();
		for (int i = 0; i < cards;) {
			System.out.print((++i) + " ");
		}
	}

	public void displayWinners() {
		Collections.sort(players);
		int maxPoints = 0;
		// calculate player point and store playrpoint list 
		Map<String, List<Player>> playerPointsMap = new TreeMap<String, List<Player>>();
		//itterate playerpoint list
		for (Player p : players) {

			maxPoints = p.getPoints();
			if (playerPointsMap.get(maxPoints + "") != null) {
				List<Player> lst = playerPointsMap.get(maxPoints + "");
				lst.add(p);
				playerPointsMap.put(maxPoints + "", lst);
			} else {
				List<Player> lst = new ArrayList<Player>();
				lst.add(p);
				playerPointsMap.put(maxPoints + "", lst);
			}
		}

		int s = players.size() - 1;
//		System.out.println(s);
		int getpnt = players.get(s).getPoints();
//		System.out.println(getpnt);
//		System.out.println("mypoint" + Integer.valueOf(getpnt));

		String pts = Integer.valueOf(getpnt).toString();
		System.out.println(pts);
//       player get second chanse and user enter 2 option thenm exit the game and display messGE
		if (playerPointsMap.get(pts) != null && playerPointsMap.get(pts).size() > 1) {
			System.out.println("Its a draw among the following players ");
			for (Player p : players) {
				System.out.println("Player :- " + p.getPlayerId());
			}
		} else if (playerPointsMap.get(pts) != null) {

			System.out.println("------------------------------------------------------------------------------");
			System.out.print(" ~~~~~~~~~~~~  winner is  ~~~~~~~~~~~~~~~~~~ :");
			System.out.println("Player :- " + playerPointsMap.get(pts).get(0).getPlayerId());
			System.out.println("------------------------------------------------------------------------------");
		}

	}
// get number of player and return one by one player number executed
	private Player getNextPlayer() {

		Player p = null;
		if (currentPlayerIdx == players.size()) {
			currentPlayerIdx = 1;
			p = players.get(0);
		} else {
			p = players.get(currentPlayerIdx);
			currentPlayerIdx++;
		}

		return p;
	}
//    Low card joker
	public void LowCardJoker(int numberOfPlayers) {
		NormalMode(numberOfPlayers);
		System.out.println("Low Card Joker mode ");

	}
// high card joker
	public void highCardJoker(int i) {
		NormalMode(numberOfPlayers);
		System.out.println("high card joker mode ");

	}
// any card joker 
	public void AnyCardJoker(int i) {
		System.out.println("any card joker mode ");

	}

}