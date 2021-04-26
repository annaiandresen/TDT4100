package inheritance;

public class CreditAccount extends AbstractAccount {
	private double creditLine;
	
	
	public CreditAccount(double creditLine) {
		super();
		setCreditLine(creditLine);
	}
	
	public double getCreditLine() {
		return creditLine;
	}
	
	public void setCreditLine(double creditLine) {
		if (creditLine < 0) {
			throw new IllegalArgumentException();
		}
		
		if (super.getBalance() < 0) {
			if ((super.getBalance() + creditLine) < 0) {
				throw new IllegalStateException("You balance is too low");
			}
		}
		
		this.creditLine = creditLine;
	}
	@Override
	protected void internalWithdraw(double amount) throws IllegalStateException {
		if (amount > (creditLine + super.getBalance())) {
			throw new IllegalStateException();
		}
		
	}

}
