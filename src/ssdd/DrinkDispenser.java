package ssdd;
import java.util.ArrayList;
import java.util.List;

public class DrinkDispenser {

	private List<Item> drinkStock;

	public List<Item> getDrinkStock() {
		return this.drinkStock;
	}

	public void setDrinkStock(List<Item> drinkStock) {
		this.drinkStock = drinkStock;
	}

	public DrinkDispenser() {
		// TODO - implement DrinkDispenser.DrinkDispenser
		drinkStock = new ArrayList<Item>();
		Item[] temp = {
				new Item("Coke", 1.10, 20),
				new Item("Sprite", 1.10, 20),
				new Item("Beer", 2.30, 20),
				new Item("Light Beer", 2.40, 20),
				new Item("Fun Beer", 2.10, 20),
				new Item("Mineral Water", 1.00, 20),
				new Item("Apple Juice", 1.80, 20),
				new Item("Orange Juice", 1.90, 20),
				new Item("Tomato Juice", 1.90, 20),
				new Item("Wine", 2.80, 20)
		};
		for(Item e : temp)
			drinkStock.add(e);
	}

	/**
	 * 
	 * @param drinkStock
	 */
	public DrinkDispenser(List<Item> drinkStock) {
		// TODO - implement DrinkDispenser.DrinkDispenser
		this.drinkStock = new ArrayList<Item>();
		this.drinkStock.addAll(drinkStock);
	}

	/**
	 * Only for Construct, not for user usage
	 * @param drink
	 */
	public void insertDrink(Item drink) {
		// TODO - implement DrinkDispenser.insertDrink
		drinkStock.add(drink);
	}

	/**
	 * 
	 * @param selectedDrinks
	 */
	public void dispenseDrinks(List<Item> selectedDrinks) {
		// TODO - implement DrinkDispenser.dispenseDrinks
		for(int i = 0; i < selectedDrinks.size(); i++){
			Item stock = drinkStock.get(i);
			Item selected = selectedDrinks.get(i);
			for(int j = 0; j < selected.getQuantity(); j++) stock.takeOne();
		}
	}

	/**
	 * 
	 * @param drink
	 */
	public boolean checkIfDrinkAvailable(Item drink, int alreadySelected) {
		if (drink.getQuantity() - alreadySelected > 0)
			return true;
		else return false;
	}

	/**
	 * 
	 * @param drinkIndex
	 */
	public Item getDrinkInfo(int drinkIndex) {
		// TODO - implement DrinkDispenser.getDrinkInfo
		return drinkStock.get(drinkIndex);
	}

}