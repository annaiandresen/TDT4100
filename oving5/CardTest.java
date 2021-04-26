package interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardTest {
	Card s1;
	Card s1COPY;
	Card h1;
	Card d1;
	Card c1;
	Card s13;
	Card h13;
	Card d13;
	Card c13;
	List<Card> cards;
	List<Card> expected;

	@BeforeEach
	public void setUp() {
		s1 = new Card('S', 1);
		s1COPY = new Card('S', 1);
		h1 = new Card('H', 1);
		d1 = new Card('D', 1);
		c1 = new Card('C', 1);
		s13 = new Card('S', 13);
		h13 = new Card('H', 13);
		d13 = new Card('D', 13);
		c13 = new Card('C', 13);
		cards = CollectionLiterals.newArrayList(s1, s13, h1, h13, d1, d13, c1, c13);
	}
	@Test
	public void testCompareTo() {
		assertEquals(1, h1.compareTo(d1));
		assertEquals(-1, h13.compareTo(s13));
		assertEquals(0, s1.compareTo(s1COPY));
		assertEquals(1, d1.compareTo(c1));
	}
	
	//testing sort
	@Test
	public void testSorting() {
		expected = CollectionLiterals.newArrayList(c1, c13, d1, d13, h1, h13, s1, s13);
		List<Card> cardList = new ArrayList<>();
		cardList.add(c1);
		cardList.add(d1);
		cardList.add(h1);
		cardList.add(s1);
		cardList.add(c13);
		cardList.add(d13);
		cardList.add(h13);
		cardList.add(s13);
		
		Collections.sort(cardList);
		assertEquals(expected, cardList);
	}
	
	

}

