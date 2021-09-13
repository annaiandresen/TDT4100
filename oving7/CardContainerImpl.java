package inheritance;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class CardContainerImpl implements CardContainer{
	protected List<Card> cardContainer;
	private int maxCardCount;
	
	
	public CardContainerImpl(int n) {
		cardContainer = new ArrayList<>();
		maxCardCount = n;
	}
	
	public int getMaxCardCount() {
		return maxCardCount;
	}
	
	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}

	@Override
	public Card getCard(int position) {
		if (position < 0 || position>cardContainer.size()) {
			throw new IllegalArgumentException("Invalid position");
		}
		return cardContainer.get(position);
	}

	@Override
	public int getCardCount() {
		return cardContainer.size();
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i<cardContainer.size(); i++) {
			str += cardContainer.get(i)+" ";
		}
		return str;
	}

}
