package interfaces;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
	private char[] suits = {'S','H','D','C'}; //går det ikke an å gjenbruke List fra Card? Fikk ikke til
	private boolean ace;
	private char trump;
	
	public CardComparator(boolean ace, char trump) {
		this.ace = ace;
		this.trump = trump;
		
	}

	@Override
	public int compare(Card o1, Card o2) {
		//if ace is true, 1 is highest
		// if char is set to something other than 'S', that suit is considered highest
		
		//if both cards have the same suit
		if (o1.getSuit() == o2.getSuit()) {
			if (!ace) {	
				if (o1.getFace() < o2.getFace()) {
					return -1;
				} else if (o1.getFace() > o2.getFace()) {
					return 1;
				} else {
					return 0; //funker det med o1.getFace() - o2.getFace()?
				}
			}
			else {
				if (o1.getFace() == o2.getFace()){
					return 0;
				} else if (o1.getFace() == 1) {
					return 1;
				} else if (o2.getFace() == 1) {
					return -1;
				} else if (o1.getFace() < o2.getFace()) {
					return -1;
				} else if (o1.getFace() > o2.getFace()) {
					return 1;
				}
			}
		}
		
		//trump
		if (o1.getSuit() == trump) {
			return 1;
		}
		else if (o2.getSuit() == trump) {
			return -1;
		}
		
		int value1 = 0;
		int value2 = 0;
		
		for (int i = 0; i < suits.length; i++) {
			if(o1.getSuit() == suits[i]) {
				value1 = i;
			}
			if (o2.getSuit() == suits[i]) {
				value2 = i;
			}
		}
		if (value1 > value2) {
			return -1;
		} else {
			return 1;
		}
	}

}
