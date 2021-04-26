package inheritance;

public class SavingsAccount2 extends AbstractAccount {
	private int withdrawals;
	private double fee;
	
	public SavingsAccount2(int withdrawals, double fee) {
		super();
		if (withdrawals < 0) {
			throw new IllegalArgumentException();
		}
		if (fee < 0) {
			throw new IllegalArgumentException();
		}
		this.withdrawals = withdrawals;
		this.fee = fee;
	}

	@Override
	protected void internalWithdraw(double amount) throws IllegalStateException {
		if (super.getBalance() < amount || (super.getBalance() - fee <= amount)) {
			throw new IllegalStateException();
		}
		
		if (withdrawals <= 0) {
			super.payFee(fee);
		}

		withdrawals --;
	}
	

	public static void main(String[] args) {
		SavingsAccount2 ac = new SavingsAccount2(1, 50.0);
		ac.deposit(20000.0);
		ac.withdraw(5000.0); //withdrawals = 0
		System.out.println(ac.getBalance());
		ac.withdraw(10000.0);
		System.out.println(ac.getBalance());
	}

}
