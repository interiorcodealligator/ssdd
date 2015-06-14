package ssdd;
import java.util.ArrayList;
import java.util.List;

public class MoneySystem {

	private List<Money> allMoney;
	private double insertedMoney;
	private double totalDue;

	public List<Money> getAllMoney() {
		return this.allMoney;
	}

	public void ListAllMoney(List<Money> allMoney) {
		this.allMoney = allMoney;
	}

	public double getInsertedMoney() {
		return this.insertedMoney;
	}
	
	public void setInsertedMoney(double insertedMoney) {
		this.insertedMoney = insertedMoney;
	}

	public void ListInsertedMoney(double insertedMoney) {
		this.insertedMoney = insertedMoney;
	}

	public double getTotalDue() {
		return this.totalDue;
	}
	
	public void setTotalDue(double totalDue) {
		totalDue = fixDoubleError(totalDue);
		this.totalDue = totalDue;
	}

	public void ListTotalDue(double totalDue) {
		this.totalDue = totalDue;
	}

	public MoneySystem() {
		// TODO - implement MoneySystem.MoneySystem
		allMoney = new ArrayList<Money>();
		Money[] temp = {
				new Money("10c", 0.10, 20, true),
				new Money("20c", 0.20, 20, true),
				new Money("50c", 0.5, 20, true),
				new Money("1 Euro", 1.0, 20, true),
				new Money("2 Euro", 2.0, 20, true),
				new Money("5 Euro", 5.0, 20, false),
				new Money("10 Euro", 10.0, 20, false),
				new Money("20 Euro", 20.0, 20, false)
		};
		for(Money e : temp)
			allMoney.add(e);
		this.insertedMoney = 0.00;
		this.totalDue = 0.00;
	}

	/**
	 * 
	 * @param money
	 */
	public MoneySystem(List<Money> money) {
		// TODO - implement MoneySystem.MoneySystem
		allMoney = new ArrayList<Money>();
		for(Money e : money)
			allMoney.add(e);
		this.insertedMoney = 0.00;
		this.totalDue = 0.00;
	}

	/**
	 * 
	 * @param insertedMoney
	 */
	public void insertMoney(Money insertedMoney) {
		// TODO - implement MoneySystem.insertMoney
		throw new UnsupportedOperationException();
	}

	public boolean checkIfPaymentComplete() {
		// TODO - implement MoneySystem.checkIfPaymentComplete
		return (insertedMoney >= totalDue);
	}

	public List<Money> returnChange(double amount) {
		ArrayList<Money> result = new ArrayList<Money>();
		
		for(int i = allMoney.size()-1; i >= 0; i--){
			Money m = allMoney.get(i);
			if(m.isCoin()){
				int q = 0;
				while(m.getQuantity() > 0 && amount >= m.getValue()){
					amount -= m.getValue();
					amount = this.fixDoubleError(amount);
					q++;
					m.takeOne();
				}
				if(q > 0)result.add(new Money(m.getName(), m.getValue(), q, true));
			}
		}
		return result;
	}

	/**
	 * 
	 * @param moneyIndex
	 */
	public Money getMoneyInfo(int moneyIndex) {
		// TODO - implement MoneySystem.getMoneyInfo
		return allMoney.get(moneyIndex);
	}

	public List<Money> returnInsertedMoney() {
		return returnChange(insertedMoney);
	}

	public void incrementMoney(int moneyIndex) {
		// TODO Auto-generated method stub
		allMoney.get(moneyIndex).addOne();
		insertedMoney += this.getMoneyInfo(moneyIndex).getValue();
		insertedMoney = fixDoubleError(insertedMoney);
	}
	
	public double fixDoubleError(double value){
		value *= 10;
		//value = (int)value;
		value = Math.round(value);
		value /= 10;
		return value;
	}

}