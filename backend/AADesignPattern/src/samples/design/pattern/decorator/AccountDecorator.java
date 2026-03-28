package samples.design.pattern.decorator;

public abstract class AccountDecorator implements Account {
	protected Account acc;

	public AccountDecorator(Account account) {
		this.acc = account;
	}

	public void deposit(double amount) {
		acc.deposit(amount);
	}

	public void withdraw(double amount) {
		acc.withdraw(amount);
	}
}
