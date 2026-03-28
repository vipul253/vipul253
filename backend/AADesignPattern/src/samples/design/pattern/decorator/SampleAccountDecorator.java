package samples.design.pattern.decorator;

public class SampleAccountDecorator extends AccountDecorator {
	public SampleAccountDecorator(Account account) {
		super(account);
	}

	@Override
	public void deposit(double amount) {
		System.out.println("Log before");
		acc.deposit(amount);
		System.out.println("Log After");
	}
}
