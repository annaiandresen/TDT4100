package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {
	private CardContainer cardContainer;
	private int index = 0; //liste
	
	//konstruktør
	public CardContainerIterator(CardContainer cardContainer) {
		this.cardContainer = cardContainer; 
	}
	
	
	@Override
	public boolean hasNext() {
		//returnerer true når index er mindre enn antall kort
		return index < cardContainer.getCardCount();
	}

	@Override
	public Card next() {
		return cardContainer.getCard(index++);
	}

}
