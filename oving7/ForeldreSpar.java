package inheritance;

public class ForeldreSpar extends SavingsAccount{
	public final int withdrawals;
	private int counter;

	public ForeldreSpar(double interestRate, int withdrawals) {
		super(interestRate);
		if (withdrawals < 0) {
			throw new IllegalArgumentException("The amount of times you can make withdrawals needs to be greater than 0");
		}
		this.withdrawals = withdrawals;
	}
	
	public int getRemainingWithdrawals() {
		if (counter > withdrawals) {
			throw new IllegalStateException();
		}
		return withdrawals - counter;
	}
	
	@Override
	public void withdraw(double amount) {
		if (getRemainingWithdrawals() == 0) {
			throw new IllegalStateException("Cannot withdraw more this year");
		}
		super.withdraw(amount);
		counter++;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		counter = 0;
		
	}
}
