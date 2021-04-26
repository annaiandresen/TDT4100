package objectstructures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CoffeeCupTest {
	private CoffeeCup cup;
	
	//test constructor
	@Test
    public void testConstructor() {
		//first empty constructor
		CoffeeCup cup1 = new CoffeeCup();
		assertEquals(0.0, cup1.getCapacity(), "Capacity should be 0.0");
		assertEquals(0.0, cup1.getCurrentVolume(), "Volume should be 0.0");
		
		//constructor with start values
		CoffeeCup cup2 = new CoffeeCup(4.0, 3.5);
		assertEquals(4.0, cup2.getCapacity(), "Capacity should be 4.0, but got "+cup2.getCapacity());
		assertEquals(3.5, cup2.getCurrentVolume(), "Volume should be 3.5. but got "+ cup2.getCurrentVolume());
    }
	
	@BeforeEach
	public void setup() {
		cup = new CoffeeCup(5.0, 3.5);
	}
	
	//test getCapacity
	@Test
	public void testGetCapacity() {
		assertEquals(5.0, cup.getCapacity());
	}
	
	@Test
	public void testGetCurrentVolume() {
		assertEquals(3.5, cup.getCurrentVolume());
	}
	
	//test increaseCupSize
	@Test
	public void testIncreaseCupSize() {
		//increases cup size based on its current cup size
		cup.increaseCupSize(3.0);
		assertEquals(8.0, cup.getCapacity(), "Capacity should be 8.0, but got "+ cup.getCapacity());
	}
	
	//test drinkCoffee
	@Test
	public void testDrinkCoffee() {
		cup.drinkCoffee(3.5);
		assertEquals(0.0, cup.getCurrentVolume());
	}
	
	//test fillCoffee
	@Test
	public void testFillCoffee() {
		cup.fillCoffee(1.0);
		assertEquals(4.5, cup.getCurrentVolume());
	}
}
