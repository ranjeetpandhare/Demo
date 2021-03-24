package com.poker.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CARD implements Comparable<CARD> {
	public enum CARDNUMBER {
		//create constants using enum
		ACE(14), KING(13), QUEEN(12), JACK(11), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
		TEN(10);

		private int ord;

		private CARDNUMBER(int i) {
			this.ord = i;
		}

		public int getOrd() {
			return ord;
		}
	}
// constant cardtype using enum
	public enum CARDTYPE {
		CLUB, DIAMOND, HEARTS, SPADE;
	}

	CARDNUMBER cdNumber;
	CARDTYPE cdType;

	public CARDNUMBER getCdNumber() {
		return cdNumber;
	}

	public CARDTYPE getCdType() {
		return cdType;
	}

	public static List<CARD> getPackOfCards() {
//      store card in aaraylist
		List<CARD> crdLst = new ArrayList<CARD>();
//      to itterate data using for loop
		for (CARDTYPE types : CARDTYPE.values()) {
//			System.out.println(types);
			for (CARDNUMBER cNums : CARDNUMBER.values()) {
//				System.out.println(cNums);
//           create card object 
				CARD cd = new CARD();
				cd.cdNumber = cNums;
				cd.cdType = types;
				crdLst.add(cd);
			}

		}
		return crdLst;
	}
//          this method is shuffle all cards list
	public static void shuffleCards(List<CARD> cards) {
		// this is collection class method
		Collections.shuffle(cards);
	}
//           compare  string lexogrphically return the number
	@Override
	public int compareTo(CARD o) {
		if (this.getCdNumber() == o.getCdNumber()) {
			return 0;
		} else if (this.getCdNumber().getOrd() > o.getCdNumber().getOrd()) {
			return 1;
		} else
			return -1;
	}
//     override object class method  and return cardnumber and card type 
	@Override
	public String toString() {
		return "CARD [Card Number=" + cdNumber + ", Card Type=" + cdType + "]";
	}
}
