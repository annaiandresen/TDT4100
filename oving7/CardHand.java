package inheritance;

import java.util.List;

public class CardHand extends CardContainerImpl {
	List<Card> cardHand;

	public CardHand(int n) {
		super(n);
		cardHand = super.cardContainer;
	}

	public void addCard(Card card) {
		if (super.getCardCount() >= super.getMaxCardCount())
			throw new IllegalStateException("Too many cards in hand");
		cardHand.add(card);
	}

	public Card play(int n) {
		// n has to be above 0
		if (n < 0) {
			throw new IllegalArgumentException("n cannot be below 0");
		}

		// n cannot be greater than the number of cards in hand
		if (n > super.getCardCount()) {
			throw new IllegalArgumentException("Out of bounds");
		}
		Card card = cardHand.get(n);
		cardHand.remove(n);
		return card;

	}
}