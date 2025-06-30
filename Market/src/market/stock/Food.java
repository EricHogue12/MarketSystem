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
		else if (this instanceof Meat) {
			if (Meat.meatCounter >= Meat.MAX_MEATS) {
				throw new IllegalArgumentException("Too many Meats");
			}
		}
		else if (this instanceof Dairy) {
			if (Dairy.dairyCounter >= Dairy.MAX_DAIRY) {
				throw new IllegalArgumentException("Too much Dairy");
			}
		}
		else if (this instanceof Bakery) {
			if (Bakery.bakeryCounter >= Bakery.MAX_BAKERY) {
				throw new IllegalArgumentException("Too much Bakery");
			}
		}
		
		setStock(stock);
		setPrice(price);
		this.name = name;
		this.byWeight = byWeight;
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
		if (p < 0.25 || p > 200.00) {
			throw new IllegalArgumentException("Price is too extreme");
		}
		price = p;
	}
	
	public void setStock(int s) {
		if (s < 1) {
			throw new IllegalArgumentException("Stock must be greater than 0");
		}
		stock = s;
	}
}
