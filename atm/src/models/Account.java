package models;

public class Account {
	private int Account;
	private int Money;
	
	private Account() {}
	
	public int getAccount() {
		return this.Account;
	}
	
	public int getMoney() {
		return this.Money;
	}
	
	public void setMoney(int money) {
		this.Money += money;
	}
	
	public Account(int Account) {
		this.Account = Account;
		this.Money = 10000;
	}
}
