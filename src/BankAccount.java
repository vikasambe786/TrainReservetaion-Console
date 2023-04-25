
public class BankAccount {
	
	private int accountNumber;
	private int accountBalance;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	public void deposit(int amount) {
		accountBalance+=amount;
	}
	

	public  void withdraw(int amount) {
		accountBalance-=amount;
	}
	
	
	public void showBalance() {
		System.out.println("Balance : "+accountBalance);
	}

}
