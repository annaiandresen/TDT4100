package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class CardHand {
	List<Card> cardHand = new ArrayList<>();
	
    public Card getCard(int n) {
        try {
            return cardHand.get(n);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("This card does not exist");
        }
    }
    
	public int getCardCount() {
		return cardHand.size();
	}
	
	public void addCard(Card card) {
		cardHand.add(card);
	}
	
	public Card play(int n) {
		//n has to be above 0
		if (n < 0) {
			throw new IllegalArgumentException("n cannot be below 0");
		}
		
		//n cannot be greater than the number of cards in hand
		if (n > getCardCount()) {
			throw new IllegalArgumentException("Out of bounds");
		}
		Card card = cardHand.get(n);
		cardHand.remove(n);
		return card;
		
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i<cardHand.size(); i++) {
			str += cardHand.get(i)+" ";
		}
		return str;
	}
	
	public static void main(String[] args) {
		CardHand ch = new CardHand();
	}
}
