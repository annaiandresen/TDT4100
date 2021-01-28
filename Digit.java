package stateandbehavior;

public class Digit {
	private int value = 0;
	private int base;
	
	//Constructor
	public Digit(int base) {
		this.base = base;
	}
	
	//Getters
	public int getValue() {
		return value;
	}
	
	public int getBase() {
		return base;
	}
	
	//Methods
	public boolean increment() {
		value += 1;
		if (value == base) {
			value = 0;
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		//vil returnere ABC... hvis value > 10
		//kan lage en streng hvor vi aksesserer elementet med posisjon "value"
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return str.charAt(value) + "";
		//tom streng på slutten ettersom den charAt ikke returnerer en streng?
		//charAt() returnerer bokstaven/objektet på indexen som er spesifisert i en streng.
	}
	
	//Main
	public static void main(String[] args) {
		Digit digit = new Digit(16);
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
		System.out.println(digit);
		digit.increment();
	}
}
