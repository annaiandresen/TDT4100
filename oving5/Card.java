package interfaces;

import java.util.ArrayList;
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
		//spar>hjerter>ruter>kl�ver
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
	
	public static void main(String[] args) {
		Card s1 = new Card('S', 1);
		Card h1 = new Card('H', 1);
		Card d12 = new Card('D', 12);
		Card c2 = new Card('C', 2);
		List<Card> cards = CollectionLiterals.newArrayList(h1, d12, c2, s1);
		
		Collections.sort(cards, new CardComparator(false, 'H'));
		System.out.println(cards);
		
	}

}