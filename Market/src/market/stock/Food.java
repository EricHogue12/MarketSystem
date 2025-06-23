package market.stock;

public class Food {
	
	private String name;
	// stock could either be by total weight (per pound) or quantity of a food
	private boolean byWeight;
	private int stock;
	// price could be per pound or per item depending on byWeight boolean
	private double price;
	
	public Food(String name, boolean byWeight, int stock, double price) {
		if (name == null || "".equals(name)) {
			throw new IllegalArgumentException("Null or empty food name");
		}
		if (stock < 1) {
			throw new IllegalArgumentException("Stock must be greater than zero");
		}
		if (price < 0.25 || price > 200.00) {
			throw new IllegalArgumentException("Price is too extreme");
		}
		if (this instanceof Vegetable) {
			if (Vegetable.vegetableCounter >= Vegetable.MAX_VEGETABLES) {
				throw new IllegalArgumentException("Too many Vegetables");
			}
		}
		else if (this instanceof Fruit) {
			if (Fruit.fruitCounter >= Fruit.MAX_FRUITS) {
				throw new IllegalArgumentException("Too many Fruits");
			}
		}
		
		this.name = name;
		this.byWeight = byWeight;
		this.stock = stock;
		this.price = price;
	}
	
	
	public double getPrice() {
		return price;
	}
	public boolean getByWeight() {
		return byWeight;
	}
	public int getStock() {
		return stock;
	}
	public String getName() {
		return name;
	}
	public void setPrice(double p) {
		price = p;
	}
	
	public void setStock(int s) {
		stock = s;
	}
}
