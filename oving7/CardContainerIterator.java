package inheritance;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {
	private CardContainer cardContainer;
	private int index; //liste
	
	//konstruktør
	public CardContainerIterator(CardContainer cardContainer) {
		this.cardContainer = cardContainer; 
		index = 0;
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
