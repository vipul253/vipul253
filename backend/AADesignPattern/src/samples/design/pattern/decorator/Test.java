package samples.design.pattern.decorator;

public class Test {
	public static void main(String[] args) {
		Account acc1 = new SampleAccount(123, "neiu", 1000);
		Account acc2 = new SampleAccountDecorator(acc1);
		// here acc1 decorates acc and adds more functionality
		// like logging deposit and withdraw amount
		acc1.deposit(100);
		acc2.deposit(100);
	}
}
