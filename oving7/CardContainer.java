package inheritance;

public interface CardContainer extends Iterable<Card> {
	
	Card getCard(int n);
	
	int getCardCount();
	
}
