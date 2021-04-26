package inheritance;

public class DebitAccount extends AbstractAccount{

	@Override
	public void internalWithdraw(double amount) throws IllegalStateException {
		if (amount > super.getBalance()) {
			throw new IllegalStateException("Insufficient balance");
		}
	}

}
