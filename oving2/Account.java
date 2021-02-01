package encapsulation;

public class Account {
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate) {
		if (balance < 0 || interestRate < 0)
			throw new IllegalArgumentException("Balance or interest rate is negative!");
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	//Getters and setters

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		if (interestRate < 0)
			throw new IllegalArgumentException("Invalid interest rate");
		this.interestRate = interestRate;
	}
	
	
	//Methods
	
	public void deposit(double amount) {
		if (amount < 0)
			throw new IllegalArgumentException("Negative deposit amount!");
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if (amount>= 0) {
			if (amount > balance) {
				throw new IllegalArgumentException("Amount is greater than balance");
			}
			else {
				balance -= amount;
			}
		}
	}
	
	public void addInterest() {
		balance += balance * (interestRate/100);
	}
	
	@Override
	public String toString() {
		//overrider den innebygde toString() 
		return "Du har " + balance + " på bankkontoen med " + interestRate + " rente.";
	}
	
	public static void main(String[] args) {
		Account ac = new Account(0, 0);
		ac.deposit(25.6);
		ac.setInterestRate(0.04);
		ac.addInterest();
		System.out.println(ac);
	}
	
}
