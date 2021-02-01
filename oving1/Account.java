package stateandbehavior;

public class Account {
	//initialisere variabler
	public double balance;
	public double interestRate;
	
	
	//Konstruktør
	public Account(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	//Getters
	public double getInterestRate() {
		return interestRate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//Setter
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
	@Override
	public String toString() {
		//overrider den innebygde toString() 
		return "Du har " + balance + " på bankkontoen med " + interestRate + " rente.";
	}
	
	//Metoder
	
	public boolean deposit (double amount) {
		if (amount < 0) {
			return false;
		} else {
			this.balance += amount;
			return true;
		}
	}
	
	public void addInterest() {
		//void fordi den ikke returnerer noe
		this.balance += this.balance * (this.interestRate/100);
	}
	
	//Main
	public static void main(String[] args) {
    	//static gjør at en metode eller et felt hører til en klasse, og ikke et objekt. Det at main-metoden er static, betyr at vi kan kalle metoden, uten å kalle instansen av en klasse.
    	Account account = new Account(0, 0.09); //lager en instans av klassen Account
    	account.deposit(1000);
        System.out.println(account);
        account.addInterest();
        System.out.println(account);
        account.setInterestRate(0.08);
        System.out.println(account);
        account.addInterest();
        System.out.println(account);
    }
}