package inheritance;

import java.util.ArrayList;
import java.util.List;

public class CardDeck extends CardContainerImpl{
	private List<Card> cardDeck;
	
	public CardDeck(int n) {
		super(52);
		if (n < 1 || n > 13) {
			throw new IllegalArgumentException("Number needs to be between 1 and 13!");
		}
		
		cardDeck = super.cardContainer;
		for (char suit: Card.suits) {
			for (int i = 1; i<(n+1); i++) {
				cardDeck.add(new Card(suit, i));
			}
		} 
	} 
	
	//shuffle
	public void shufflePerfectly() {
		ArrayList<Card> shuffled = new ArrayList<>();
		int mid = cardDeck.size()/2; 
		//mid is always even as the deck consists of n*2^2 cards
		
		//splitting cardDeck into two ArrayLists:
		ArrayList<Card> top = new ArrayList<>();
		ArrayList<Card> bottom = new ArrayList<>();
		
		//top part
		for (int i = 0; i < mid; i++) {
			top.add(cardDeck.get(i));
		}
		
		//bottom part
		for (int i = mid; i < cardDeck.size(); i++) {
			bottom.add(cardDeck.get(i));
		}
		
		//actual shuffle
		for (int i = 0; i<top.size(); i++) {
			shuffled.add(top.get(i));
			shuffled.add(bottom.get(i));
		}
		cardDeck = shuffled;
	}
	
	
    public void deal(CardHand hand, int n) {
		int count = this.getCardCount();
		for (int i = count - 1; i > count - n - 1; i--) {
			hand.addCard(this.getCard(i));
			this.cardDeck.remove(this.getCard(i));
		}
    }
}