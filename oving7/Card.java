package inheritance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

public class Card implements Comparable<Card>{
	private char suit;
	private int face;
	public static final List<Character> suits = Arrays.asList(
			'S', 'H', 'D', 'C');
	
	public Card(char suit, int face) {
		if (face<1 || face>13) {
			throw new IllegalArgumentException("Invalid face value");
		} else if (!suits.contains(suit)) {
			throw new IllegalArgumentException("Invalid suit");
		}
		this.suit = suit;
		this.face = face;
	}

	public char getSuit() {
		return suit;
	}

	public int getFace() {
		return face;
	}
	
	@Override
	public String toString() {
		String number = Integer.toString(face);
		String suit = String.valueOf(this.suit);
		return suit+number;
	} 
	

	@Override
	public int compareTo(Card card) {
		//spar>hjerter>ruter>kløver
		//dersom suit == card.getSuit, sammenlign verdi
		if (suit != card.getSuit()) {
			if (suit == 'S') {
				return 1;
			}
			else if (suit == 'C') {
				return -1;
			}
			
			else if (suit == 'H' && card.getSuit() == 'S') {
				return -1;
			}
			else if (suit == 'D' && card.getSuit() != 'C') {
				return -1;
			}

			else {
				return 1;
			}
		}
		else {
			if (face > card.getFace()) {
				return 1;
			} else if (face < card.getFace()){
				return -1;
			} else {
				return 0;
			}
		}
	}

}