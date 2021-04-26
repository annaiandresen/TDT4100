package inheritance;

public class BSU extends SavingsAccount{
	private double limit;
	private double thisYearsDeposit;

	public BSU(double interestRate, double limit) {
		super(interestRate);
		if (limit <= 0) {
			throw new IllegalArgumentException("Yearly limit needs to be greater than 0");
		}
		this.limit = limit;
	}
	
	public double getTaxDeduction() { 
		return thisYearsDeposit*0.2;
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount > thisYearsDeposit) {
			throw new IllegalStateException("Cannot withdraw this much");
		}
		super.withdraw(amount);
		thisYearsDeposit -= amount;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		getTaxDeduction();
		thisYearsDeposit = 0;
	}
	
	@Override
	public void deposit(double amount) {
		if (checkIfLimitIsReached(amount)) {
			throw new IllegalStateException("You cannot deposit that much, it will exceed the yearly limit");
		} 
		super.deposit(amount);
		thisYearsDeposit += amount;
	}
	
	private boolean checkIfLimitIsReached(double amount) {
		if (limit == thisYearsDeposit) {
			System.out.println("Yearly limit has already been reached");
			return true;
		} else if ((amount + thisYearsDeposit)>limit)
			return true;
		else {
			return false;
		}
	}
}
