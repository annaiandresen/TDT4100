package inheritance;

public abstract class AbstractAccount {
	private double balance;
	
	public AbstractAccount() {
		balance = 0;
	}
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be greater than 0");
		}
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be greater than 0");
		}
		internalWithdraw(amount);
		balance -= amount;
	}
	

	public double getBalance() {
		return balance;
	}
	
	protected abstract void internalWithdraw(double amount) throws IllegalStateException;
	//hva betyr det egentlig å skrive throws <errortype> når man definerer en metode?
	
	protected void payFee(double fee) {
		if (fee > balance) {
			throw new IllegalArgumentException();
		}
		balance = balance - fee;
	}

}
