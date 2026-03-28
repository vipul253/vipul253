package samples.design.pattern.decorator;

public class SampleAccount implements Account {
	private int number;
	private String name;
	private double balance;

	public SampleAccount(int number, String name, double balance) {
		this.number = number;
		this.name = name;
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println(this.getBalance());

	}

	@Override
	public void withdraw(double amount) {
		this.balance -= amount;

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
