package ssdd;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	private ArrayList<Item> selectedDrinks;
	private DrinkDispenser drinkDispenser;
	private MoneySystem moneySystem;
	private CardSystem cardSystem;
	MainGUI mainGUI;

	public Controller(){
		selectedDrinks = new ArrayList<Item>();
		drinkDispenser = new DrinkDispenser();
		moneySystem = new MoneySystem();
		cardSystem = new CardSystem();
		selectedDrinks = new ArrayList<Item>();
		for(Item e : this.drinkDispenser.getDrinkStock()){
			Item clone = e.clone();
			clone.setQuantity(0);
			selectedDrinks.add(clone);
		}
		mainGUI = new MainGUI(this);
	}
	/**
	 * 
	 * @param drinkIndex
	 */
	public void addDrink(int drinkIndex) {
		// TODO - implement Controller.addDrink
		Item currentDrink = this.drinkDispenser.getDrinkInfo(drinkIndex);
		if(this.drinkDispenser.checkIfDrinkAvailable(currentDrink, selectedDrinks.get(drinkIndex).getQuantity())){
			this.selectedDrinks.get(drinkIndex).addOne();
			double totalDue = this.calculateTotalDue();
			this.moneySystem.setTotalDue(totalDue);
			this.mainGUI.updateSelectedDrink(drinkIndex, selectedDrinks.get(drinkIndex).getQuantity());
			this.mainGUI.updateTotalDue(totalDue);
		}	
	}

	/**
	 * 
	 * @param drinkIndex
	 */
	public void removeDrink(int drinkIndex) {
		// TODO - implement Controller.removeDrink	
		if(selectedDrinks.get(drinkIndex).getQuantity() > 0){
			this.selectedDrinks.get(drinkIndex).takeOne();		
			double totalDue = this.calculateTotalDue();
			this.moneySystem.setTotalDue(totalDue);
			this.mainGUI.updateSelectedDrink(drinkIndex, selectedDrinks.get(drinkIndex).getQuantity());
			this.mainGUI.updateTotalDue(totalDue);
		}
	}

	public void updateDrinksStock() {
		// TODO - implement Controller.updateDrinksStock
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param moneyIndex
	 */
	public void insertMoney(int moneyIndex) {
		// TODO - implement Controller.insertMoney
		if(this.moneySystem.getTotalDue() > 0){
			this.moneySystem.incrementMoney(moneyIndex);
			if(this.moneySystem.checkIfPaymentComplete()){
				this.finalizeOrder();
			}
			else{
				this.mainGUI.updateTotalDue(this.calculateTotalDue());
				this.mainGUI.updateInsertedMoney(this.moneySystem.getInsertedMoney());
			}
		}
		System.out.println("Inserted " + this.moneySystem.getMoneyInfo(moneyIndex) + "\n"
				+ "there are " + this.moneySystem.getMoneyInfo(moneyIndex).getQuantity() + " " + this.moneySystem.getMoneyInfo(moneyIndex));
	}

	/**
	 * 
	 * @param card
	 */
	public void insertCard(long accountNo) {
		// TODO - implement Controller.insertCard
		double totalDue = moneySystem.getTotalDue();
		this.cardSystem.insertCard(cardSystem.getCard(accountNo));
		if(this.cardSystem.hasEnoughBalance(totalDue)){
			this.cardSystem.processPayment(totalDue);
			Card returned = this.cardSystem.returnCard();
			finalizeOrder(returned);
		}
		else{
			this.mainGUI.outputText("You don't have money");
		}
	}

	/*public void processMoneyPayment() {
		// TODO - implement Controller.processMoneyPayment
		throw new UnsupportedOperationException();
	}

	public void processCardPayment() {
		// TODO - implement Controller.processCardPayment
		throw new UnsupportedOperationException();
	}*/

	public void finalizeOrder() {
		// money
		/*
		 * 1. dispense the drinks
		 * 2. return change
		 * 3. output
		 * 4. reset
		 */
		this.drinkDispenser.dispenseDrinks(selectedDrinks);
		double plannedChange = this.moneySystem.getInsertedMoney() - this.moneySystem.getTotalDue();
		List<Money> change = this.moneySystem.returnChange(plannedChange);
		String output = "";
		double givenChange = 0.0;
		output += "You paid " + this.moneySystem.getInsertedMoney() + "\n";
		output += "Due was " + this.moneySystem.getTotalDue() + "\n";
		output += "Drinks: \n";
		for(Item d : selectedDrinks){
			if(d.getQuantity() != 0) output += "Got " + d.getQuantity() + " " + d.getName() + "\n";
		}
		output += "Change: \n";
		for(Money coin : change)
		{
			output += "Got " + coin.getName() + " (" + coin.getQuantity() + ")\n";
			givenChange += coin.getValue() * coin.getQuantity();
		}
		plannedChange *= 100;
		plannedChange = Math.round(plannedChange);
		plannedChange /= 100;
		if(givenChange != plannedChange) output += "Oops sorry no more change!" + givenChange + " " + plannedChange;
		this.mainGUI.outputText(output);
		
		this.reset();
	}
	
	public void reset(){
		this.moneySystem.setTotalDue(0.0);
		this.moneySystem.setInsertedMoney(0.0);
		this.updateDrinksStock();
		this.mainGUI.updateInsertedMoney(0.0);
		this.mainGUI.updateTotalDue(0.0);
		int i = 0;
		for(Item drink : selectedDrinks){
			drink.setQuantity(0);
			this.mainGUI.updateSelectedDrink(i, 0);
			i++;
		}	
	}
	
	public void finalizeOrder(Card card){
		// card
		/*
		 * 1. dispense
		 * 2. return card
		 * 3. output
		 * 4. reset
		 */
	}

	/**
	 * 
	 * @param accountNo
	 */
	public double doMagic(long accountNo) {
		// TODO - implement Controller.doMagic
		Card card = this.cardSystem.doMagic(accountNo);
		return card.getBalance();
	}

	public double calculateTotalDue() {
		// TODO - implement Controller.calculateTotalDue
		double total=0;
		for(Item e : this.selectedDrinks){
			total += e.getValue()*e.getQuantity();
		}
		return total;
	}

	public void cancelOrder() {
		double insertedMoney = this.moneySystem.getInsertedMoney();
		if (insertedMoney > 0){
			List<Money> change = this.moneySystem.returnInsertedMoney();
			String changeOutput = "";
			double total = 0;
			for(Money coin : change)
			{
				changeOutput += "Got " + coin.getName() + " (" + coin.getQuantity() + ")\n";
				total += coin.getValue() * coin.getQuantity();
			}
			if(total != insertedMoney) changeOutput += "Oops sorry no more change!";
			this.mainGUI.outputText(changeOutput);
			reset();
		}
	}
	
	public List<Item> getDrinkStock(){
		return this.drinkDispenser.getDrinkStock();
	}
	
	public List<Money> getMoneyStock(){
		return this.moneySystem.getAllMoney();
	}

}