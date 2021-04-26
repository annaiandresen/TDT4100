package inheritance;

public class SavingsAccount implements Account{
	private double balance;
	private double interestRate;
	
	public SavingsAccount(double interestRate) {
		if (interestRate < 0) {
			throw new IllegalArgumentException("The rate needs to be above 0");
		}
		this.interestRate = interestRate;
		balance = 0;
	}

	@Override
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be greater than 0");
		}
		balance += amount;
		
		
	}

	@Override
	public void withdraw(double amount) {
		if (amount > balance) {
			throw new IllegalStateException("Amount cannot be greater than balance");
		}
		else if (amount < 0) {
			throw new IllegalArgumentException("Amount must be greater than 0");
		}
		balance -= amount;
		
	}

	@Override
	public double getBalance() {
		return balance;
	}
	
	
	protected void endYearUpdate() {
		balance += balance * interestRate;
	}
}
