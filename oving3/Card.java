package encapsulation;

public class Card {
	private char suit;
	private int face;
	
	public Card(char suit, int face) {
		if (face<1 || face>13) {
			throw new IllegalArgumentException("Invalid face value");
		} else if (suit != 'S' || suit != 'H' || suit != 'D' || suit != 'C') {
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
		return suit+face+"";
	}
	

}
