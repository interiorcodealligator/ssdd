package ssdd;
public class Card {

	private double balance;
	private long accountNo;

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public Card() {
		// TODO - implement Card.Card
		this.accountNo = 0;
		this.balance = 0.0;
	}

	/**
	 * 
	 * @param balance
	 * @param accountNo
	 */
	public Card(long accountNo, double balance) {
		// TODO - implement Card.Card
		this.accountNo = accountNo;
		this.balance = balance;
	}

}