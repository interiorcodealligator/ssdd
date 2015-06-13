package ssdd;
public class Item implements Cloneable{

	protected String name;
	protected double value;
	protected int quantity;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addOne() {
		// TODO - implement Item.addOne
		this.quantity++;
	}

	public void takeOne() {
		// TODO - implement Item.takeOne
		this.quantity--;
	}

	public Item() {
		// TODO - implement Item.Item
		this.name = "";
		this.quantity = 0;
		this.value = 0.0;
	}
	
	public Item clone(){
		try {
			return (Item) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * 
	 * @param name
	 * @param value
	 * @param quantity
	 */
	public Item(String name, double value, int quantity) {
		// TODO - implement Item.Item
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}

}