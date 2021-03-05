package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private List<Card> cardDeck;
	
	public CardDeck(int n) {
		if (n < 1 || n > 13) {
			throw new IllegalArgumentException("Number needs to be between 1 and 13!");
		}
		cardDeck = new ArrayList<Card>(); 
		for (char suit: Card.suits) {
			for (int i = 1; i<(n+1); i++) {
				cardDeck.add(new Card(suit, i));
			}
		} 
	} 

	//Getters
	public Card getCard(int position) {
		if (position < 0 || position>cardDeck.size()) {
			throw new IllegalArgumentException("Invalid position");
		}
		return cardDeck.get(position);
	}
	public int getCardCount() {
		return cardDeck.size();
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
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i<cardDeck.size(); i++) {
			str += cardDeck.get(i)+" ";
		}
		return str;
	}
	
	public static void main(String[] args) {
		CardDeck cd = new CardDeck (3);
		System.out.println(cd);
		cd.shufflePerfectly();
		System.out.println(cd);
		CardHand hand = new CardHand();
		cd.deal(hand,  4);
		System.out.println(hand);
		System.out.println(cd);
	}
	
}