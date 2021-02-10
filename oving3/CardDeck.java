package encapsulation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CardDeck {
	private final Card card;
	private int cardCount;
	public static final List<Character> suits = Arrays.asList('S', 'H', 'D', 'C');
	
	public CardDeck(int n) {
		for (int i = 0; i<(n+1); i++) {
			for (char suit: suits) {
				System.out.println(card);
			}
			
		}
	}
	
	public Card getCard(int n) {
		return card;
	}
	public int getCardCount() {
		return cardCount;
	}
	
	public void shufflePerfectly() {
		
	}
	
}
