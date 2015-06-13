package ssdd;
public class Money extends Item {

	private boolean isCoin;

	/**
	 * 
	 * @param name
	 * @param value
	 * @param quantity
	 * @param isCoin
	 */
	public Money(String name, double value, int quantity, boolean isCoin) {
		// TODO - implement Money.Money
		super(name, value, quantity);
		this.isCoin = isCoin;
	}

	public boolean isCoin() {
		// TODO - implement Money.isCoin
		return this.isCoin;
	}
	
	public String toString(){
		return this.name;
	}

}