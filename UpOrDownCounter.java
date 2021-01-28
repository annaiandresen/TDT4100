package stateandbehavior;

public class UpOrDownCounter {
	//states
	private int counter;
	private int end; 
	
	//Constructor
	public UpOrDownCounter(int start, int end) {
	//throw new IllegalArgumentException() for å finne exceptions
		if (start == end) {
			throw new IllegalArgumentException("start and end value is equal");
		}
		this.end = end;
		this.counter = start;
	}
	
	//Getter
	public int getCounter() {
		return counter;
	}
	
	boolean count() {
		return count(1);
	}
	//Method
	//beveger telleren i retning av slutt-verdien og returnerer true så lenge den ikke har nådd den, altså om telleren har mer igjen, og false ellers.
	public boolean count(int inc) {
		if (counter == end) {
			return false;
		} else if (counter < end) {
			counter += inc;
			return true;
		} else {
			counter -=inc;
			return true;
		}
	}
	
	@Override
    public String toString() {
        return "[Counter counter=" + counter + " end=" + end + "]";
    }

    
	//Main
    public static void main(String[] args) {
    	UpOrDownCounter c1 = new UpOrDownCounter(5, 3);
    	System.out.println(c1);
    	c1.count();
    	System.out.println(c1);
    	c1.count();
    	System.out.println(c1);
    	c1.count();
    	c1.getCounter();
    	System.out.println(c1);
    	c1.count();
    	System.out.println(c1); 
    	System.out.println(c1);
    	c1.count();
    	System.out.println(c1);
    }
}
